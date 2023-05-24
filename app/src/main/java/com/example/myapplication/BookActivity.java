package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);


        int btnId = getIntent().getIntExtra("btnId",-1);

        if (btnId == R.id.btn1) {
            loadFragment(new Fragment1());
        }

    }

    private void loadFragment (Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameContainer,fragment)
                .commit();
    }

    public void backToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

