package com.example.exprj.news;

import android.widget.ImageView;

public class News {
    private ImageView img;
    private String title;
    private String date;

    public News(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public ImageView getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

}
