package com.fourcade7.mvvmnoteapp.Data;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.fourcade7.mvvmnoteapp.Model.Note;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Note... users);

    @Query("SELECT * FROM note")
    LiveData<List<Note>> readallusers();

    @Update
    void update(Note... notes);

    @Delete
    void delete(Note ...notes);
}
