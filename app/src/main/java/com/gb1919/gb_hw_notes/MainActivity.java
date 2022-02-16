package com.gb1919.gb_hw_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private Note[] note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            NotesListFragment notes_list = NotesListFragment.newInstance();
            NoteContentFragment note_content =  NoteContentFragment.newInstance(new Note("aaaaa","aaaaaa",0));
            getSupportFragmentManager().beginTransaction().replace(R.id.notes_list, notes_list).commit();

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ) {
                getSupportFragmentManager().beginTransaction().replace(R.id.note_content, note_content).commit();
            }
        }


    }
}