package com.example.androidtodoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.androidtodoapp.fragments.MainBottomFragment;
import com.example.androidtodoapp.fragments.MainUpFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ここからフラグメントを追加するコード

        MainUpFragment fragment = new MainUpFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container,fragment);
        transaction.commit();

        MainBottomFragment bottomFragment = new MainBottomFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container,bottomFragment);
        transaction.commit();
    }
}
