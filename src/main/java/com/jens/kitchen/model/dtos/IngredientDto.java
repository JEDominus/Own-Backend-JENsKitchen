package com.jens.kitchen.model.dtos;

import com.jens.kitchen.model.enums.UnitsEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {
    private String name;
    private UnitsEnum unit;
}
