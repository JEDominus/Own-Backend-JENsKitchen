package com.jens.kitchen.service.implementation;

import com.jens.kitchen.domain.NewMealRequest;
import com.jens.kitchen.domain.NewMealResponse;
import com.jens.kitchen.model.dtos.MealDto;
import com.jens.kitchen.repository.MealRepository;
import com.jens.kitchen.service.MealService;
import com.jens.kitchen.validator.MealValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImplementation implements MealService {

    @Autowired
    private MealValidator validator;

    @Autowired
    private MealRepository repository;

    @Override
    public NewMealResponse createMeal(NewMealRequest request) {
        validator.validate(request);

        MealDto meal = MealDto.builder().
                mealName(request.getMealName()).
                mealType(request.getMealType()).
                ingredients(request.getIngredients()).
                recipe(request.getRecipe()).
                build();

        MealDto savedMeal = repository.save(meal);

        return new NewMealResponse(savedMeal.getId());
    }

}
