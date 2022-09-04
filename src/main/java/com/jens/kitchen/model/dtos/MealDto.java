package com.jens.kitchen.model.dtos;

import com.jens.kitchen.model.enums.TypesEnum;

import java.util.List;

public class MealDto {
    private String id;
    private String mealName;
    private TypesEnum mealType;
    private List<IngredientDto> ingredients;
    private RecipeDto recipe;
}
