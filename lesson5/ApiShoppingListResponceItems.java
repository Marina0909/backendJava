package org.example.lesson5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApiShoppingListResponceItems {
    private Long id;
    private String name;
    private Boolean pantryItem;
    private String aisle;
    private Double cost;
    private Long ingredientId;

}
