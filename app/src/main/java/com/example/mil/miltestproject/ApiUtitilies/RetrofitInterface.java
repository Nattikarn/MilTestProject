package com.example.mil.miltestproject.ApiUtitilies;

import com.example.mil.miltestproject.Model.Post;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by mil on 2/15/2018 AD.
 */


//Creating the API interfaces

public interface RetrofitInterface {
/*    @POST("/posts")
    Call<Post> savePost(@Body UserLogin user); //Post อยู่ใน body */

    @POST("/posts")
    Call<Post> savePost(@Body Post post);

    @GET("/posts/{userId}")
    Call<Post> viewPostUserId(@Path("userId") int userId);

    @GET("/posts")
    rx.Observable<Post> getAnswers(@Path("userId") int userId);

}
