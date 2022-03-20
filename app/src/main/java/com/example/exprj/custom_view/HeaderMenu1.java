package com.example.exprj.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exprj.R;

public class HeaderMenu1 extends RelativeLayout {

    TextView title;
    View item1;
    View item2;

    public HeaderMenu1(Context context) {
        super(context);
    }

    public HeaderMenu1(Context context, AttributeSet attributeSet) {
        super(context);
        // Chuẩn bị đọc tập tin HeaderMenu1.xml
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(layoutInflater != null) {
            layoutInflater.inflate(R.layout.header_menu_1, this);

            // Đọc và lấy về 2 view đã có
            title = findViewById(R.id.tv_title);
            item1 = findViewById(R.id.img_item1);
            item2 = findViewById(R.id.img_item2);

            //Lấy giá trị từ thuộc tính tương ứng trong thẻ http://schemas.android.com/apk/res/android
            String labelTitle = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
            // set title
            if(labelTitle.equals("1")) {
                title.setText(getResources().getString(R.string.title_game));
                item2.setVisibility(GONE);
                item1.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "item 1", Toast.LENGTH_LONG).show();
                    }
                });
            }
            else if(labelTitle.equals("2")) {
                title.setText(getResources().getString(R.string.title_news));
                item1.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "item 3", Toast.LENGTH_LONG).show();
                    }
                });
            }

            // set event cho các nút chức năng ...
//            item1.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(getContext(), "item 1", Toast.LENGTH_LONG).show();
//                }
//            });

            item2.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "item 2", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}