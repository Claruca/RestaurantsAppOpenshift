package com.iesemilidarder.RestaurantsApp.controller;
import com.iesemilidarder.RestaurantsApp.core.LlegirBD;
import com.iesemilidarder.RestaurantsApp.core.Restaurant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        String name = "Restaurant";
        LlegirBD dbManager = new LlegirBD();
        List<Restaurant> arrData = dbManager.mostrarRes(StringUtils.EMPTY);


        model.addAttribute("name",name);
        model.addAttribute("list",arrData);
        model.addAttribute("dbManager",dbManager);
        return "index";
    }
}