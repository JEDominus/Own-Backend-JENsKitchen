package com.jens.kitchen.model.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jens.kitchen.model.enums.Mealtime;
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
@Document(collection = "Meals")
@JsonInclude(Include.NON_NULL)
public class MealDto {
    @Id
    private String id;
    private Mealtime time;
    private String name;
    private List<String> ingredients;
    private List<String> recipeSteps;
}
