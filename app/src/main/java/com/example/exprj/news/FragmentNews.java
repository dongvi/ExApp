package com.example.exprj.news;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.exprj.AdapterItem;
import com.example.exprj.MainActivity;
import com.example.exprj.R;
import com.example.exprj.databinding.FragmentNewsBinding;
import com.example.exprj.game.AdapterPager;
import com.example.exprj.game.FragmentGame;

import java.util.ArrayList;
import java.util.List;

import static com.example.exprj.home.FragmentHome.banners;
import static com.example.exprj.home.FragmentHome.items;

public class FragmentNews extends Fragment {
    public static final String TAG = FragmentNews.class.getName();
    FragmentNewsBinding binding;
    List<News> news;
    MainActivity mainActivity;

    //auto viewpager
    private Handler handler;
    private int timeDelay = 3000;
    private int page = 0;
    AdapterCarousel adapterCarousel;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (adapterCarousel.getCount() == page)
                page = 0;
            else
                page++;
            binding.crsNews.setCurrentItem(page);
            handler.postDelayed(this, timeDelay);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false);

        news = new ArrayList<>();
        addData();

        // Recycler 1: daily News
        binding.rclNews1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.rclNews1.setAdapter(new AdapterNews(news));

        // Recycler 2: Maybe you know
        binding.rclNews2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        binding.rclNews2.setAdapter(new AdapterItem(items, R.layout.item_rcl_ngang));

        // carousel
        handler = new Handler();
        adapterCarousel = new AdapterCarousel(getContext(), banners);
        binding.crsNews.setAdapter(adapterCarousel);
        binding.crsNews.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

        binding.idcNews.setViewPager(binding.crsNews);
        adapterCarousel.registerDataSetObserver(binding.idcNews.getDataSetObserver());

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

    void addData() {
        news.add(new News("Yo!!!", "11-12-2021"));
        news.add(new News("If you love someone.", "15-12-2021"));
        news.add(new News("You're going to", "16-12-2021"));
        news.add(new News("lose them.", "17-12-2021"));
        news.add(new News("Sometime.", "18-12-2021"));
        news.add(new News("Somehow.", "19-12-2021"));
        news.add(new News("Do u think so???", "20-12-2021"));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            mainActivity.onFragmentSelected(2, TAG);
        }
    }
}
