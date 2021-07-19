package com.example.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class CategoryActivity extends AppCompatActivity  implements View.OnClickListener {
    Button btSport,btMusic,btScience,btMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        btSport = findViewById(R.id.bt_Sport);
        btMusic = findViewById(R.id.bt_Music);
        btScience = findViewById(R.id.bt_Science);
        btMovies = findViewById(R.id.bt_Movies);

        btSport.setOnClickListener(this);
        btMusic.setOnClickListener(this);
        btScience.setOnClickListener(this);
        btMovies.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.bt_Sport:

                Intent intentSport = new Intent(CategoryActivity.this,QuizActivity.class);
                intentSport.putExtra("Category","Sport");
                startActivity(intentSport);
                break;

            case R.id.bt_Music:
                Intent intentMusic = new Intent(CategoryActivity.this,QuizActivity.class);
                intentMusic.putExtra("Category","Music");
                startActivity(intentMusic);
                break;

            case R.id.bt_Science:
                Intent intentScience = new Intent(CategoryActivity.this,QuizActivity.class);
                intentScience.putExtra("Category","Science");
                startActivity(intentScience);
                break;

            case R.id.bt_Movies:
                Intent intentMovies = new Intent(CategoryActivity.this,QuizActivity.class);
                intentMovies.putExtra("Category","Movies");
                startActivity(intentMovies);
                break;


        }

    }
}