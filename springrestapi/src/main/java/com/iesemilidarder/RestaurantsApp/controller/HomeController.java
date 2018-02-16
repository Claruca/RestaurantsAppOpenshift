package com.iesemilidarder.RestaurantsApp.controller;

import com.iesemilidarder.RestaurantsApp.core.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        String name = "Pepito";
        List<Restaurant> arrData = new ArrayList<>();
        for (int i=0;i<9;i++){
            arrData.add(new Restaurant(i,String.format("John Doe%s", i)));
        }
        //List<Restaurants> arrData2 = ReadDB.getAll();
        model.addAttribute("name",name);
        model.addAttribute("list",arrData);
        //model.addAttribute("restaurantes",ReadDB.getAll());
        //model.addAttribute("db",ReadDB);
        return "index";
    }
}