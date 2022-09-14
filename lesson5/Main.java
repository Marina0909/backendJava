package org.example.lesson5;

import okhttp3.ResponseBody;

public class Main {
    public static void main(String[] args) {
        SpoonaccularShoppingListService spoonaccularShoppingListService = new SpoonaccularShoppingListService();

        ApiShoppingListRequest request = new ApiShoppingListRequest();
        request.setAisle("Cheese");
        request.setItem("1 pkg parmesan cheese");
        request.setParse(true);
        System.out.println(request);
        ApiShoppingListResponse newShoppingList = spoonaccularShoppingListService.createShoppingList(request);
        System.out.println(newShoppingList);
        long id = newShoppingList.getId();
        System.out.println(id);
        ApiShoppingListResponseFull readShoppingList = spoonaccularShoppingListService.readShoppingList();
        System.out.println(readShoppingList);
        ResponseBody deleteShoppingId = spoonaccularShoppingListService.deleteShoppingId(id);
    }
}
