package com.example.exprj.game;

import static com.example.exprj.home.FragmentHome.banners;
import static com.example.exprj.home.FragmentHome.items;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.exprj.AdapterItem;
import com.example.exprj.MainActivity;
import com.example.exprj.R;
import com.example.exprj.databinding.FragmentGameBinding;

import java.util.ArrayList;
import java.util.List;

public class FragmentGame extends Fragment {
    public static final String TAG = FragmentGame.class.getName();
    FragmentGameBinding binding;
    static List<String> menu;
    MainActivity mainActivity;

    //auto viewpager
    private Handler handler;
    private int timeDelay = 3000;
    private int page = 0;
    AdapterPager adapterPager;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(adapterPager.getCount() == page)
                page = 0;
            else
                page++;
            binding.vpgGame.setCurrentItem(page);
            handler.postDelayed(this, timeDelay);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game ,container , false);

        menu = new ArrayList<>();
        addData();

        //header menu

        // Menu game
        binding.rclMenuGame.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rclMenuGame.setAdapter(new AdapterItem(menu, R.layout.item_menu_game));

        // Viewpager
        handler = new Handler();
        adapterPager = new AdapterPager(getContext(), banners);
        binding.vpgGame.setAdapter(adapterPager);
        binding.vpgGame.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // RecyclerView 2
        binding.rclGame.setLayoutManager(new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false));
        binding.rclGame.setAdapter(new AdapterItem(items, R.layout.item_rcl_doc));

        mainActivity = (MainActivity) getActivity();

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable, timeDelay);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    void addData(){
        menu.add("Game m???i");
        menu.add("Game hot th??ng");
        menu.add("Game hot");
        menu.add("Game oneline");
        menu.add("Game ABC");
        menu.add("Game XYZ");
        menu.add("...");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            mainActivity.onFragmentSelected(1, TAG);
        }
    }
}
