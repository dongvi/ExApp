package com.example.exprj;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.exprj.custom_view.BottomMenu;
import com.example.exprj.databinding.ActivityMainBinding;
import com.example.exprj.home.FragmentHome;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ẩn thanh tác vụ
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        turnOnFragment(FragmentHome.newInstance());
    }



    //Khởi động fragment
    public static void turnOnFragment(Fragment fragment){
        fragmentManager.beginTransaction().replace(R.id.container_frag, fragment).commit();
    }

    void addFragment(Fragment fragment){
        fragmentManager.beginTransaction().add(R.id.container_frag, fragment).commit();
    }

}