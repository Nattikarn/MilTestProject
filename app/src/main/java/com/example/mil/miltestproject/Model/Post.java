package com.example.mil.miltestproject.Model;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mil on 2/15/2018 AD.
 */

public class Post {

    @SerializedName("title") //@serializedName เป็น annotation ของ GSON ในการทำการ Map JSON key ใน java object
    @Expose // เป็น Annotation ที่จะทำการชี้ไที่ class member
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "Post{" +
                "title='" + this.title + '\'' +
                ", body='" + this.body + '\'' +
                ", userId=" + this.userId +
                ", id=" + this.id +
                '}';
    }
}
