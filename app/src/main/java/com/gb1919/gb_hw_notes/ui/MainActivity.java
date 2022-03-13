package com.gb1919.gb_hw_notes.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.gb1919.gb_hw_notes.AboutFragment;
import com.gb1919.gb_hw_notes.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,SocialNetworkFragment.newInstance()).commit();

        }
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
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