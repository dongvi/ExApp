package com.example.exprj.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.exprj.AdapterItem;
import com.example.exprj.R;
import com.example.exprj.databinding.FragmentGameBinding;

import java.util.ArrayList;
import java.util.List;

public class FragmentGame extends Fragment {

    FragmentGameBinding binding;
    static List<String> menu;

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

        menu = new ArrayList<>();
        addData();

        // Menu game
        binding.rclMenuGame.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rclMenuGame.setAdapter(new AdapterItem(menu, R.layout.item_menu_game));

        return binding.getRoot();
    }

    void addData(){
        menu.add("Game mới");
        menu.add("Game hot tháng");
        menu.add("Game hot");
        menu.add("Game oneline");
        menu.add("Game ABC");
        menu.add("Game XYZ");
        menu.add("...");
    }
}
