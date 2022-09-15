package com.jens.kitchen.validator;

import com.jens.kitchen.domain.NewMealRequest;
import com.jens.kitchen.exceptions.BadRequestError;
import com.jens.kitchen.exceptions.BadRequestException;
import com.jens.kitchen.model.dtos.MealDto;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class MealValidator {
    private static final String EMPTY_FIELD = "Field %s is empty.";
    private static final String BLANK_FIELD = "Field %s is blank.";
    private static final String NULL_FIELD = "Field %s doesn't exist and is required.";
    private static final String BLANK_FIELD_COLLECTION = "Field %s in collection %s is blank.";
    private static final String MEAL_NAME = "'Meal Name'";
    private static final String INGREDIENT = "'Ingredient'";
    private static final String INGREDIENTS = "'Ingredients'";
    private static final String RECIPE_STEPS = "'Recipe Steps'";
    private static final String DESCRIPTION_STEPS = "'Step Description'";

    public void validateRequest(NewMealRequest request){
        List<BadRequestError> errors = new ArrayList<>();

        validateMealName(request.getMealName(), errors);
        validateIngredients(request.getIngredients(), errors);
        validateRecipeSteps(request.getRecipeSteps(), errors);

        validateErrors(errors);
    }

    public void validateRequest(MealDto request){
        List<BadRequestError> errors = new ArrayList<>();

        validateMealName(request.getMealName(), errors);
        validateIngredients(request.getIngredients(), errors);
        validateRecipeSteps(request.getRecipeSteps(), errors);
    }

    private void validateMealName(String mealName, List<BadRequestError> errors){
        if (isNull(mealName)) {
            addError(MEAL_NAME, String.format(NULL_FIELD, MEAL_NAME), errors);
        } else if (mealName.isBlank()) {
            addError(MEAL_NAME, String.format(BLANK_FIELD, MEAL_NAME), errors);
        } else if (mealName.isEmpty()){
            addError(MEAL_NAME, String.format(EMPTY_FIELD, MEAL_NAME), errors);
        }
    }

    private void validateIngredients(List<String> ingredients, List<BadRequestError> errors){
        if (isNull(ingredients)) {
            addError(INGREDIENTS, String.format(NULL_FIELD, INGREDIENTS), errors);
        } else if (ingredients.isEmpty()){
            addError(INGREDIENTS, String.format(EMPTY_FIELD, INGREDIENTS), errors);
        }else{
            for(String ingredient : ingredients){
                if(ingredient.isBlank()){
                    addError(INGREDIENT, String.format(BLANK_FIELD_COLLECTION, INGREDIENT, INGREDIENTS), errors);
                }
            }
        }
    }

    private void validateRecipeSteps(List<String> recipeSteps, List<BadRequestError> errors){
        if (isNull(recipeSteps)) {
            addError(RECIPE_STEPS, String.format(NULL_FIELD, RECIPE_STEPS), errors);
        } else if (recipeSteps.isEmpty()){
            addError(RECIPE_STEPS, String.format(EMPTY_FIELD, RECIPE_STEPS), errors);
        }else{
            for(String recipeStep : recipeSteps){
                if(recipeStep.isBlank()){
                    addError(DESCRIPTION_STEPS, String.format(BLANK_FIELD_COLLECTION, DESCRIPTION_STEPS, RECIPE_STEPS), errors);
                }
            }
        }
    }

    private void addError(String field, String description, List<BadRequestError> errors){
        BadRequestError newError = BadRequestError.builder().
                field(field).
                description(description).
                build();

        errors.add(newError);
    }

    private void validateErrors(List<BadRequestError> errors){
        if(errors.size() > 0){
            throw new BadRequestException("", errors);
        }
    }
}
