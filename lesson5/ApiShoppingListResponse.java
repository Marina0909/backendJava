package org.example.lesson5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApiShoppingListResponse {
 private Long id;
 private String name;
 private ApiShoppingListResponseMeasures measures;
 private List<Long> usages;
 private List<Long> usageRecipeIds;
 private Boolean pantryItem;
 private String aisle;
 private Double cost;
 private Long ingredientId;
}
