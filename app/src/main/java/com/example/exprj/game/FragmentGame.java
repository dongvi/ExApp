package com.example.exprj.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.exprj.R;
import com.example.exprj.databinding.FragmentGameBinding;

public class FragmentGame extends Fragment {

    FragmentGameBinding binding;

    public static FragmentGame newInstance() {
        
        Bundle args = new Bundle();

        FragmentGame fragment = new FragmentGame();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game ,container , false);

        return binding.getRoot();
    }
}
