package com.example.quizapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;
public class QuestionRepository {


    private QuestionDao mQuestionDao;
    private LiveData<List<Questions>> mAllQuestions;


    public QuestionRepository(Application application){
        QuestionRoomDatabase db = QuestionRoomDatabase.getInstance(application);
        mQuestionDao = db.questionDao();
        mAllQuestions = mQuestionDao.getAllQuestions();
    }

    //without categories

//    public LiveData<List<Questions>> getmAllQuestions(){
//        return mAllQuestions;
//    }

    public LiveData<List<Questions>> getQuestion(String category){

        mAllQuestions = mQuestionDao.getQuestionsByCategory(category);

        return mAllQuestions;
    }

}
