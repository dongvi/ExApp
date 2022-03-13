package com.example.exprj;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.exprj.databinding.ActivityMainBinding;
import com.example.exprj.game.FragmentGame;
import com.example.exprj.home.FragmentHome;
import com.example.exprj.news.FragmentNews;
import com.example.exprj.person.FragmentPerson;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ẩn thanh tác vụ
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setBtnOn(1, binding);

        //Cho màn hình Home chạy đầu tiên
        FragmentHome fragmentHome = new FragmentHome();
        turnOnFragment(fragmentHome.newInstance());

        // Thay đổi hiệu ứng menuBar khi thao tác
        // Đồng thời gọi Fragment tương ứng khi thao tác với các btn
        binding.btnHomeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnOn(1, binding);

                // khởi tạo Fragment Home
                FragmentHome fragmentHome = new FragmentHome();
                turnOnFragment(fragmentHome.newInstance());
            }
        });

        binding.btnPlayOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnOn(2, binding);

                // khởi tạo Fragment Game
                FragmentGame fragmentGame = new FragmentGame();
                turnOnFragment(fragmentGame.newInstance());
            }
        });

        binding.btnNewsOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnOn(3, binding);

                // khởi tạo Fragment News
                FragmentNews fragmentNews = new FragmentNews();
                turnOnFragment(fragmentNews.newInstance());
            }
        });

        binding.btnPersonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnOn(4, binding);

                // khởi tạo Fragment person
                FragmentPerson fragmentPerson = new FragmentPerson();
                turnOnFragment(fragmentPerson.newInstance());
            }
        });
    }

    //Đưa toàn bộ button menubar về trạng thái off
    void setOffAllBtnMenu(ActivityMainBinding binding){
        // Hiển thị trạng thái off
        binding.btnHomeOff.setVisibility(View.VISIBLE);
        binding.btnNewsOff.setVisibility(View.VISIBLE);
        binding.btnPersonOff.setVisibility(View.VISIBLE);
        binding.btnPlayOff.setVisibility(View.VISIBLE);

        // Cho bay màu hết trạng thái on
        binding.btnHomeOn.setVisibility(View.GONE);
        binding.btnNewsOn.setVisibility(View.GONE);
        binding.btnPersonOn.setVisibility(View.GONE);
        binding.btnPlayOn.setVisibility(View.GONE);
    }

    // set trạng thái menuBar trong lần đầu khởi động
    void setBtnOn(int view, ActivityMainBinding binding){
        // Đưa trạng thái menuBar về off
        setOffAllBtnMenu(binding);

        // set trạng thái và màn hình theo view số truyền vào
        // view 1: Home
        if(view == 1) {
            binding.btnHomeOn.setVisibility(View.VISIBLE);
            binding.btnHomeOff.setVisibility(View.GONE);
        }
        //view 2: Game
        else if(view == 2){
            binding.btnPlayOn.setVisibility(View.VISIBLE);
            binding.btnPlayOff.setVisibility(View.GONE);
        }
        //view 3: News
        else if(view == 3){
            binding.btnNewsOn.setVisibility(View.VISIBLE);
            binding.btnNewsOff.setVisibility(View.GONE);
        }
        //view 4: in4
        else if(view == 4){
            binding.btnPersonOn.setVisibility(View.VISIBLE);
            binding.btnPersonOff.setVisibility(View.GONE);
        }
    }

    //Khởi động fragment
    void turnOnFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container_frag, fragment).commit();
    }
}