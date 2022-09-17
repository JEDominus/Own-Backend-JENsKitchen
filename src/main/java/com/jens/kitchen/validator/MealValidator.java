package com.jens.kitchen.validator;

import com.jens.kitchen.domain.MealRequest;
import com.jens.kitchen.exceptions.ApiError;
import com.jens.kitchen.exceptions.BadRequestException;
import com.jens.kitchen.model.enums.Mealtime;
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
    private static final String MEAL_TIME = "'Time'";
    private static final String MEAL_NAME = "'Name'";
    private static final String INGREDIENT = "'Ingredient'";
    private static final String INGREDIENTS = "'Ingredients'";
    private static final String RECIPE_STEPS = "'Recipe Steps'";
    private static final String DESCRIPTION_STEPS = "'Step Description'";

    public void validateRequest(MealRequest request){
        List<ApiError> errors = new ArrayList<>();

        validateMealtime(request.getTime(), errors);
        validateMealName(request.getName(), errors);
        validateIngredients(request.getIngredients(), errors);
        validateRecipeSteps(request.getRecipeSteps(), errors);

        validateErrors(errors);
    }

    private void validateMealtime(Mealtime mealtime, List<ApiError> errors){
        if (isNull(mealtime)) {
            addError(MEAL_TIME, String.format(NULL_FIELD, MEAL_TIME), errors);
        }
    }

    private void validateMealName(String mealName, List<ApiError> errors){
        if (isNull(mealName)) {
            addError(MEAL_NAME, String.format(NULL_FIELD, MEAL_NAME), errors);
        } else if (mealName.isBlank()) {
            addError(MEAL_NAME, String.format(BLANK_FIELD, MEAL_NAME), errors);
        } else if (mealName.isEmpty()){
            addError(MEAL_NAME, String.format(EMPTY_FIELD, MEAL_NAME), errors);
        }
    }

    private void validateIngredients(List<String> ingredients, List<ApiError> errors){
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

    private void validateRecipeSteps(List<String> recipeSteps, List<ApiError> errors){
        if (!isNull(recipeSteps)) {
            if (recipeSteps.isEmpty()){
                addError(RECIPE_STEPS, String.format(EMPTY_FIELD, RECIPE_STEPS), errors);
            }else{
                for(String recipeStep : recipeSteps){
                    if(recipeStep.isBlank()){
                        addError(DESCRIPTION_STEPS, String.format(BLANK_FIELD_COLLECTION, DESCRIPTION_STEPS, RECIPE_STEPS), errors);
                    }
                }
            }
        }
    }

    private void addError(String field, String description, List<ApiError> errors){
        ApiError newError = ApiError.builder().
                field(field).
                description(description).
                build();

        errors.add(newError);
    }

    private void validateErrors(List<ApiError> errors){
        if(errors.size() > 0){
            throw new BadRequestException("", errors);
        }
    }
}
