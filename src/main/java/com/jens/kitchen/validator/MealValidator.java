package com.jens.kitchen.validator;

import com.jens.kitchen.domain.NewMealRequest;
import com.jens.kitchen.exceptions.BadRequestException;
import com.jens.kitchen.model.dtos.MealDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealValidator {

    private static final String WRONG_FIELD = "Field %s is empty.";
    private static final String MEAL_NAME = "'Meal Name'";

    @Autowired
    private IngredientValidator ingredientValidator;

    @Autowired
    private RecipeValidator recipeValidator;

    public void validate(NewMealRequest request){
        validateMealName(request.getMealName());

        ingredientValidator.validate(request.getIngredients());
        recipeValidator.validate(request.getRecipe());
    }

    public void validate(MealDto request){
        validateMealName(request.getMealName());

        ingredientValidator.validate(request.getIngredients());
        recipeValidator.validate(request.getRecipe());
    }

    private void validateMealName(String mealName){
        if(mealName.isBlank() || mealName.isEmpty()){
            throw new BadRequestException(String.format(WRONG_FIELD, MEAL_NAME));
        }
    }

}
