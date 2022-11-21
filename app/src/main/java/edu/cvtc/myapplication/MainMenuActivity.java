package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {
    
    CardView cvFighters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        cvFighters = findViewById(R.id.cv_fighters);
        
        cvFighters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenuActivity.this, "Fighters", Toast.LENGTH_SHORT).show();
                openFightersActivity();
            }
        });
    }

    private void openFightersActivity() {
        Intent intent = new Intent(this, FightersActivity.class);
        startActivity(intent);
    }
}