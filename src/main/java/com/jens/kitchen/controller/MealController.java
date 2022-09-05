package com.jens.kitchen.controller;

import com.jens.kitchen.domain.NewMealRequest;
import com.jens.kitchen.domain.NewMealResponse;
import com.jens.kitchen.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/JENsKitchen")
public class MealController {

    @Autowired
    private MealService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/createMeal", consumes = "application/json", produces = "application/json")
    public NewMealResponse createNewMeal(@RequestBody NewMealRequest request){
        return service.createMeal(request);
    }
}
