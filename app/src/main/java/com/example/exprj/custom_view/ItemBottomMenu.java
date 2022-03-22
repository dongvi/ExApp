package com.example.exprj.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.exprj.R;

public class ItemBottomMenu extends RelativeLayout {
    TextView title;
    ImageView on;
    ImageView off;

    public ItemBottomMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(layoutInflater != null){
            layoutInflater.inflate(R.layout.item_bottom_menu, this);

            title = findViewById(R.id.title_item_btmenu);
            on = findViewById(R.id.btn_on_btmenu);
            off = findViewById(R.id.btn_off_btmenu);

            // Lấy giá trị từ các thuộc tính cần thiết
            String lable = attrs.getAttributeValue(null, "text");
            int srcOn = attrs.getAttributeResourceValue(null, "srcOn", 0);
            int srcOff = attrs.getAttributeResourceValue(null, "srcOff", 0);

            // set giá trị
            title.setText(lable);
            on.setImageResource(srcOn);
            off.setImageResource(srcOff);
        }
    }

    // Trạng thái off của button
    public void sttOff(){
        on.setVisibility(GONE);
        off.setVisibility(VISIBLE);
        title.setTextColor(getResources().getColor(R.color.white));
    }

    // Trạng thái on của button
    public void sttOn(){
        off.setVisibility(GONE);
        on.setVisibility(VISIBLE);
        title.setTextColor(getResources().getColor(R.color.black));
    }
}
