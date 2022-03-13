package com.example.exprj.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.exprj.R;
import com.example.exprj.databinding.FragmentNewsBinding;

public class FragmentNews extends Fragment {
    FragmentNewsBinding binding;

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

        return binding.getRoot();
    }
}
