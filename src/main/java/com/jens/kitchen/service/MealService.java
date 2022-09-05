package com.jens.kitchen.service;

import com.jens.kitchen.domain.NewMealRequest;
import com.jens.kitchen.domain.NewMealResponse;

public interface MealService {

    public NewMealResponse createMeal(NewMealRequest request);

}
