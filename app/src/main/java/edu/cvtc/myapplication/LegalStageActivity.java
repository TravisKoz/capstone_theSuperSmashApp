package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class LegalStageActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal_stage);



        // Create buttons and onClickListeners
        ImageButton finalDestination = findViewById(R.id.final_destination);
        finalDestination.setOnClickListener(this);
        ImageButton battlefield = findViewById(R.id.battlefield);
        battlefield.setOnClickListener(this);
        ImageButton smashville = findViewById(R.id.final_destination);
        smashville.setOnClickListener(this);
        ImageButton townAndCity = findViewById(R.id.final_destination);
        townAndCity.setOnClickListener(this);
        ImageButton smallBattlefield = findViewById(R.id.final_destination);
        smallBattlefield.setOnClickListener(this);
        ImageButton lylatSystem = findViewById(R.id.final_destination);
        lylatSystem.setOnClickListener(this);
        ImageButton pokemonStadium2 = findViewById(R.id.final_destination);
        pokemonStadium2.setOnClickListener(this);
        ImageButton kalosPokemonLeague = findViewById(R.id.final_destination);
        kalosPokemonLeague.setOnClickListener(this);
        ImageButton hollowBastion = findViewById(R.id.final_destination);
        hollowBastion.setOnClickListener(this);
        ImageButton yoshisStory = findViewById(R.id.final_destination);
        yoshisStory.setOnClickListener(this);

//        Bundle bundle = new Bundle();
//
//        if (findViewById(R.id.final_destination).isPressed()) {
//
//            bundle.putString("stageInfoKey", "The stage is a single platform and does not disrupt gameplay");
//
//
//        } else if(findViewById(R.id.battlefield).isPressed()) {
//            bundle.putString("stageInfoKey","Same as Final Destination, but with three added platforms");
//
//        } else if (findViewById(R.id.smashville).isPressed()) {
//
//            bundle.putString("stageInfoKey","Same as Final Destination, but with three added platforms");
//
//        }  else if(findViewById(R.id.battlefield).isPressed()) {
//        bundle.putString("stageInfoKey","Same as Final Destination, but with three added platforms");
//
//        }  else if(findViewById(R.id.battlefield).isPressed()) {
//            bundle.putString("stageInfoKey","Same as Final Destination, but with three added platforms");
//
//        }  else if(findViewById(R.id.battlefield).isPressed()) {
//            bundle.putString("stageInfoKey","Same as Final Destination, but with three added platforms");
//
//        }  else if(findViewById(R.id.battlefield).isPressed()) {
//            bundle.putString("stageInfoKey","Same as Final Destination, but with three added platforms");
//
//        }  else if(findViewById(R.id.battlefield).isPressed()) {
//            bundle.putString("stageInfoKey","Same as Final Destination, but with three added platforms");
//
//        }  else if(findViewById(R.id.battlefield).isPressed()) {
//            bundle.putString("stageInfoKey","Same as Final Destination, but with three added platforms");
//
//        }  else if(findViewById(R.id.battlefield).isPressed()) {
//            bundle.putString("stageInfoKey","Same as Final Destination, but with three added platforms");
//
//        }
//
//            if (savedInstanceState == null) {
//                getSupportFragmentManager().beginTransaction()
//                        .setReorderingAllowed(true)
//                        .replace(R.id.legal_stage_container_view, LegalStageFragment.class, bundle)
//                        .commit();
//
//        }


    }


    @Override
    public void onClick(View view) {

    }


}