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

    // Member Variables
    private int mFighterID;
    private int mFighterNamePosition;
    private int mFighterFranchisePosition;
    private int mFighterSpecialNeutralPosition;
    private int mFighterSpecialSidePosition;
    private int mFighterSpecialDownPosition;
    private int mFighterSpecialUpPosition;
    private int mFighterNeutralDescriptionPosition;
    private int mFighterSideDescriptionPosition;
    private int mFighterDownDescriptionPosition;
    private int mFighterUpDescriptionPosition;
    private int mFighterFinalSmashPosition;
    private int mFighterFinalSmashDescriptionPosition;

    // Member objects
    private TextView mFighterName;
    private ImageView mFighterImage;
    private ImageView mFighterSeriesSymbol;
    private TextView mFighterSeries;
    private TextView mFighterNeutralSpecial;
    private TextView mFighterSideSpecial;
    private TextView mFighterDownSpecial;
    private TextView mFighterUpSpecial;
    private TextView mFighterNeutralDescription;
    private TextView mFighterSideDescription;
    private TextView mFighterDownDescription;
    private TextView mFighterUpDescription;
    private TextView mFighterFinalSmash;
    private TextView mFighterFinalSmashDescription;
    private SuperSmashOpenHelper mDbOpenHelper;
    private Cursor mFighterCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighter_details);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        // Get the intent passed into the activity
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
        mFighterNeutralDescription =
                findViewById(R.id.neutral_b_description);
        mFighterSideDescription =
                findViewById(R.id.side_b_description);
        mFighterDownDescription =
                findViewById(R.id.down_b_description);
        mFighterUpDescription =
                findViewById(R.id.up_b_description);
        mFighterFinalSmash =
                findViewById(R.id.final_smash_name);
        mFighterFinalSmashDescription =
                findViewById(R.id.final_smash_description);
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
                FighterEntry.COLUMN_NEUTRAL_DESCRIPTION,
                FighterEntry.COLUMN_SIDE_DESCRIPTION,
                FighterEntry.COLUMN_DOWN_DESCRIPTION,
                FighterEntry.COLUMN_UP_DESCRIPTION,
                FighterEntry.COLUMN_FINAL_SMASH,
                FighterEntry.COLUMN_FINAL_DESCRIPTION
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
        mFighterNeutralDescriptionPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_NEUTRAL_DESCRIPTION);
        mFighterSideDescriptionPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_SIDE_DESCRIPTION);
        mFighterDownDescriptionPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_DOWN_DESCRIPTION);
        mFighterUpDescriptionPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_UP_DESCRIPTION);
        mFighterFinalSmashPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_FINAL_SMASH);
        mFighterFinalSmashDescriptionPosition =
                mFighterCursor.getColumnIndex(FighterEntry.COLUMN_FINAL_DESCRIPTION);

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
        String fighterNeutralDescription = mFighterCursor.getString(mFighterNeutralDescriptionPosition);
        String fighterSideDescription = mFighterCursor.getString(mFighterSideDescriptionPosition);
        String fighterDownDescription = mFighterCursor.getString(mFighterDownDescriptionPosition);
        String fighterUpDescription = mFighterCursor.getString(mFighterUpDescriptionPosition);
        String fighterFinalSmash = mFighterCursor.getString(mFighterFinalSmashPosition);
        String fighterFinalSmashDescription = mFighterCursor.getString(mFighterFinalSmashDescriptionPosition);

        // Use information to populate layout TextViews
        mFighterName.setText(fighterName);
        mFighterSeries.setText(fighterSeries);
        mFighterNeutralSpecial.setText(fighterNeutralSpecial);
        mFighterSideSpecial.setText(fighterSideSpecial);
        mFighterDownSpecial.setText(fighterDownSpecial);
        mFighterUpSpecial.setText(fighterUpSpecial);
        mFighterNeutralDescription.setText(fighterNeutralDescription);
        mFighterSideDescription.setText(fighterSideDescription);
        mFighterDownDescription.setText(fighterDownDescription);
        mFighterUpDescription.setText(fighterUpDescription);
        mFighterFinalSmash.setText(fighterFinalSmash);
        mFighterFinalSmashDescription.setText(fighterFinalSmashDescription);

        // Formatted the passed in fighter's name String to match our image names convention.
        // Symbols are replaced with corresponding characters and all letters and converted to lower case.
        String imageResource = fighterName.replace(" ", "_").replace(".","")
                .replace("&", "and").replace("-", "_").toLowerCase();

        String symbolResource = fighterSeries.replace(" ", "_").replace("!","")
                .replace("&", "and").replace("-", "_").replace(".", "").toLowerCase();

        // Formatted string to match the head image naming format.
        String seriesResource = symbolResource + "_series";

        // Gets the resourceID for our selected fighter's image.
        int imageResourceID = this.getResources().getIdentifier(imageResource, "drawable", this.getPackageName());

        // Gets the resourceID for our selected fighter's series.
        int seriesResourceID = this.getResources().getIdentifier(seriesResource, "drawable", this.getPackageName());

        // Changes the displayed fighter's image and fighter's series image based on our resourceIDs.
        mFighterImage.setImageResource(imageResourceID);
        mFighterSeriesSymbol.setImageResource(seriesResourceID);
    }


    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }
}
