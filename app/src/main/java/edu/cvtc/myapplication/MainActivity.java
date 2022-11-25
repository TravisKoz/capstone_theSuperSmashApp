package edu.cvtc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer mTimer;

    ConstraintLayout constraintLayout;
    private SuperSmashOpenHelper mDbOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = (ConstraintLayout) findViewById(R.id.welcome_page_click);
        mTimer = new Timer();

        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                openMainMenuActivity();
                //finish();
            }
        }, 3000);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenuActivity();
            }
        });
    }

    private void openMainMenuActivity() {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
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
            case R.id.legal_stages_access:
                intent = new Intent(MainActivity.this, LegalStageActivity.class);
                startActivity(intent);
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }
}