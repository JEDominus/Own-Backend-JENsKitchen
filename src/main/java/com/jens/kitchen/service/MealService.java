package com.jens.kitchen.service;

import com.jens.kitchen.domain.MealRequest;
import com.jens.kitchen.domain.MealResponse;
import com.jens.kitchen.model.dtos.MealDto;

import java.util.List;

public interface MealService {

    MealResponse createMeal(MealRequest request);

    List<MealDto> getAllMeals();

    List<MealDto> getAllMealsByTime(String time);

    MealDto getMealById(String id);

    MealDto updateMeal(MealRequest request, String id);

    void deleteMeal(String id);

    List<String> getWeeklyMeals(String time, int number);
}
