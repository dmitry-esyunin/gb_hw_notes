package com.gb1919.gb_hw_notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

//    private Note[] note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        NotesListFragment notes_list = NotesListFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.notes_list, notes_list).commit();

        if (savedInstanceState == null) {
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                NoteContentFragment note_content = NoteContentFragment.newInstance(new Note("default", " ", 0));
                getSupportFragmentManager().beginTransaction().replace(R.id.note_content, note_content).commit();
            }
        }
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menu.findItem(R.id.action_exit).setVisible(false); // бесявая кнопка, а-ту ее
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.action_about):
                AboutFragment aboutFragment = new AboutFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.notes_list, aboutFragment).addToBackStack("ABOUT").commit();
                break;
            case (R.id.action_exit):
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}