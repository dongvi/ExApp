package com.example.exprj.custom_view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.exprj.R;

import java.util.ArrayList;
import java.util.List;

public class BottomMenu extends LinearLayout implements View.OnClickListener {
    ItemBottomMenu home;
    ItemBottomMenu game;
    ItemBottomMenu news;
    ItemBottomMenu person;
    BottomMenuImpl bottomMenuImpl;
    List<ItemBottomMenu> listButton;

    public BottomMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        listButton = new ArrayList<>();

        // Prepare to read the bottom_menu.xml file
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(layoutInflater != null) {
            layoutInflater.inflate(R.layout.bottom_menu, this);

            // call buttons in bottom_menu.xml
            home = findViewById(R.id.btn_home);
            game = findViewById(R.id.btn_game);
            news = findViewById(R.id.btn_news);
            person = findViewById(R.id.btn_person);

            // add buttons to listButton
            addButton(home);
            addButton(game);
            addButton(news);
            addButton(person);

            // turn on button home first
            turnOn(home);
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
    void turnOn(ItemBottomMenu buttonName){
        turnOffAll();
        buttonName.sttOn();
    }

    public void setBottomMenuImpl(BottomMenuImpl bottomMenuImpl) {
        this.bottomMenuImpl = bottomMenuImpl;
    }

    // Set events for bottom menu
    @Override
    public void onClick(View view) {
        ItemBottomMenu button = findViewById(view.getId());
        turnOn(button);
        bottomMenuImpl.getPosition(listButton.indexOf(button));
    }

    // definition of a button
    void addButton(ItemBottomMenu buttonName) {
        buttonName.setOnClickListener(this);
        listButton.add(buttonName);
    }
}
