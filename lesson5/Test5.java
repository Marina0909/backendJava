package org.example.Lesson5;

import okhttp3.ResponseBody;
import org.example.lesson5.ApiShoppingListRequest;
import org.example.lesson5.ApiShoppingListResponse;
import org.example.lesson5.ApiShoppingListResponseFull;
import org.example.lesson5.SpoonaccularShoppingListService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.Objects;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test5 {
    SpoonaccularShoppingListService spoonaccularShoppingListService = new SpoonaccularShoppingListService();
    static Long id;

    @Order(1)
    @Test
    void newList(){
        ApiShoppingListRequest request = new ApiShoppingListRequest();
        request.setAisle("Cheese");
        request.setItem("1 pkg parmesan cheese");
        request.setParse(true);
        System.out.println(request);
        ApiShoppingListResponse newShoppingList = spoonaccularShoppingListService.createShoppingList(request);
        System.out.println(newShoppingList);
        id = newShoppingList.getId();
        assert Objects.equals(newShoppingList.getName(), "parmesan cheese");
    }

    @Order(2)
    @Test
    void getList(){
        ApiShoppingListResponseFull readShoppingList = spoonaccularShoppingListService.readShoppingList();
        System.out.println(readShoppingList);
        assert Objects.equals(readShoppingList.getAisles().get(0).getAisle(), "Cheese" );
    }

    @Order(3)
    @Test
    void deleteId() {
        ResponseBody deleteShoppingId = spoonaccularShoppingListService.deleteShoppingId(id);
   }

}
