package com.example.alien.entertainment.webapi;

import com.example.alien.entertainment.picture.entity.Pic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by Alien on 2016/8/17.
 */
public interface Pictureapi {
    @GET("?key=c11d04d6fed739ed2db78987329e13bb&num=50")
    Call<Pic> getPic();
}
