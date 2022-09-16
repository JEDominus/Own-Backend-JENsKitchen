package com.jens.kitchen.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
@AllArgsConstructor
public enum Mealtime {
    BREAKFAST,
    LUNCH,
    DINNER
}
