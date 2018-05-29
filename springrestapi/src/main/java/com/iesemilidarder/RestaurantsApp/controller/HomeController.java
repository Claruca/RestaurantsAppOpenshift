package com.iesemilidarder.RestaurantsApp.controller;

import com.iesemilidarder.RestaurantsApp.core.LlegirBD;
import com.iesemilidarder.RestaurantsApp.core.Restaurant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        String name = "Restaurants";
        LlegirBD dbManager = new LlegirBD();
        List<Restaurant> arrData = dbManager.mostrarRes(StringUtils.EMPTY);
        model.addAttribute("name", name);
        model.addAttribute("list", arrData); //Llamamos a la lista array
        model.addAttribute("dbManager", dbManager);
        return "index"; //redirecciona al index.ftl, en este caso
    }
}