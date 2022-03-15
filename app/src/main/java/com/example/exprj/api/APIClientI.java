package com.example.exprj.api;

import com.example.exprj.home.Banner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIClientI {
    @GET("banners")
    Call<List<Banner>> onGetBanners();
}
