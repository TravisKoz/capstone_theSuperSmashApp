package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {
    
    CardView cvFighters;
    CardView cvTimer;
    CardView cvNotes;
    CardView cvLegalStages;
    CardView cvControls;
    CardView cvWinLose;
    CardView cvTrophies;
    CardView cvPokemon;
    CardView cvItems;
    CardView cvPlayStyle;
    CardView cvAdvanced;
    CardView cvLingo;
    CardView cvInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        cvFighters = findViewById(R.id.cv_fighters);
        cvTimer = findViewById(R.id.cv_timer);
        cvNotes = findViewById(R.id.cv_notes);
        cvLegalStages = findViewById(R.id.cv_legal_stages);
        cvControls = findViewById(R.id.cv_controls);
        cvWinLose = findViewById(R.id.cv_win_lose);
        cvTrophies = findViewById(R.id.cv_trophies);
        cvPokemon = findViewById(R.id.cv_pokemon);
        cvItems = findViewById(R.id.cv_items);
        cvPlayStyle = findViewById(R.id.cv_play_style);
        cvAdvanced = findViewById(R.id.cv_advanced);
        cvLingo = findViewById(R.id.cv_lingo);
        cvInformation = findViewById(R.id.cv_gen_information);
        
        cvFighters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainMenuActivity.this, "Fighters", Toast.LENGTH_SHORT).show();
                openFightersActivity();
            }
        });

        cvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainMenuActivity.this, "Timer", Toast.LENGTH_SHORT).show();
                openTimerActivity();
            }
        });

        cvNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainMenuActivity.this, "Notes", Toast.LENGTH_SHORT).show();
                openNotesActivity();
            }
        });

        cvLegalStages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainMenuActivity.this, "Legal Stages", Toast.LENGTH_SHORT).show();
                openLegalStagesActivity();
            }
        });

        cvControls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainMenuActivity.this, "Controls", Toast.LENGTH_SHORT).show();
                openControlsActivity();
            }
        });

        cvWinLose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWinLoseTrackerActivity();
            }
        });

        cvTrophies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTrophiesActivity();
            }
        });

        cvPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPokemonActivity();
                //Toast.makeText(MainMenuActivity.this, "Show list of pokemon", Toast.LENGTH_SHORT).show();
            }
        });

        cvItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItemsActivity();
            }
        });

        cvPlayStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlayStyleActivity();
            }
        });

        cvAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //openAdvancedActivity();
                Toast.makeText(MainMenuActivity.this, "Show Advanced", Toast.LENGTH_SHORT).show();
            }
        });

        cvLingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // openLingoActivity();
                Toast.makeText(MainMenuActivity.this, "Show Lingo", Toast.LENGTH_SHORT).show();
            }
        });

        cvInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //openGeneralInformationActivity();
                Toast.makeText(MainMenuActivity.this, "Show General Information", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openPokemonActivity() {
        Intent intent = new Intent(this, PokemonActivity.class);
        startActivity(intent);
    }

    private void openPlayStyleActivity() {
        Intent intent = new Intent(this, PlayStyleActivity.class);
        startActivity(intent);
    }

    private void openItemsActivity() {
        Intent intent = new Intent(this, ItemsActivity.class);
        startActivity(intent);
    }

    private void openTrophiesActivity() {
        Intent intent = new Intent(this, TrophiesActivity.class);
        startActivity(intent);
    }

    private void openWinLoseTrackerActivity() {
        Intent intent = new Intent(this, WinLoseTrackerActivity.class);
        startActivity(intent);
    }

    private void openControlsActivity() {
        Intent intent = new Intent(this, ControlsActivity.class);
        startActivity(intent);
    }

    private void openLegalStagesActivity() {
        Intent intent = new Intent(this, LegalStageActivity.class);
        startActivity(intent);
    }

    private void openNotesActivity() {
        Intent intent = new Intent(this, NotesActivity.class);
        startActivity(intent);
    }

    private void openFightersActivity() {
        Intent intent = new Intent(this, FightersActivity.class);
        startActivity(intent);
    }

    private void openTimerActivity() {
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }
}