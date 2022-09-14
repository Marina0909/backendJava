package org.example.lesson5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


// POJO !
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiShoppingListResponseFull {

        private List<ApiShoppingListResponseAisles> aisles;
        private Double cost;
        private Long startDate;
        private Long endDate;
}
