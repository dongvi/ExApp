package com.example.exprj.person;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exprj.AdapterItem;
import com.example.exprj.R;
import com.example.exprj.databinding.FragmentPersonBinding;

import static com.example.exprj.home.FragmentHome.items;

public class FragmentPerson extends Fragment {
    FragmentPersonBinding binding;

    public static FragmentPerson newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentPerson fragment = new FragmentPerson();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person ,container , false);

        // recyclerView 1
        binding.rclPs1.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.HORIZONTAL, false));
        binding.rclPs1.setAdapter(new AdapterItem(items, R.layout.item_rcl_ngang));

        // recyclerView 2
        binding.rclPs2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.rclPs2.setAdapter(new AdapterItem(items, R.layout.item_rcl_doc));

        // set animation for imageView
        binding.imgPs.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.flicker));

        return binding.getRoot();
    }
}
