package org.example.lesson5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiShoppingListRequest {
    private String item;
    private String aisle;
    private boolean parse;

}
