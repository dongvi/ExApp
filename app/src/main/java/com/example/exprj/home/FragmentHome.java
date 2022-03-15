package com.example.exprj.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exprj.AdapterItem;
import com.example.exprj.R;
import com.example.exprj.api.APIClient;
import com.example.exprj.databinding.FragmentHomeBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHome extends Fragment {
    FragmentHomeBinding binding;
    static List<Banner> banners;
    static List<String> items;

    public static FragmentHome newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentHome fragment = new FragmentHome();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home ,container , false);

        binding.btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuHome(binding);
            }
        });

        banners = new ArrayList<>();
        //Lấy ảnh từ mạng
        getAPI();

        //Set dữ liệu cứng cho list Items
        items = new ArrayList<>();
        addData();


        //Set item cho recyclerView 1
        binding.rclHome1.setLayoutManager(new LinearLayoutManager(getContext(),  RecyclerView.HORIZONTAL, false));
        binding.rclHome1.setAdapter(new AdapterItem(items, R.layout.item_rcl_ngang));

        //set item cho recyclerView 2
        binding.rclHome2.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        binding.rclHome2.setAdapter(new AdapterItem(items, R.layout.item_rcl_doc));

        return binding.getRoot();
    }

    public void getAPI(){
        Call<List<Banner>> callBanner = APIClient.create().onGetBanners();
        callBanner.enqueue(new Callback<List<Banner>>() {
            @Override
            public void onResponse(Call<List<Banner>> call, Response<List<Banner>> response) {
                banners = response.body();

                for(Banner i : banners){
                    ImageView view = new ImageView(getContext());
                    view.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.get().load(i.getImg()).into(view);
                    binding.containerBanners.addView(view);
                }
            }

            @Override
            public void onFailure(Call<List<Banner>> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    // Xây dựng menu nhỏ cho home
    void menuHome(FragmentHomeBinding binding){
        PopupMenu popupMenu = new PopupMenu(getContext(), binding.btnPopupMenu);
        popupMenu.inflate(R.menu.menu_home);

        Menu menu = popupMenu.getMenu();
        //set sự kiện cho mỗi chức năng trong menu

        //

        popupMenu.show();
    }

    void addData(){
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");
        items.add("F");
        items.add("G");
        items.add("H");
        items.add("I");
        items.add("K");
        items.add("L");
        items.add("M");
        items.add("N");
        items.add("O");
        items.add("P");
        items.add("Q");
        items.add("R");
        items.add("S");
        items.add("U");
        items.add("V");
        items.add("1");
        items.add("2");
        items.add("3");
        items.add("4");
        items.add("5");
        items.add("7");
        items.add("6");
        items.add("8");
        items.add("9");
        items.add("10");
    }
}
