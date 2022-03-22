package com.example.exprj;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.exprj.custom_view.BottomMenu;
import com.example.exprj.custom_view.BottomMenuImpl;
import com.example.exprj.custom_view.ItemBottomMenu;
import com.example.exprj.databinding.ActivityMainBinding;
import com.example.exprj.game.FragmentGame;
import com.example.exprj.home.FragmentHome;
import com.example.exprj.news.FragmentNews;
import com.example.exprj.person.FragmentPerson;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    static FragmentManager fragmentManager;
    BottomMenu bottomMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ẩn thanh tác vụ
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // set binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // FragmentManager get support
        fragmentManager = getSupportFragmentManager();

        // init fragments
        FragmentHome fragmentHome = new FragmentHome();
        FragmentGame fragmentGame = new FragmentGame();
        FragmentNews fragmentNews = new FragmentNews();
        FragmentPerson fragmentPerson = new FragmentPerson();

        // turn on fragment home first
        turnOnFragment(fragmentHome);

        // call bottom menu in activity_main.xml
        bottomMenu = binding.menuBar;

        // catch events bottom menu
        bottomMenu.setBottomMenuImpl(new BottomMenuImpl() {
            @Override
            public void getPosition(int position) {
                switch (position){
                    case 0: turnOnFragment(fragmentHome); break;
                    case 1: turnOnFragment(fragmentGame); break;
                    case 2: turnOnFragment(fragmentNews); break;
                    case 3: turnOnFragment(fragmentPerson); break;
                    default: break;
                }
            }
        });

    }



    //Khởi động fragment
    public static void turnOnFragment(Fragment fragment){
        fragmentManager.beginTransaction().replace(R.id.container_frag, fragment).commit();
    }

    void addFragment(Fragment fragment){
        fragmentManager.beginTransaction().add(R.id.container_frag, fragment).commit();
    }

}