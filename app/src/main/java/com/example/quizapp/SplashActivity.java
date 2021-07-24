package com.example.quizapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {


    private final static int EXIT_CODE = 100;

    ImageView imageViewSplashLogo;
    //TextView textViewGoQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageViewSplashLogo = findViewById(R.id.splash_imgView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition);
        imageViewSplashLogo.setAnimation(animation);

        QuestionRoomDatabase.getInstance(this);
//                .questionDao()
//                .getQuestionsByCategory("", "");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    sleep(3000);

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {

                    GoPlayActivity();
                }


            }
        });
        thread.start();
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == EXIT_CODE) {
//
//            if (resultCode == RESULT_OK) {
//                if (data.getBooleanExtra("EXIT", true)) {
//                    finish();
//                }
//
//            }
//        }
//    }

    private void GoPlayActivity() {

        startActivity(new Intent(SplashActivity.this, PlayActivity.class));
        finish();
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//
//    }
}

