package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LegalStageActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal_stage);

        // Create textviews
        TextView starter = findViewById(R.id.stage_info_text_starter);
        starter.setText("");
        TextView counterpickStarter = findViewById(R.id.stage_info_counterpick_starter);
        counterpickStarter.setText("");
        TextView counterpick = findViewById(R.id.stage_info_text_counterpick);
        counterpick.setText("");

        // Create buttons and onClickListeners
        ImageButton finalDestination = findViewById(R.id.final_destination);
        ImageButton battlefield = findViewById(R.id.battlefield);
        ImageButton smashville = findViewById(R.id.smashville);
        ImageButton townAndCity = findViewById(R.id.town_and_city);
        ImageButton smallBattlefield = findViewById(R.id.small_battlefield);
        ImageButton lylatSystem = findViewById(R.id.lylat_cruise);
        ImageButton pokemonStadium2 = findViewById(R.id.pokemon_stadium_2);
        ImageButton kalosPokemonLeague = findViewById(R.id.kalos_pokemon_league);
        ImageButton hollowBastion = findViewById(R.id.hollow_bastion);
        ImageButton yoshisStory = findViewById(R.id.yoshis_story);



        finalDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starter.setText("Basic stage layout, no platforms, flat.");

            }
        });

        battlefield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starter.setText("Same as Final Destination, with three added platforms.");

            }
        });

       smashville.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               starter.setText("Same as Final Destination, with one moving platform");
           }
       });

        townAndCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterpickStarter.setText("While in early years of Ultimate the stage was consistently considered a starter[2], views of the stage have changed as more competitively viable stages (including competitively viable Hazards On stages) were added to the game. This is mainly due to Town and City usually being the only transformative stage in most competitive stage lists, as well as having a transformation which is duplicative of Final Destination.");
            }
        });



        smallBattlefield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterpickStarter.setText("Stage layout is similar to Pokémon Stadium 2, albeit with a smaller stage size and larger platforms. Thus, there has been some debate on where Small Battlefield stands in the current stage list, with some tournaments having it replace PS2 as a starter, while others put it as a counterpick.");

            }
        });



        lylatSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterpickStarter.setText("Slants can alter gameplay; certain recoveries had difficulties grabbing the ledge prior to 8.0.0.");
            }
        });



        pokemonStadium2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterpickStarter.setText("Sometimes deemed as a counterpick, with Small Battlefield replacing it as a starter, and other times excluded in favor of the original Pokémon Stadium in certain regions of the world.");
            }
        });


        kalosPokemonLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterpickStarter.setText("Walls located on the ledges of the stage; overall rather large blast zones.");
            }
        });


        hollowBastion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterpickStarter.setText("Stage layout is static and laid out identically to Smashville with hazards off.");
            }
        });


        yoshisStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterpick.setText("Features slopes on the ledges; blast zones are rather close to the main stage. Also features a low ceiling, which can lead to early kills. Making this stage banned in some tournaments.");

            }
        });

    }

}