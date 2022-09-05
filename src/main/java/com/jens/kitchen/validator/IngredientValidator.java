package com.jens.kitchen.validator;

import com.jens.kitchen.exceptions.BadRequestException;
import com.jens.kitchen.model.dtos.IngredientDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientValidator {

    private static final String WRONG_FIELD = "Field %s is empty.";
    private static final String WRONG_LIST = "Ingredients list is empty.";
    private static final String NAME = "'Ingredient Name'";

    public void validate(List<IngredientDto> ingredients){
        validateList(ingredients);

        for(IngredientDto ingredient : ingredients){
            validateIngredientName(ingredient.getName());
        }

    }

    private void validateList(List<IngredientDto> ingredients){
        if(ingredients.size() == 0 || ingredients == null){
            throw new BadRequestException(String.format(WRONG_LIST));
        }
    }

    private void validateIngredientName(String name){
        if(name.isBlank() || name.isEmpty()){
            throw new BadRequestException(String.format(WRONG_FIELD, NAME));
        }
    }

}
