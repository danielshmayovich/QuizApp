package com.example.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class CategoryActivity extends AppCompatActivity  implements View.OnClickListener {
    Button btComputers,btHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        btComputers = findViewById(R.id.bt_Computers);
        btHistory = findViewById(R.id.bt_History);

        btComputers.setOnClickListener(this);
        btHistory.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.bt_Computers:

                Intent intentComputers = new Intent(CategoryActivity.this,QuizActivity.class);
                intentComputers.putExtra("Category","Computers");
                startActivity(intentComputers);
                break;

            case R.id.bt_History:
                Intent intentHistory = new Intent(CategoryActivity.this,QuizActivity.class);
                intentHistory.putExtra("Category","History");
                startActivity(intentHistory);
                break;


        }

    }
}