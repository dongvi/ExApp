package com.example.exprj.custom_view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.exprj.R;

public class BottomMenu extends LinearLayout implements View.OnClickListener {
    ItemBottomMenu home;
    ItemBottomMenu game;
    ItemBottomMenu news;
    ItemBottomMenu person;
    IClick click;

    public BottomMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // Prepare to read the bottom_menu.xml file
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(layoutInflater != null) {
            layoutInflater.inflate(R.layout.bottom_menu, this);

            // read buttons from bottom_menu.xml file
            home = findViewById(R.id.btn_home);
            game = findViewById(R.id.btn_game);
            news = findViewById(R.id.btn_news);
            person = findViewById(R.id.btn_person);

            // first run
            turnOn(home);

            //set event for buttons
//            home.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    turnOn(home);
//                    click.btnTag(1);
//                }
//            });
//
//            game.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    turnOn(game);
//                    click.btnTag(2);
//                }
//            });
//
//            news.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    turnOn(news);
//                    click.btnTag(3);
//                }
//            });
//
//            person.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    turnOn(person);
//                    click.btnTag(4);
//                }
//            });

            // setOnclicklistenner
            home.setOnClickListener(this);
            game.setOnClickListener(this);
            news.setOnClickListener(this);
            person.setOnClickListener(this);
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

    public void setClick(IClick click) {
        this.click = click;
    }

    // Set events for bottom menu
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_home:
                turnOn(home);
                click.btnTag(1);
                break;
            case R.id.btn_game:
                turnOn(game);
                click.btnTag(2);
                break;
            case R.id.btn_news:
                turnOn(news);
                click.btnTag(3);
                break;
            case R.id.btn_person:
                turnOn(person);
                click.btnTag(4);
                break;
            default: break;
        }
    }
}
