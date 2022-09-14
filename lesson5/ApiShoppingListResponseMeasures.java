package org.example.lesson5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApiShoppingListResponseMeasures {
    private ApiShoppingListResponseAmount original;
    private ApiShoppingListResponseAmount metric;
    private ApiShoppingListResponseAmount us;
}
