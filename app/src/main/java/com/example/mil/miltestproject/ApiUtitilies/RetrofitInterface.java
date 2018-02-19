package com.example.mil.miltestproject.ApiUtitilies;

import com.example.mil.miltestproject.Model.Post;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by mil on 2/15/2018 AD.
 */


//Creating the API interfaces

public interface RetrofitInterface {
/*    @POST("/posts")
    Call<Post> savePost(@Body UserLogin user); //Post อยู่ใน body */

    /*@POST("/posts")
    Call<Post> savePost(@Body Post post);*/

    @POST("/posts")
    Call<Post> savePost(@Body Post post);

}
