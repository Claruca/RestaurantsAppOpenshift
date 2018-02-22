package com.iesemilidarder.RestaurantsApp.controller;

import com.iesemilidarder.RestaurantsApp.core.LlegirBD;
import com.iesemilidarder.RestaurantsApp.core.Restaurant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/rest/api/v1")
public class ApiRestController {


    @RequestMapping(path = "/restaurants", method = RequestMethod.GET)
    public List<Restaurant> list() {

        LlegirBD dbManager = new LlegirBD();
        List<Restaurant> arrData = dbManager.getRestaurants(false);
        return arrData;
    }

}
