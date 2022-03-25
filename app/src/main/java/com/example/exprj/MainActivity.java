package com.example.exprj;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.exprj.custom_view.BottomMenu;
import com.example.exprj.custom_view.BottomMenuListenner;
import com.example.exprj.custom_view.ItemBottomMenu;
import com.example.exprj.databinding.ActivityMainBinding;
import com.example.exprj.game.FragmentGame;
import com.example.exprj.home.FragmentHome;
import com.example.exprj.news.FragmentNews;
import com.example.exprj.person.FragmentPerson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private static FragmentManager fragmentManager;
    private BottomMenu bottomMenu;
    private String currentTag;

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

        //init fragment
        FragmentHome  fragmentHome = new FragmentHome();
        FragmentGame  fragmentGame = new FragmentGame();
        FragmentNews  fragmentNews = new FragmentNews();
        FragmentPerson fragmentPerson = new FragmentPerson();

        // turn on fragment home first and set currentFrag is fragmentHome
        fragmentManager.beginTransaction().add(R.id.container_frag, fragmentHome, FragmentHome.TAG).commit();
        currentTag = fragmentHome.getTag();

        // call bottom menu in activity_main.xml
        bottomMenu = binding.menuBar;

        // catch events bottom menu
        bottomMenu.setBottomMenuListenner(new BottomMenuListenner() {
            @Override
            public void onItemClick(int position) {
                switch (position){
                    case 0:
                        turnOnFragment(fragmentHome, FragmentHome.TAG); break;
                    case 1:
                        turnOnFragment(fragmentGame, FragmentGame.TAG); break;
                    case 2:
                        turnOnFragment(fragmentNews, FragmentNews.TAG); break;
                    case 3:
                        turnOnFragment(fragmentPerson, FragmentPerson.TAG); break;
                    default: break;
                }
            }
        });

    }

    //Khởi động fragment
    void turnOnFragment(Fragment fragment, String tag){
        // Tạo mới 1 transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // ẩn fragment đang show, tìm Fragment đang show bằng currentTag
        fragmentTransaction.hide(fragmentManager.findFragmentByTag(currentTag));

        // fragment chưa được add thì thực hiện add
        if(!fragment.isAdded()) {
            fragmentTransaction.add(R.id.container_frag ,fragment, tag);
        }

        // singleTop Fragment
        if(currentTag.equals(tag)){
            fragmentTransaction.show(fragment);
        }
        else{
            fragmentTransaction.show(fragment).addToBackStack(null);
        }

        // thực thi transaction
        fragmentTransaction.commit();

        // set currentTag là TAG của fragment đang show
        currentTag = fragment.getTag();
    }

    public void onFragmentSelected(int position, String tag){
        LinearLayout menu = findViewById(R.id.root);
        bottomMenu.turnOn((ItemBottomMenu) menu.getChildAt(position));
        currentTag = tag;
    }

    int dem = 1;
    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount() > 0){
            fragmentManager.popBackStack();
        }
        else{
            if(dem > 0) {
                dem--;
                Toast.makeText(this, "Back thêm phát nữa để thoát!", Toast.LENGTH_SHORT).show();
            }
            else super.onBackPressed();
        }
    }
}