package com.jens.kitchen.service;

import com.jens.kitchen.domain.NewMealRequest;
import com.jens.kitchen.domain.NewMealResponse;
import com.jens.kitchen.model.dtos.MealDto;

import java.util.List;

public interface MealService {

    NewMealResponse createMeal(NewMealRequest request);

    List<MealDto> getAllMeals();

}
