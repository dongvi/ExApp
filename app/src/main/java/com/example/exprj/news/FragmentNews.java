package com.example.exprj.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exprj.R;
import com.example.exprj.databinding.FragmentNewsBinding;

import java.util.ArrayList;
import java.util.List;

public class FragmentNews extends Fragment {
    FragmentNewsBinding binding;
    List<News> news;

    public static FragmentNews newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentNews fragment = new FragmentNews();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news ,container , false);

        news = new ArrayList<>();
        addData();

        // Recycler 1: daily News
        binding.rclNews1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.rclNews1.setAdapter(new AdapterNews(news));

        return binding.getRoot();
    }

    void addData(){
        news.add(new News("Yo!!!", "11-12-2021"));
        news.add(new News("If you love someone.", "15-12-2021"));
        news.add(new News("You're going to", "16-12-2021"));
        news.add(new News("lose them.", "17-12-2021"));
        news.add(new News("Sometime.", "18-12-2021"));
        news.add(new News("Somehow.", "19-12-2021"));
        news.add(new News("Do u think so???", "20-12-2021"));
    }
}
