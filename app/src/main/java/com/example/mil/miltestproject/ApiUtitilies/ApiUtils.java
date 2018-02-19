package com.example.mil.miltestproject.ApiUtitilies;

/**
 * Created by mil on 2/15/2018 AD.
 */

public class ApiUtils {

    private ApiUtils() {

    }

    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";

    public static RetrofitInterface getRetrofitInterface() {

        return RetroClient.getClient(BASE_URL).create(RetrofitInterface.class);
    }
}
