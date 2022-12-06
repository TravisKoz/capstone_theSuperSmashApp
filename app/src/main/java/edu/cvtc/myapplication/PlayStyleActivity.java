package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;


public class PlayStyleActivity extends AppCompatActivity {

    // Member objects
    private SuperSmashOpenHelper mDbOpenHelper;

    // Create booleans to pass button status to fragment
    private boolean closeRangeClick = false;
    private boolean longRangeClick = false;
    private boolean hybridClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playstyle);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        // Create buttons from layout
        Button closeRange = findViewById(R.id.btn_close_range);
        Button longRange = findViewById(R.id.btn_long_range);
        Button hybrid = findViewById(R.id.btn_hybrid);

        closeRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create ArrayList and pass in selected category according to chosen button
                ArrayList<Fighter> fightersCategory;
                fightersCategory = loadFilteredChoices("Close-range");

                closeRangeClick = true;

                // Send bundle to fragment
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("fighterKey",  fightersCategory);
                bundle.putBoolean("closeRangeKey", closeRangeClick);

                // set PlaystyleFragment1 arguments and add fragment
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_playstyle_container, PlaystyleFragment1.class, bundle)
                            .commit();


                    findViewById(R.id.playstyle_intro_text).setVisibility(View.GONE);
                    findViewById(R.id.playstyle_q1_text).setVisibility(View.GONE);
                    findViewById(R.id.btn_close_range).setVisibility(View.GONE);
                    findViewById(R.id.btn_long_range).setVisibility(View.GONE);
                    findViewById(R.id.btn_hybrid).setVisibility(View.GONE);
                }

            }
        });

        longRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create ArrayList and pass in selected category according to chosen button
                ArrayList<Fighter> fightersCategory;
                fightersCategory = loadFilteredChoices("Long-range");

                longRangeClick = true;

                // Send bundle to fragment
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("fighterKey",  fightersCategory);
                bundle.putBoolean("longRangeKey", longRangeClick);

                // set PlaystyleFragment1 arguments and add fragment
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_playstyle_container, PlaystyleFragment1.class, bundle)
                            .commit();

                    findViewById(R.id.playstyle_intro_text).setVisibility(View.GONE);
                    findViewById(R.id.playstyle_q1_text).setVisibility(View.GONE);
                    findViewById(R.id.btn_close_range).setVisibility(View.GONE);
                    findViewById(R.id.btn_long_range).setVisibility(View.GONE);
                    findViewById(R.id.btn_hybrid).setVisibility(View.GONE);
                }
            }
        });

        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create ArrayList and pass in selected category according to chosen button
                ArrayList<Fighter> fightersCategory;
                fightersCategory = loadFilteredChoices("Hybrid");

                hybridClick = true;

                // Send bundle to fragment
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("fighterKey",  fightersCategory);
                bundle.putBoolean("hybridKey", hybridClick);

                // set PlaystyleFragment1 arguments and add fragment
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_playstyle_container, PlaystyleFragment1.class, bundle)
                            .commit();

                    findViewById(R.id.playstyle_intro_text).setVisibility(View.GONE);
                    findViewById(R.id.playstyle_q1_text).setVisibility(View.GONE);
                    findViewById(R.id.btn_close_range).setVisibility(View.GONE);
                    findViewById(R.id.btn_long_range).setVisibility(View.GONE);
                    findViewById(R.id.btn_hybrid).setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }

    // Load choices from database based on query
    private ArrayList<Fighter> loadFilteredChoices(String selectedCategory) {

        // Open database connection for reading
        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

        // Gets the currently selected fighter's name.
        Cursor playstyleCursor = db.rawQuery("select * from " + SuperSmashDatabaseContract.FighterEntry.TABLE_NAME + " where "
                + SuperSmashDatabaseContract.FighterEntry.COLUMN_CATEGORY + " = ?", new String[]{selectedCategory});

        int namePosition = playstyleCursor.getColumnIndex(SuperSmashDatabaseContract.FighterEntry.COLUMN_NAME);

        // Create list of Fighter objects
        ArrayList<Fighter> fightersCategory = new ArrayList<Fighter>();

        // While there is still a record from the result set that matches our cursor
        while(playstyleCursor.moveToNext()) {

            // Create a new Fighter object.
            Fighter fighter = new Fighter(0,null, null, null, null, null,
                    null, null, null, null,
                    null, null, null, null, null);

            // Set name value for created fighter object to match the fighter currently selected by cursor
            fighter.setName(playstyleCursor.getString(namePosition));

            // Add new fighter data to fightersCategory list
            fightersCategory.add(fighter);
        }

        return fightersCategory;

//        for(Fighter currentFighter : fightersCategory) {
//            Toast.makeText(PlayStyleActivity.this, currentFighter.getName(),Toast.LENGTH_LONG).show();
//        }
    }

}