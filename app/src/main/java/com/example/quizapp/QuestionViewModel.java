package com.example.quizapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class QuestionViewModel  extends AndroidViewModel {

    private QuestionRepository mRepository;

    private LiveData<List<Questions>> mAllQuestions;

//    public QuestionViewModel(Application application){
//        super(application);
//        mRepository = new QuestionRepository(application);
//        mAllQuestions = mRepository.getmAllQuestions();
//
//    }

    public QuestionViewModel(Application application){

        super(application);
        mRepository = new QuestionRepository(application);
        //mAllQuestions = mRepository.getQuestion()
    }

    LiveData<List<Questions>> getAllQuestionByCategory(String category) {

        mAllQuestions = mRepository.getQuestion(category);
        return mAllQuestions;
    }
}

//    LiveData<List<Questions>> getmAllQuestions() {
//        return mAllQuestions;
//    }
//    }
