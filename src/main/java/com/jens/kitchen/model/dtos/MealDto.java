package com.jens.kitchen.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "mealDto")
public class MealDto {
    @Id
    private String id;
    private String mealName;
    private List<String> ingredients;
    private List<String> recipeSteps;
}
