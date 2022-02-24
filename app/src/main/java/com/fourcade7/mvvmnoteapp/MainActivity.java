package com.fourcade7.mvvmnoteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.fourcade7.mvvmnoteapp.Data.AppDatabase;
import com.fourcade7.mvvmnoteapp.Data.NoteDao;
import com.fourcade7.mvvmnoteapp.Model.Note;
import com.fourcade7.mvvmnoteapp.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Note note;
    EditText editText;
    NoteAdapter noteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview1);
        editText=findViewById(R.id.edittext1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));


        readfromdatabase();
        //pr


    }

    public void readfromdatabase(){
        MainViewModel mainViewModel= ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);
        mainViewModel.getNotelivedata().observe(MainActivity.this, notes -> {
                noteAdapter=new NoteAdapter(MainActivity.this, (ArrayList<Note>) notes);
                recyclerView.setAdapter(noteAdapter);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.item1){
            note=new Note();
            note.setText(editText.getText().toString());
            note.setDone(true);
            note.setTimestamp(7);
            App.noteDao.insert(note);
            Toast.makeText(MainActivity.this, "сохронено", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}