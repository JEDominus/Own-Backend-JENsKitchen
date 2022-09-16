package com.jens.kitchen.controller;

import com.jens.kitchen.domain.MealRequest;
import com.jens.kitchen.domain.MealResponse;
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
    public MealResponse createNewMeal(@RequestBody MealRequest request){
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

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public MealDto updateMeal(@RequestBody MealRequest request, @PathVariable String id){
        return service.updateMeal(request, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteMeal(@PathVariable String id){
        service.deleteMeal(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/{number}")
    public List<String> getListOfWeekMeals(@PathVariable int number){
        return service.mealsSelector(number);
    }
}
