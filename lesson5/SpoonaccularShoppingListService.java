package org.example.lesson5;


import okhttp3.Response;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class SpoonaccularShoppingListService {

     SpoonaccularApiInterface api;
     static final String API_KEY = "a96c9091e62a49c183828ab44d515dd6";
     static final String USER_NAME = "marina-mm081";
     static final String HASH = "78e82572fb72ec08305e480e90e1695a2fa981ba";

     static final String BASE_URL = "https://api.spoonacular.com/";

    public SpoonaccularShoppingListService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(SpoonaccularApiInterface.class);
    }
    public ApiShoppingListResponse createShoppingList(@Body ApiShoppingListRequest request){
        Call<ApiShoppingListResponse> call = api.createShoppingList(request, USER_NAME, API_KEY, HASH );
        return RetrofitUtils.execute(call);
    }

    public ApiShoppingListResponseFull readShoppingList(){
        Call<ApiShoppingListResponseFull> call = api.readShoppingList(USER_NAME, API_KEY, HASH);
        return RetrofitUtils.execute(call);
    }
    public ResponseBody deleteShoppingId(Long id){
        //Response<ResponseBody> response = productService.deleteProduct(id).execute();

        Call<ResponseBody> call = api.deleteFromShoppingList(USER_NAME, id, API_KEY, HASH);
        return RetrofitUtils.execute(call);
    }

}
