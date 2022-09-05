package com.jens.kitchen.controller;

import com.jens.kitchen.domain.NewMealRequest;
import com.jens.kitchen.domain.NewMealResponse;
import com.jens.kitchen.model.dtos.MealDto;
import com.jens.kitchen.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/JENsKitchen")
public class MealController {

    @Autowired
    private MealService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public NewMealResponse createNewMeal(@RequestBody NewMealRequest request){
        return service.createMeal(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<MealDto> getAllMeals(){
        return service.getAllMeals();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MealDto getMealById(@PathVariable String id){
        return service.getMealById(id);
    }
}
