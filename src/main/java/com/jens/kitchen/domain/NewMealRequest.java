package com.jens.kitchen.domain;

import com.jens.kitchen.model.dtos.IngredientDto;
import com.jens.kitchen.model.dtos.RecipeDto;
import com.jens.kitchen.model.enums.TypesEnum;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class NewMealRequest {
    private String mealName;
    private TypesEnum mealType;
    private List<IngredientDto> ingredients;
    private RecipeDto recipe;
}
