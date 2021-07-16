package com.example.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class CategoryActivity extends AppCompatActivity  implements View.OnClickListener {
    Button btcomputers,btjava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        btcomputers = findViewById(R.id.bt_computers);
        btjava = findViewById(R.id.bt_java);

        btcomputers.setOnClickListener(this);
        btjava.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.bt_computers:

                Intent intentComputers = new Intent(CategoryActivity.this,QuizActivity.class);
                intentComputers.putExtra("Category","computers");
                startActivity(intentComputers);
                break;

            case R.id.bt_java:
                Intent intentJAVA = new Intent(CategoryActivity.this,QuizActivity.class);
                intentJAVA.putExtra("Category","JAVA");
                startActivity(intentJAVA);
                break;


        }

    }
}