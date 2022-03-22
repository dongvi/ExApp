package com.example.exprj.custom_view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.exprj.R;


public class BottomMenu extends LinearLayout {
    private LinearLayout root;
    private BottomMenuListenner bottomMenuListenner;

    public BottomMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // Prepare to read the bottom_menu.xml file
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(layoutInflater != null) {
            layoutInflater.inflate(R.layout.bottom_menu, this);
            root = findViewById(R.id.root);

            for (int i = 0; i < root.getChildCount(); i++) {
                ItemBottomMenu button = (ItemBottomMenu) root.getChildAt(i);
                int finalI = i;
                button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomMenuListenner.onItemClick(finalI);
                        turnOn(button);
                    }
                });
            }

            // turn on button home first
            turnOn((ItemBottomMenu) root.getChildAt(0));
        }
    }

    // set status off for all buttons
    void turnOfAll(){
        for (int i = 0; i < root.getChildCount(); i++)
            ((ItemBottomMenu) root.getChildAt(i)).sttOff();
    }

    // turn on button
    void turnOn(ItemBottomMenu button){
        turnOfAll();
        button.sttOn();
    }


    public void setBottomMenuListenner(BottomMenuListenner bottomMenuListenner) {
        this.bottomMenuListenner = bottomMenuListenner;
    }
}
