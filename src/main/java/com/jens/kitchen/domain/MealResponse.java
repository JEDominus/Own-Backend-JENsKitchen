package com.jens.kitchen.domain;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MealResponse {
    private String id;
}
