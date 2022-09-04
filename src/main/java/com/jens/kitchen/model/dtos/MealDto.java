package com.jens.kitchen.model.dtos;

import com.jens.kitchen.model.enums.TypesEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class MealDto {
    private String mealName;
    private TypesEnum mealType;
    private List<IngredientDto> ingredients;
    private RecipeDto recipe;
}
