package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.FighterEntry;

public class FighterDetailsActivity extends AppCompatActivity {

    // Constants
    public static final String FIGHTER_ID =
            "edu.cvtc.myapplication.FIGHTER_ID";
    public static final int ID_NOT_SET = -1;

    // Initialize new Fighter to empty
    private Fighter mFighter = new Fighter(0, "", "", "",
            "", "", "");

    // Member Variables
    private int mFighterID;
    private int mFighterNamePosition;
    private int mFighterFranchisePosition;
    private int mFighterSpecialNeutralPosition;
    private int mFighterSpecialSidePosition;
    private int mFighterSpecialDownPosition;
    private int mFighterSpecialUpPosition;

    // Member objects
    private TextView mFighterName;
    private ImageView mFighterImage;
    private ImageView mFighterSeriesSymbol;
    private TextView mFighterSeries;
    private TextView mFighterNeutralSpecial;
    private TextView mFighterSideSpecial;
    private TextView mFighterDownSpecial;
    private TextView mFighterUpSpecial;
    private SuperSmashOpenHelper mDbOpenHelper;
    private Cursor mFighterCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighter_details);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        // Get the inter passed into the activity
        Intent intent = getIntent();
        mFighterID = intent.getIntExtra(FIGHTER_ID, ID_NOT_SET);

        // Set references to all layout controls
        mFighterName =
                findViewById(R.id.fighter_name);
        mFighterImage =
                findViewById(R.id.fighter_image);
        mFighterSeriesSymbol =
                findViewById(R.id.fighter_series_symbol);
        mFighterSeries =
                findViewById(R.id.fighter_series);
        mFighterNeutralSpecial =
                findViewById(R.id.neutral_b_move);
        mFighterSideSpecial =
                findViewById(R.id.side_b_move);
        mFighterDownSpecial =
                findViewById(R.id.down_b_move);
        mFighterUpSpecial =
                findViewById(R.id.up_b_move);
        
        loadFighterData();
    }

    private void loadFighterData() {
        // Open a connection to the database
        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

        // Build the selection criteria. In this case, we want
        // to set the ID of the fighter to the passed-in
        // fighter id from the Intent.
        String selection = FighterEntry._ID + " = ?";
        String[] selectionArgs = {Integer.toString(mFighterID)};

        // Create a list of the columns we are pulling from
        // the database.
        String[] fighterColumns = {
                FighterEntry.COLUMN_NAME,
                FighterEntry.COLUMN_FRANCHISE,
                FighterEntry.COLUMN_SPECIAL_NEUTRAL,
                FighterEntry.COLUMN_SPECIAL_SIDE,
                FighterEntry.COLUMN_SPECIAL_DOWN,
                FighterEntry.COLUMN_SPECIAL_UP,
        };

        // Fill our cursor with the information we have provided
        mFighterCursor = db.query(FighterEntry.TABLE_NAME, fighterColumns,
                selection, selectionArgs, null, null, null);

        // Get the positions of the fields in the cursor so that
        // we are able to retrieve them into our layout.
        mFighterNamePosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_NAME);
        mFighterFranchisePosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_FRANCHISE);
        mFighterSpecialNeutralPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_SPECIAL_NEUTRAL);
        mFighterSpecialSidePosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_SPECIAL_SIDE);
        mFighterSpecialDownPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_SPECIAL_DOWN);
        mFighterSpecialUpPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_SPECIAL_UP);

        // Make sure that we have moved to the correct record.
        // The cursor will not have populate any of the
        // fields until we move it.
        mFighterCursor.moveToNext();

        // Call the method to display the fighter
        displayFighter();
    }

    private void displayFighter() {
        // Retrieve the values from the cursor based upon
        // the position of the columns.
        String fighterName = mFighterCursor.getString(mFighterNamePosition);
        String fighterSeries = mFighterCursor.getString(mFighterFranchisePosition);
        String fighterNeutralSpecial = mFighterCursor.getString(mFighterSpecialNeutralPosition);
        String fighterSideSpecial = mFighterCursor.getString(mFighterSpecialSidePosition);
        String fighterDownSpecial = mFighterCursor.getString(mFighterSpecialDownPosition);
        String fighterUpSpecial = mFighterCursor.getString(mFighterSpecialUpPosition);

        // Use information to populate layout TextViews
        mFighterName.setText(fighterName);
        mFighterSeries.setText(fighterSeries);
        mFighterNeutralSpecial.setText(fighterNeutralSpecial);
        mFighterSideSpecial.setText(fighterSideSpecial);
        mFighterDownSpecial.setText(fighterDownSpecial);
        mFighterUpSpecial.setText(fighterUpSpecial);

        // Use information to populate layoutImageViews
        setFighterImage(fighterName);
        setFighterSeriesSymbol(fighterSeries);
    }

    private void setFighterSeriesSymbol(String fighterSeries) {

        switch (fighterSeries) {

            case ("Super Mario"):
                mFighterSeriesSymbol.setImageResource(R.drawable.mario_series);
                break;
            case ("Donkey Kong"):
                mFighterSeriesSymbol.setImageResource(R.drawable.donkey_kong_series);
                break;
            case ("The Legend of Zelda"):
                mFighterSeriesSymbol.setImageResource(R.drawable.zelda_series);
                break;
            case ("Metroid"):
                mFighterSeriesSymbol.setImageResource(R.drawable.metroid_series);
                break;
            case ("Yoshi"):
                mFighterSeriesSymbol.setImageResource(R.drawable.yoshi_series);
                break;
            case ("Kirby"):
                mFighterSeriesSymbol.setImageResource(R.drawable.kirby_series);
                break;
            case ("Star Fox"):
                mFighterSeriesSymbol.setImageResource(R.drawable.star_fox_series);
                break;
            case ("Pokemon"):
                mFighterSeriesSymbol.setImageResource(R.drawable.pokemon_series);
                break;
            case ("EarthBound"):
                mFighterSeriesSymbol.setImageResource(R.drawable.earth_bound_series);
                break;
            case ("F-Zero"):
                mFighterSeriesSymbol.setImageResource(R.drawable.f_zero_series);
                break;
            case ("Ice Climbers"):
                mFighterSeriesSymbol.setImageResource(R.drawable.ice_climbers_series);
                break;
            case ("Fire Emblem"):
                mFighterSeriesSymbol.setImageResource(R.drawable.fire_emblem_series);
                break;
            case ("Game & Watch"):
                mFighterSeriesSymbol.setImageResource(R.drawable.game_watch_series);
                break;
            case ("Kid Icarus"):
                mFighterSeriesSymbol.setImageResource(R.drawable.kid_icarus_series);
                break;
            case ("Wario"):
                mFighterSeriesSymbol.setImageResource(R.drawable.wario_series);
                break;
            case ("Metal Gear"):
                mFighterSeriesSymbol.setImageResource(R.drawable.metal_gear_series);
                break;
            case ("Sonic"):
                mFighterSeriesSymbol.setImageResource(R.drawable.sonic_series);
                break;
            case ("Pikmin"):
                mFighterSeriesSymbol.setImageResource(R.drawable.pikmin_series);
                break;
            default:
                mFighterSeriesSymbol.setImageResource(R.drawable.super_smash);
        }
    }

    private void setFighterImage(String name) {
        switch (name) {
            case ("Mario"):
                mFighterImage.setImageResource(R.drawable.mario);
                break;
            case ("Donkey Kong"):
                mFighterImage.setImageResource(R.drawable.donkey_kong);
                break;
            case ("Link"):
                mFighterImage.setImageResource(R.drawable.link);
                break;
            case ("Samus"):
                mFighterImage.setImageResource(R.drawable.samus);
                break;
            case ("Dark Samus"):
                mFighterImage.setImageResource(R.drawable.dark_samus);
                break;
            case ("Yoshi"):
                mFighterImage.setImageResource(R.drawable.yoshi);
                break;
            case ("Kirby"):
                mFighterImage.setImageResource(R.drawable.kirby);
                break;
            case ("Fox"):
                mFighterImage.setImageResource(R.drawable.fox);
                break;
            case ("Pikachu"):
                mFighterImage.setImageResource(R.drawable.pikachu);
                break;
            case ("Luigi"):
                mFighterImage.setImageResource(R.drawable.luigi);
                break;
            case ("Ness"):
                mFighterImage.setImageResource(R.drawable.ness);
                break;
            case ("Captain Falcon"):
                mFighterImage.setImageResource(R.drawable.captain_falcon);
                break;
            case ("Jigglypuff"):
                mFighterImage.setImageResource(R.drawable.jigglypuff);
                break;
            case ("Peach"):
                mFighterImage.setImageResource(R.drawable.peach);
                break;
            case ("Daisy"):
                mFighterImage.setImageResource(R.drawable.daisy);
                break;
            case ("Bowser"):
                mFighterImage.setImageResource(R.drawable.bowser);
                break;
            case ("Ice Climbers"):
                mFighterImage.setImageResource(R.drawable.ice_climbers);
                break;
            case ("Sheik"):
                mFighterImage.setImageResource(R.drawable.sheik);
                break;
            case ("Zelda"):
                mFighterImage.setImageResource(R.drawable.zelda);
                break;
            case ("Dr. Mario"):
                mFighterImage.setImageResource(R.drawable.dr_mario);
                break;
            case ("Pichu"):
                mFighterImage.setImageResource(R.drawable.pichu);
                break;
            case ("Falco"):
                mFighterImage.setImageResource(R.drawable.falco);
                break;
            case ("Marth"):
                mFighterImage.setImageResource(R.drawable.marth);
                break;
            case ("Lucina"):
                mFighterImage.setImageResource(R.drawable.lucina);
                break;
            case ("Young Link"):
                mFighterImage.setImageResource(R.drawable.young_link);
                break;
            case ("Ganondorf"):
                mFighterImage.setImageResource(R.drawable.ganondorf);
                break;
            case ("Mewtwo"):
                mFighterImage.setImageResource(R.drawable.mewtwo);
                break;
            case ("Roy"):
                mFighterImage.setImageResource(R.drawable.roy);
                break;
            case ("Chrome"):
                mFighterImage.setImageResource(R.drawable.chrome);
                break;
            case ("Mr. Game & Watch"):
                mFighterImage.setImageResource(R.drawable.mr_game_and_watch);
                break;
            case ("Meta Knight"):
                mFighterImage.setImageResource(R.drawable.meta_knight);
                break;
            case ("Pit"):
                mFighterImage.setImageResource(R.drawable.pit);
                break;
            case ("Dark Pit"):
                mFighterImage.setImageResource(R.drawable.dark_pit);
                break;
            case ("Zero Suit Samus"):
                mFighterImage.setImageResource(R.drawable.zero_suit_samus);
                break;
            case ("Wario"):
                mFighterImage.setImageResource(R.drawable.wario);
                break;
            case ("Snake"):
                mFighterImage.setImageResource(R.drawable.snake);
                break;
            case ("Ike"):
                mFighterImage.setImageResource(R.drawable.ike);
                break;
            case ("Diddy Kong"):
                mFighterImage.setImageResource(R.drawable.diddy_kong);
                break;
            case ("Lucas"):
                mFighterImage.setImageResource(R.drawable.lucas);
                break;
            case ("Sonic"):
                mFighterImage.setImageResource(R.drawable.sonic);
                break;
            case ("King Dedede"):
                mFighterImage.setImageResource(R.drawable.king_dedede);
                break;
            case ("Olimar"):
                mFighterImage.setImageResource(R.drawable.olimar);
                break;


            default:
                mFighterImage.setImageResource(R.drawable.super_smash);
        }
    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }
}
