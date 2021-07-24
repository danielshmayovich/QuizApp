package com.example.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {



    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button buttonplay = findViewById(R.id.bt_play);
        buttonplay.setOnClickListener(v -> {
            Intent intent = new Intent(PlayActivity.this,CategoryActivity.class);
            startActivity(intent);
        });


    }


    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Do you want to Exit ?")
                .setNegativeButton("No",null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("DATA","executed Play Activity");
                        setResult(RESULT_OK, new Intent().putExtra("Exit",true));
                        finish();
                    }
                }).create().show();

        }




    @Override
    protected void onStop() {
        super.onStop();
    }

}