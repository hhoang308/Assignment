package com.example.assignment;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;

import android.os.Bundle;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Intent intent = new Intent(DetailActivity.this,MainActivity.class);
            startActivity(intent);
        }
        setContentView(R.layout.activity_detail);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DetailFrag detailFrag = new DetailFrag();
        fragmentTransaction.replace(R.id.fragmentDetailFrag, detailFrag);
        fragmentTransaction.commit();
    }

}