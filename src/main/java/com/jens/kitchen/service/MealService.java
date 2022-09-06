package com.jens.kitchen.service;

import com.jens.kitchen.domain.NewMealRequest;
import com.jens.kitchen.domain.NewMealResponse;
import com.jens.kitchen.model.dtos.MealDto;

import java.util.List;

public interface MealService {

    NewMealResponse createMeal(NewMealRequest request);

    List<com.jens.kitchen.model.dtos.MealDto> getAllMeals();

    com.jens.kitchen.model.dtos.MealDto getMealById(String id);

    MealDto updateMeal(MealDto request, String id);
}
