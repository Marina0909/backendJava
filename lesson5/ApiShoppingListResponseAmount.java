package org.example.lesson5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApiShoppingListResponseAmount {
   private Double amount;
   private String unit;
}
