package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.AssistTrophyEntry;

public class TrophyDetailsActivity extends AppCompatActivity {

    public static final String TROPHY_ID = "edu.cvtc.myapplication.TROPHY_ID";
    public static final int ID_NOT_SET = -1;

    // Member Variables
    private int mTrophyID;
    private int mTrophyNamePosition;
    private int mTrophyDescriptionPosition;

    // Member objects
    private TextView mTrophyName;
    private ImageView mTrophyImage;
    private TextView mTrophyDescription;
    private SuperSmashOpenHelper mDbOpenHelper;
    private Cursor mTrophyCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophy_details);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        // Get the intent passed into the activity
        Intent intent = getIntent();
        mTrophyID = intent.getIntExtra(TROPHY_ID, ID_NOT_SET);

        // Set references to all layout controls
        mTrophyName =
                findViewById(R.id.trophy_name);
        mTrophyImage =
                findViewById(R.id.trophy_image);
        mTrophyDescription =
                findViewById(R.id.trophy_description);

        loadTrophyData();
    }

    private void loadTrophyData() {

        // Open a connection to the database
        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

        // Build the selection criteria. In this case, we want
        // to set the ID of the fighter to the passed-in
        // fighter id from the Intent.
        String selection = SuperSmashDatabaseContract.FighterEntry._ID + " = ?";
        String[] selectionArgs = {Integer.toString(mTrophyID)};

        // Create a list of the columns we are pulling from
        // the database.
        String[] trophyColumns = {
                AssistTrophyEntry.COLUMN_NAME,
                AssistTrophyEntry.COLUMN_DESCRIPTION };

        // Fill our cursor with the information we have provided
        mTrophyCursor = db.query(AssistTrophyEntry.TABLE_NAME, trophyColumns,
                selection, selectionArgs, null, null, null);

        // Get the positions of the fields in the cursor so that
        // we are able to retrieve them into our layout.
        mTrophyNamePosition =
                mTrophyCursor.getColumnIndex(AssistTrophyEntry.COLUMN_NAME);
        mTrophyDescriptionPosition =
                mTrophyCursor.getColumnIndex(AssistTrophyEntry.COLUMN_DESCRIPTION);

        // Make sure that we have moved to the correct record.
        // The cursor will not have populate any of the
        // fields until we move it.
        mTrophyCursor.moveToNext();

        // Call the method to display the fighter
        displayTrophy();
    }

    private void displayTrophy() {
        // Retrieve the values from the cursor based upon
        // the position of the columns.
        String trophyName = mTrophyCursor.getString(mTrophyNamePosition);
        String trophyDescription = mTrophyCursor.getString(mTrophyDescriptionPosition);

        // Use information to populate layout TextViews
        mTrophyName.setText(trophyName);
        mTrophyDescription.setText(trophyDescription);

        // Formatted the passed in trophy's name String to match our image names convention.
        // Symbols are replaced with corresponding characters and all letters and converted to lower case.
        String imageResource = "trophy_" + trophyName.replace(" ", "_").replace(".","")
                .replace("&", "and").replace("-", "_").replace("'", "_").toLowerCase();

        // Gets the resourceID for our selected trophy's image.
        int imageResourceID = this.getResources().getIdentifier(imageResource, "drawable", this.getPackageName());

        // Changes the displayed fighter's image and fighter's series image based on our resourceIDs.
        mTrophyImage.setImageResource(imageResourceID);
    }
}