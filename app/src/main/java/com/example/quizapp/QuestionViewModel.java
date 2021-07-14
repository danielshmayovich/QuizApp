package com.example.quizapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class QuestionViewModel  extends AndroidViewModel {

    private QuestionRepository mRepository;

    private LiveData<List<Questions>> mAllQuestions;

    public QuestionViewModel(Application application){
        super(application);
        mRepository = new QuestionRepository(application);
        mAllQuestions = mRepository.getmAllQuestions();

    }

    LiveData<List<Questions>> getmAllQuestions() {
        return mAllQuestions;
    }
    }
