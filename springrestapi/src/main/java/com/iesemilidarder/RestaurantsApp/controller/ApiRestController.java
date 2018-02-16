package com.iesemilidarder.RestaurantsApp.controller;

import com.iesemilidarder.RestaurantsApp.core.Restaurant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping(path = "/rest/api/v1")
public class ApiRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/restaurants",method = RequestMethod.GET)
    public Restaurant restaurant
            (@RequestParam(value="name", defaultValue="restaurant") String name) {
        return new Restaurant(counter.incrementAndGet(),
                String.format(template, name));
    }

//    @RequestMapping(path = "/list",method = RequestMethod.GET)
//    public List<Restaurant> list() {
//        List<Restaurant> arrData = new ArrayList<>();
//        for (int i=0;i<9;i++){
//            arrData.add(new Restaurant (counter.incrementAndGet(),
//                    String.format(template, i)));
//        }
//        return arrData;
//    }

}
