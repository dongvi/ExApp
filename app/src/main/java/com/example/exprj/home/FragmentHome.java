package com.example.exprj.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.exprj.R;
import com.example.exprj.databinding.FragmentHomeBinding;

public class FragmentHome extends Fragment {
    FragmentHomeBinding binding;

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

        return binding.getRoot();
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
}
