package com.example.exprj.person;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.exprj.R;
import com.example.exprj.databinding.FragmentPersonBinding;

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

        return binding.getRoot();
    }
}
