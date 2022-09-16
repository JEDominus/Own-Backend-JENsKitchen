package com.jens.kitchen.domain;

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
    private List<String> ingredients;
    //private List<String> recipeSteps;
}
