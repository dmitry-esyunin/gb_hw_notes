package com.gb1919.gb_hw_notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
        // Костыли. если вижу, что в мню основной активити лезут кнопки контента заметок -прячу их,
        // а кнопку закрытия приложения отображаю
        if (menu.findItem(R.id.action_edit_content_note) != null) {
            menu.findItem(R.id.action_edit_content_note).setVisible(false);
            menu.findItem(R.id.action_close_content_note).setVisible(false);
            menu.findItem(R.id.action_exit).setVisible(true);
        }
        if (menu.findItem(R.id.action_close_about) != null) {
            menu.findItem(R.id.action_close_about).setVisible(false);
            menu.findItem(R.id.action_exit).setVisible(true);
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.action_exit):
                ShowAlertDialog();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    void ShowAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle(" ")
                .setMessage("Выйти из программы?")
                .setNeutralButton("Нет", null)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        showLastToast();
                        finish();
                    }
                })
                .show();

    }

    private void showLastToast() {
        Toast.makeText(this, "See you", Toast.LENGTH_SHORT).show();
    }
}