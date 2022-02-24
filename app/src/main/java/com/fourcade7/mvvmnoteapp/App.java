package com.fourcade7.mvvmnoteapp;

import android.app.Application;

import androidx.room.Room;

import com.fourcade7.mvvmnoteapp.Data.AppDatabase;
import com.fourcade7.mvvmnoteapp.Data.NoteDao;

public class App extends Application {

    public static NoteDao noteDao;

    @Override
    public void onCreate() {
        super.onCreate();
        noteDao= Room.databaseBuilder(getApplicationContext(), AppDatabase.class,
                "note.db").allowMainThreadQueries().build().noteDao();
    }
}
