package edu.cvtc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Creates a option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    // Populate the options menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.timer_access:
                intent = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(intent);
                return true;
            case R.id.fighter_access:
                intent = new Intent(MainActivity.this, FightersActivity.class);
                startActivity(intent);
                return true;
            case R.id.notes_access:
                intent = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(intent);
                return true;
            case R.id.tracker_access:
                intent = new Intent(MainActivity.this, WinLoseTrackerActivity.class);
                startActivity(intent);
                return true;
            case R.id.controls_access:
                intent = new Intent(MainActivity.this, ControlsActivity.class);
                startActivity(intent);
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }

}