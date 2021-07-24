package com.example.quizapp;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import java.util.List;
public class QuestionViewModel  extends AndroidViewModel {
    private QuestionRepository mRepository;
    private LiveData<List<Questions>> mAllQuestions;

    public QuestionViewModel(Application application){

        super(application);//callback
        String language = application.getString(R.string.language);
        mRepository = new QuestionRepository(application, language);
    }

        LiveData<List<Questions>> getAllQuestionByCategory(String category, String language) {
            mAllQuestions = mRepository.getQuestions(category, language);
            return mAllQuestions;
        }
    }