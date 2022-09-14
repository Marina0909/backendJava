package org.example.lesson5;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface SpoonaccularApiInterface {
    @POST("/mealplanner/{username}/shopping-list/items")
    Call<ApiShoppingListResponse> createShoppingList(
            @Body ApiShoppingListRequest request,
            @Path("username") String username,
            @Query("apiKey") String apiKey,
            @Query("hash") String hash);

    @GET("/mealplanner/{username}/shopping-list")
    Call<ApiShoppingListResponseFull> readShoppingList(
            @Path("username") String username,
            @Query("apiKey") String apiKey,
            @Query("hash") String hash);
    @DELETE("/mealplanner/{username}/shopping-list/items/{id}")
    Call<ResponseBody> deleteFromShoppingList(
            @Path("username") String username,
            @Path("id") Long id,
            @Query("apiKey") String apiKey,
            @Query("hash") String hash);

}
