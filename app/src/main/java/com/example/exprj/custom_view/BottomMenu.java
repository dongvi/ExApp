package com.example.exprj.custom_view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.exprj.MainActivity;
import com.example.exprj.R;
import com.example.exprj.game.FragmentGame;
import com.example.exprj.home.FragmentHome;
import com.example.exprj.news.FragmentNews;
import com.example.exprj.person.FragmentPerson;

public class BottomMenu extends LinearLayout {

    static ItemBottomMenu home;
    static ItemBottomMenu game;
    static ItemBottomMenu news;
    static ItemBottomMenu person;

    FragmentHome fragmentHome;



    public BottomMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(layoutInflater != null) {
            layoutInflater.inflate(R.layout.bottom_menu, this);

            home = findViewById(R.id.btn_home);
            game = findViewById(R.id.btn_game);
            news = findViewById(R.id.btn_news);
            person = findViewById(R.id.btn_person);

            // first run
            turnOn(home);

            //set event for buttons
            home.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    turnOn(home);
                    MainActivity.turnOnFragment(FragmentHome.newInstance());
                }
            });

            game.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    turnOn(game);
                    MainActivity.turnOnFragment(FragmentGame.newInstance());
                }
            });

            news.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    turnOn(news);
                    MainActivity.turnOnFragment(FragmentNews.newInstance());
                }
            });

            person.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    turnOn(person);
                    MainActivity.turnOnFragment(FragmentPerson.newInstance());
                }
            });
        }
    }

    // đưa toàn bộ các nút về trạng thái off
    void turnOffAll(){
        home.sttOff();
        game.sttOff();
        news.sttOff();
        person.sttOff();
    }
    // set trạng thái on cho 1 nút truyền vào
    void turnOn(ItemBottomMenu x){
        turnOffAll();
        x.sttOn();
    }
}
