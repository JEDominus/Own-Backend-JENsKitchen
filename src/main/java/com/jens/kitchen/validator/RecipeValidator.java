package com.jens.kitchen.validator;

import com.jens.kitchen.exceptions.BadRequestException;
import com.jens.kitchen.model.dtos.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeValidator {

    private static final String WRONG_FIELD = "Field %s is empty.";
    private static final String RECIPE = "'Recipe'";

    @Autowired
    private StepValidator stepValidator;

    public void validate(RecipeDto recipe){
        validateRecipe(recipe);

        stepValidator.validate(recipe.getSteps());
    }

    private void validateRecipe(RecipeDto recipe){
        if(recipe == null){
            throw new BadRequestException(String.format(WRONG_FIELD, RECIPE));
        }
    }

}
