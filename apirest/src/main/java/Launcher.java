import com.fasterxml.jackson.databind.ObjectMapper;
import com.iesemilidarder.RestaurantsApp.core.DBObject;
import com.iesemilidarder.RestaurantsApp.core.LlegirBD;
import com.iesemilidarder.RestaurantsApp.core.Restaurant;
import com.iesemilidarder.RestaurantsApp.core.User;
import freemarker.template.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Launcher {
    private static List<User> lUser = new ArrayList<User>();
    private static final Logger log = LoggerFactory.getLogger(Launcher.class);

    private static void init() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("a" + i);
            user.save();
            lUser.add(user);
        }
        DBObject dbo = lUser.get(0);
        log.info("Loading finished");
    }



    private static boolean shouldReturnHtml(Request request) {
        String accept = request.headers("Accept");
        return StringUtils.contains(accept, "text/html");
        //return accept != null && accept.contains("text/html");
    }

    private static void setResponseHeader(Response response, boolean isHtml) {
        response.status(200);
        response.type(isHtml ? "text/html" : "application/json");
    }

    private static FreeMarkerEngine getFreemarkerEngine() {
        //as https://freemarker.apache.org/docs/pgui_quickstart_createconfiguration.html
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
            cfg.setClassForTemplateLoading(Launcher.class, "/templates");
            FreeMarkerEngine freemarker = new FreeMarkerEngine(cfg);
            return freemarker;
        } catch (Exception e) {
            log.error("Loading Freemarker Engine, loading default configuration", e);
            return new FreeMarkerEngine();
        }
    }

    public static void main(String... args) {
        staticFiles.location("/public");
        init();
        port(8090);
        /*
        if (localhost) {
            String projectDir = System.getProperty("user.dir");
            String staticDir = "/src/main/resources/public";
            staticFiles.externalLocation(projectDir + staticDir);
        } else {
            staticFiles.location("/public");
        }*/
        //hello world for dummies, via lambdas
        get("/hello", (req, res) -> "Hello World");
        //json response way1: via spark renderer
        /*get("/json", "application/json", (request, response) -> {
            User user = new User();
            user.setName("Hello world!");
            return user;
        }, new JsonTransformer());*/
        //biconditional response way2: via jackson

        get("/users", (request, response) -> {
            if (shouldReturnHtml(request)) {
                Map<String, Object> model = new HashMap<>();
                model.put("posts", lUser);
                model.put("title", "Users");
                model.put("subtitle", "List of all users");
                return getFreemarkerEngine().render(
                        new ModelAndView(model, "basicView.ftl")
                );
            } else {
                CorsFilter.apply();
                ObjectMapper mapper = new ObjectMapper();
                setResponseHeader(response, false);
                return mapper.writeValueAsString(lUser);
            }
        });
        get("/restaurants", (request, response) -> {
            LlegirBD dbHelper = new LlegirBD();
            List<Restaurant> rtn = dbHelper.getRestaurants(StringUtils.EMPTY);
            if (shouldReturnHtml(request)) {
                Map<String, Object> model = new HashMap<>();
                model.put("posts", rtn);
                model.put("title", "Users");
                model.put("subtitle", "List of all users");
                return getFreemarkerEngine().render(
                        new ModelAndView(model, "templates/basicViewRest.ftl")
                );
            } else {
                CorsFilter.apply();
                ObjectMapper mapper = new ObjectMapper();
                setResponseHeader(response, false);
                return mapper.writeValueAsString(rtn);
            }
        });
    }

}