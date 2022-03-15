package com.example.exprj.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String LINK = "http://demo5277646.mockable.io/";
    public static Retrofit retrofit = null;

    public static APIClientI create(){
        return getClient(LINK).create(APIClientI.class);
    }

    public static Retrofit getClient(String url){
        if(retrofit == null)
            retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
