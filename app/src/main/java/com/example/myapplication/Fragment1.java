package com.example.myapplication;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Fragment1 extends Fragment {

    public ArrayList<Integer> pages = new ArrayList<>(List.of(1,10));
    public boolean addToFavorite = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);



        ImageButton prevBtn = view.findViewById(R.id.prevBtn);
        prevBtn.setVisibility(View.INVISIBLE);

        ImageButton nextBtn = view.findViewById(R.id.nextBtn);

        ImageView addToFavoriteBtn = view.findViewById(R.id.addToFavoriteBtn);
        addToFavoriteBtn.setImageResource(!addToFavorite ? R.drawable.heart_disable : R.drawable.heart_active);

        ImageView pageImageView = view.findViewById(R.id.pageImageView);
        Bitmap pageBitmap = loadPageFromAssets("book1/page" + pages.get(0) + ".png");
        pageImageView.setImageBitmap(pageBitmap);





        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPage = pages.get(0);
                pages.set(0, currentPage + 1);
                prevBtn.setVisibility(pages.get(0).equals(1) ? View.INVISIBLE : View.VISIBLE);
                nextBtn.setVisibility(pages.get(0).equals(pages.get(1)) ? View.INVISIBLE : View.VISIBLE);
                Bitmap pageBitmap = loadPageFromAssets("book1/page" + pages.get(0) + ".png");
                pageImageView.setImageBitmap(pageBitmap);
            }
        });

        addToFavoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addToFavorite) {
                    addToFavorite = false;
                    addToFavoriteBtn.setImageResource(R.drawable.heart_disable );
                } else {
                    addToFavorite = true;
                    addToFavoriteBtn.setImageResource(R.drawable.heart_active);

                }
            }
        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPage = pages.get(0);
                pages.set(0, currentPage - 1);
                prevBtn.setVisibility(pages.get(0).equals(1) ? View.INVISIBLE : View.VISIBLE);
                nextBtn.setVisibility(pages.get(0).equals(pages.get(1)) ? View.INVISIBLE : View.VISIBLE);
                Bitmap pageBitmap = loadPageFromAssets("book1/page" + pages.get(0) + ".png");
                pageImageView.setImageBitmap(pageBitmap);
            }
        });



       


        return view;
    }



    private Bitmap loadPageFromAssets(String s) {
        try {
            InputStream inputStream = requireContext().getAssets().open(s);
            return BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}