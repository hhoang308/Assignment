package com.example.assignment;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DetailFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    boolean isNightModeOn = false;

    public DetailFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    // TODO: Rename and change types and number of parameters

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView txtDetail = (TextView) view.findViewById(R.id.detailText);
        int index = getActivity().getIntent().getIntExtra("index",1);
        int textFile = R.raw.chapter1;
        if(index == 1)
        {
            textFile = R.raw.chapter2;
        }
        else if(index == 2)
        {
            textFile = R.raw.chapter3;
        }
        else if(index == 3)
        {
            textFile = R.raw.chapter4;
        }
        else if(index == 4)
        {
            textFile = R.raw.chapter5;
        }
        else if(index == 5)
        {
            textFile = R.raw.chapter6;
        }
        else if(index == 6)
        {
            textFile = R.raw.chapter7;
        }
        else if(index == 7)
        {
            textFile = R.raw.chapter8;
        }
        else if(index == 8)
        {
            textFile = R.raw.chapter9;
        }
        else if(index == 9)
        {
            textFile = R.raw.chapter10;
        }
        else if(index == 10)
        {
            textFile = R.raw.chapter11;
        }
        else if(index == 11)
        {
            textFile = R.raw.chapter12;
        }
        else if(index == 12)
        {
            textFile = R.raw.chapter13;
        }
        else if(index == 13)
        {
            textFile = R.raw.chapter14;
        }
        InputStream inputStream = getResources().openRawResource(textFile);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;

        try {
            i = inputStream.read();
            while (i != -1){
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        txtDetail.setText(byteArrayOutputStream.toString());

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_detail, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView txtDetail = (TextView) getActivity().findViewById(R.id.detailText);
        switch(item.getItemId()){
            case R.id.font1:
                Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/arial.ttf");
                txtDetail.setTypeface(typeface);
                Toast.makeText(getActivity(), "Changed to Arial Font", Toast.LENGTH_SHORT).show();
                break;
            case R.id.font2:
                Typeface typeface1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/bookerly.ttf");
                txtDetail.setTypeface(typeface1);
                Toast.makeText(getActivity(), "Changed to Bookerly Font", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mode:
                if(isNightModeOn){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    isNightModeOn = false;
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    isNightModeOn = true;
                }
                break;
            case R.id.smallTextSize:
                txtDetail.setTextSize(8);
                break;
            case R.id.bigTextSize:
                txtDetail.setTextSize(30);
                break;
            case R.id.normalTextSize:
                txtDetail.setTextSize(18);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}