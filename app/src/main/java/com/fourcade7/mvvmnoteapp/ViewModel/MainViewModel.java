package com.fourcade7.mvvmnoteapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fourcade7.mvvmnoteapp.App;
import com.fourcade7.mvvmnoteapp.Model.Note;

import java.util.List;

public class MainViewModel extends ViewModel {
    LiveData<List<Note>> notelivedata= App.noteDao.readallusers();

    public LiveData<List<Note>> getNotelivedata() {
        return notelivedata;
    }
}
