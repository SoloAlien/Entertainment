package com.example.alien.entertainment.net;

import com.example.alien.entertainment.webapi.Pictureapi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alien on 2016/8/17.
 */
public class NetClient {
    private static String URL="http://api.tianapi.com/meinv/";
    private static NetClient netClient;
    private Retrofit retrofit;
    private Gson gson;
    private Pictureapi pictureapi;
    private NetClient(){
        gson=new GsonBuilder().setLenient().create();
        retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static NetClient getNetClient(){
        if (netClient==null){
            netClient=new NetClient();
        }
        return netClient;
    }
    public Pictureapi getPictureapi(){
        if (pictureapi==null){
            pictureapi=retrofit.create(Pictureapi.class);
        }
        return pictureapi;
    }
}
