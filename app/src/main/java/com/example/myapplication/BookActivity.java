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


        Fragment1 fragment = new Fragment1();
        Fragment2 exercises = new Fragment2();


        int btnId = getIntent().getIntExtra("btnId",-1);

        if (btnId == R.id.btnExercises) {
            loadFragment(exercises);
        } else {
            Intent intent = getIntent();
            String btnTitle = intent.getStringExtra("btnTitle");
            Bundle bundle = new Bundle();
            bundle.putString("text", btnTitle);
            fragment.setArguments(bundle);
            loadFragment(fragment);
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

