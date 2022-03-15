package com.example.exprj.game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.exprj.R;
import com.example.exprj.home.Banner;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class AdapterPager extends PagerAdapter {
    //context object
    Context context;

    // List img
    List<Banner> banners;

    // Layout inflater
    LayoutInflater layoutInflater;

    // Constructer
    public AdapterPager(Context context, List<Banner> banners) {
        this.context = context;
        this.banners = banners;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return banners.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // inflating the item_vpg_game.xml
        View itemView = layoutInflater.inflate(R.layout.item_vpg_game, container, false);

        // referencing the image view from the item_vpg_game.xml file
        ImageView imgView = itemView.findViewById(R.id.img_vpg_game);

        // use picasso to load image on network then setting the image in the imageView
        Picasso.get().load(banners.get(position).getImg()).into(imgView);

        // removeView on the child's parent first
        if(imgView.getParent() != null)
            ((ViewGroup) imgView.getParent()).removeView(imgView);

        // adding the view
        Objects.requireNonNull(container).addView(imgView);

        return imgView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


}
