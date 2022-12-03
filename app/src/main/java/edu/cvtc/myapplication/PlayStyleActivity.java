package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PlayStyleActivity extends AppCompatActivity {

    // Constants
    public static final String FIGHTER_ID = "edu.cvtc.myapplication.FIGHTER_ID";
    public static final String FIGHTER_CATEGORY = "edu.cvtc.myapplication.FIGHTER_CATEGORY";

    // Member objects
    private SuperSmashOpenHelper mDbOpenHelper;


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


                List<Fighter> fightersCategory = new ArrayList<Fighter>();
                fightersCategory = loadFilteredChoices("Close-range");

                // Send bundle to fragment
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("fighterKey", (ArrayList<? extends Parcelable>) fightersCategory);

                // set PlaystyleFragment1 Arguments
                PlaystyleFragment1 playstyleObj1 = new PlaystyleFragment1();
                playstyleObj1.setArguments(bundle);

            }
        });

        longRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFilteredChoices("Long-range");

                // Send bundle to fragment
                Bundle bundle = new Bundle();
                // TODO Send query results to fragment in bundle as a string

                // set PlaystyleFragment1 Arguments
                PlaystyleFragment1 playstyleObj1 = new PlaystyleFragment1();
                playstyleObj1.setArguments(bundle);
            }
        });

        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFilteredChoices("Hybrid");

                // Send bundle to fragment
                Bundle bundle = new Bundle();
                // TODO Send query results to fragment in bundle as a string

                // set PlaystyleFragment1 Arguments
                PlaystyleFragment1 playstyleObj1 = new PlaystyleFragment1();
                playstyleObj1.setArguments(bundle);
            }
        });
    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }

    // Load choices from database based on query
    private List<Fighter> loadFilteredChoices(String selectedCategory) {

        // Open database connection for reading
        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

        // Gets the currently selected fighter's name.
        Cursor playstyleCursor = db.rawQuery("select * from " + SuperSmashDatabaseContract.FighterEntry.TABLE_NAME + " where "
                + SuperSmashDatabaseContract.FighterEntry.COLUMN_CATEGORY + " = ?", new String[]{selectedCategory});

        int namePosition = playstyleCursor.getColumnIndex(SuperSmashDatabaseContract.FighterEntry.COLUMN_NAME);

        // Create list of Fighter objects
        List<Fighter> fightersCategory = new ArrayList<Fighter>();

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