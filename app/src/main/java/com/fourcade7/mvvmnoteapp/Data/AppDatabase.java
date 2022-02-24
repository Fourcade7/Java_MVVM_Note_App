package com.fourcade7.mvvmnoteapp.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.fourcade7.mvvmnoteapp.Model.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
}