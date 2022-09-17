package com.jens.kitchen.domain;

import com.jens.kitchen.model.enums.Mealtime;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class MealRequest {
    private Mealtime time;
    private String name;
    private List<String> ingredients;
    private List<String> recipeSteps;
}
