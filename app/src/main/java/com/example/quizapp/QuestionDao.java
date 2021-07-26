package com.example.quizapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {

    @Query("SELECT * from questions_table WHERE category = :category and language = :language")
    LiveData<List<Questions>> getQuestionsByCategory(String category, String language);

    @Insert
    void insert(Questions questions);

}
