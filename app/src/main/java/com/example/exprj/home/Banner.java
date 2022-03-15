package com.example.exprj.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banner {
    @SerializedName("img")
    @Expose
    private String img;

    public String getImg() {
        return img;
    }
}
