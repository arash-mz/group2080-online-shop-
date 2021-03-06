package com.appnita.digikala.retrofit.retrofit;

import com.appnita.digikala.buy.RequestBuy;
import com.appnita.digikala.retrofit.pojoPosts.ResponsePosts;
import com.appnita.digikala.retrofit.pojoProductCategory.ResponseProductCategory;
import com.appnita.digikala.retrofit.pojoProducts.ResponseProduct;
import com.appnita.digikala.retrofit.pojoid.ResponseId;
import com.appnita.digikala.test.BuyProduct;
import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

public interface ApiService {

    @GET("products")
    Call<List<WooRetrofit>> getLastArticle();

    @POST("create_user")
    Call<RegisterCondition> creat (@Body RequestBody body);

    @POST("login_user")
    Call<LoginRetrofit> login (@Body RequestBody body);

    @POST("send_otp")
    Call<Verifycode> sendOtp (@Query("countrycode") String countryCode,
                              @Query("mobileNo") String mobileNo,
                              @Query("type") String type,
                              @Query("username") String username);

    @POST("verify_otp")
    Call<Verifycode> verifyOtp (@Query("countrycode") String countryCode,
                                     @Query("mobileNo") String mobileNo,
                                     @Query("type") String type,
                                     @Query("otp") String username);

    @GET("customers")
    Call<List<ResponseId>> getid (@Query("search") String search);

    @POST("get_posts")
    Call<NewsRetrofit> news ();

    @POST("get_category_posts")
    Call<NewsRetrofit> notification (@Query("id") int id);

    @GET("products")
    Call<List<ResponseProduct>> getProducts();

    @GET("products")
    Call<List<ResponseProduct>> getProductsByCategory(@Query("category") int id);

    @GET("get_category_posts")
    Call<ResponsePosts> getPostsCategory(@Query("id") int id);

    @GET("products/categories")
    Call<List<ResponseProductCategory>> getProductsCategory(@Query("parent") int parent);

    @GET("products")
    Call<List<ResponseProduct>> getProductsBasket(@Query("include[]") List<Integer> id);

    @GET("orders")
    Call<List<BuyProduct>> getCustomerProduct(@Query("customer") int id);

    @Streaming
    @GET(".")
    Call<ResponseBody> downloadFileByUrl(@Query("email") String email,
                                         @Query("download_file") int downloadFile,
                                         @Query("order") String order,
                                         @Query("key") String key);

    @Headers("Content-Type: application/json")
    @POST("orders")
    Call<RequestBuy> buyRequest(@Body JsonObject RequestBuy);

}
