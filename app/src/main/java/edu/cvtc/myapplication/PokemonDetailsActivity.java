package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.PokemonEntry;

public class PokemonDetailsActivity extends AppCompatActivity {

    public static final String POKEMON_ID = "edu.cvtc.myapplication.POKEMON_ID";
    public static final int ID_NOT_SET = -1;

    // Member variables
    private int mPokemonId;
    private int mPokemonNamePosition;
    private int mPokemonDescriptionPosition;
    private int mPokemonBallTypePosition;

    // Member objects
    private TextView mPokemonName;
    private ImageView mPokemonImage;
    private TextView mPokemonDescription;
    private TextView mPokemonBallType;
    private SuperSmashOpenHelper mDbOpenHelper;
    private Cursor mPokemonCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        Intent intent = getIntent();
        mPokemonId = intent.getIntExtra(POKEMON_ID, ID_NOT_SET);

        // Set references to all layout controls
        mPokemonName = findViewById(R.id.dt_pokemon_name);
        mPokemonDescription = findViewById(R.id.dt_pokemon_description);
        mPokemonBallType = findViewById(R.id.dt_ball_type);
        mPokemonImage = findViewById(R.id.dt_pokemon_image);

        loadPokemonData();

    }

    private void loadPokemonData() {
        // Open a connection to the database
        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

        String selection = SuperSmashDatabaseContract.PokemonEntry._ID + " = ?";
        String[] selectionArgs = {Integer.toString(mPokemonId)};

        // Create a list of the columns we are pulling from the database
        String[] pokemonColumns = {
                PokemonEntry.COLUMN_NAME,
                PokemonEntry.COLUMN_DESCRIPTION,
                PokemonEntry.COLUMN_BALL };

        // Fill our cursor with the information we have provided
        mPokemonCursor = db.query(PokemonEntry.TABLE_NAME, pokemonColumns,
                selection, selectionArgs, null, null, null);

        // Get the positions of the fields in the cursor so that
        // we are able to retrieve them into our layout.
        mPokemonNamePosition = mPokemonCursor.getColumnIndex(PokemonEntry.COLUMN_NAME);
        mPokemonDescriptionPosition = mPokemonCursor.getColumnIndex(PokemonEntry.COLUMN_DESCRIPTION);
        mPokemonBallTypePosition = mPokemonCursor.getColumnIndex(PokemonEntry.COLUMN_BALL);

        mPokemonCursor.moveToNext();

        displayPokemon();
    }

    private void displayPokemon() {
        // Retrieve the values from the cursor based upon
        // the position of the columns.
        String pokemonName = mPokemonCursor.getString(mPokemonNamePosition);
        String pokemonDescription = mPokemonCursor.getString(mPokemonDescriptionPosition);
        String pokemonBallType = mPokemonCursor.getString(mPokemonBallTypePosition);

        // Use information to populate layout TextViews
        mPokemonName.setText(pokemonName);
        mPokemonDescription.setText(pokemonDescription);
        mPokemonBallType.setText(pokemonBallType);

        // Formatted the passed in pokemon's name String to match our image names convention.
        // Symbols are replaced with corresponding characters and all letters and converted to lower case.
        String imageResource = "pokemon_" + pokemonName.replace(" ", "_").replace(".","")
                .replace("&", "and").replace("-", "_").replace("'", "_").toLowerCase();

        // Gets the resourceID for our selected pokemon's image.
        int imageResourceID = this.getResources().getIdentifier(imageResource, "drawable", this.getPackageName());

        // Changes the displayed pokemon's image based on our resourceIDs.
        mPokemonImage.setImageResource(imageResourceID);
    }
}