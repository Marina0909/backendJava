package org.example.lesson5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApiShoppingListResponseAisles {
    private String aisle;
    private List<ApiShoppingListResponse> items;

}
