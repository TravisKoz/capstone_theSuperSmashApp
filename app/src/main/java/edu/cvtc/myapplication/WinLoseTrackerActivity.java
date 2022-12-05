package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.TrackerEntry;

public class WinLoseTrackerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Set up global member objects.
    private TextView mWinCount;
    private TextView mLossCount;
    private TextView mWinPercentage;
    private ImageView mFighterImage;
    private ImageView mFighterHeadImage;
    private Spinner mSpinner;
    private SuperSmashOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_lose_tracker);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        // Get references to our TextViews
        mWinCount = findViewById(R.id.win_number);
        mLossCount = findViewById(R.id.loss_number);
        mWinPercentage = findViewById(R.id.win_loss_percentage_number);

        // Get reference to our fighter ImageView
        mFighterImage = findViewById(R.id.fighter_tracker_image);
        mFighterHeadImage = findViewById(R.id.fighter_head_image);

        // Create references to our Buttons
        Button incrementWinButton = findViewById(R.id.win_button);
        Button incrementLossButton = findViewById(R.id.loss_button);
        Button resetWinsAndLossesButton = findViewById(R.id.reset_button);

        // Sets a click event on our Win Button
        incrementWinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gets the currently selected fighter's name.
                String selectedFighter = mSpinner.getSelectedItem().toString();

                // Increment the wins in the database by 1
                incrementWinsOrLosses(TrackerEntry.COLUMN_WINS, mWinCount, selectedFighter);

                // Display new win, lose, and win % values.
                Tracker winsAndLosses = getWinsAndLosses();
                displayWinsAndLosses(winsAndLosses);
                displayWinPercentage();
            }
        });

        // Sets a click event on our Loss Button.
        incrementLossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gets the currently selected fighter's name.
                String selectedFighter = mSpinner.getSelectedItem().toString();

                // Increment the losses in the database by 1
                incrementWinsOrLosses(TrackerEntry.COLUMN_LOSSES, mLossCount, selectedFighter);

                // Display new win, lose, and win % values.
                Tracker winsAndLosses = getWinsAndLosses();
                displayWinsAndLosses(winsAndLosses);
                displayWinPercentage();
            }
        });

        // Sets a click event on our Reset Button.
        resetWinsAndLossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gets the currently selected fighter's name.
                String selectedFighter = mSpinner.getSelectedItem().toString();

                // Sets both wins and losses in the database back to
                // 0 for the currently selected fighter.
                resetWinsAndLosses(selectedFighter);

                // Sets the displayed wins and losses back to 0.
                Tracker winsAndLosses = getWinsAndLosses();
                displayWinsAndLosses(winsAndLosses);

                // Set percentage back to default values.
                mWinPercentage.setText("0.00%");
                mWinPercentage.setTextColor(Color.WHITE);
            }
        });

        // Sets the list of fighters in the spinner.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_fighters, getResources().getStringArray(R.array.fighters_spinner));

        // Create the spinner
         mSpinner = findViewById(R.id.fighters_spinner);
        if (mSpinner != null) {
            mSpinner.setOnItemSelectedListener(this);
        }

        // Specify the layout to use when the list of fighters appears
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_fighters);

        // Apply the adapter to the spinner
        if (mSpinner != null) {
            mSpinner.setAdapter(adapter);
        }
    }

    // This code runs whenever a fighter is selected from the spinner.
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Gets the currently selected fighter's name.
        String selectedFighter = mSpinner.getSelectedItem().toString();

        // Replaces the displayed image with the image of our newly selected fighter.
        replaceFighterImage(selectedFighter);

        // Gets and displays the current wins and losses for the selected fighter,
        Tracker winsAndLosses = getWinsAndLosses();
        displayWinsAndLosses(winsAndLosses);

        // Used to prevent a divide by zero error in the case no fights have been
        // tracked for the selected fighter yet.
        if (Integer.parseInt(String.valueOf(mWinCount.getText())) > 0) {
            displayWinPercentage();
        } else if (Integer.parseInt(String.valueOf(mLossCount.getText())) > 0) {
                displayWinPercentage();
        } else {
            mWinPercentage.setText("0.00%");
            mWinPercentage.setTextColor(Color.WHITE);
        }
    }

    // Not being used, but this required to be here since we are implementing
    // AdapterView.OnItemSelectedListener.
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }

    // This method handles getting the wins and losses for the currently selected
    // fighter from the database.
    public Tracker getWinsAndLosses () {
        // Gets the currently selected fighter's name.
        String selectedFighter = mSpinner.getSelectedItem().toString();

        // Create a new Tracker object.
        Tracker tracker = new Tracker(null, 0, 0);

        // Opens our database in readonly mode.
        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

        // Creates a new cursor object based on a select
        Cursor trackerCursor = db.rawQuery("select * from " + TrackerEntry.TABLE_NAME + " where "
                + TrackerEntry.COLUMN_FIGHTER + " = ?", new String[]{selectedFighter});

        // Get the column index position for wins and losses in the database
        // not hard coded in case database table structure ever changes.
        int winPosition = trackerCursor.getColumnIndex(TrackerEntry.COLUMN_WINS);
        int lossPosition = trackerCursor.getColumnIndex(TrackerEntry.COLUMN_LOSSES);

        // Moves the cursor to the next instance in the database
        // There should only be one instance based on the database design.
        if (trackerCursor.moveToNext()) {
            // Set the tracker objects wins and losses
            tracker.setWins(trackerCursor.getInt(winPosition));
            tracker.setLosses(trackerCursor.getInt(lossPosition));
        }

        // Closes the tracker to prevent memory leaks
        trackerCursor.close();

        return tracker;
    }

    // This method handles displaying the current wins and losses
    // based on the passed in tracker object.
    private void displayWinsAndLosses(Tracker tracker) {
        // Set the the displayed wins and losses to the values
        // on the tracker object.
        mWinCount.setText(Integer.toString(tracker.getWins()));
        mLossCount.setText(Integer.toString(tracker.getLosses()));
    }

    // The method handles incrementing the wins and losses in the database.
    private void incrementWinsOrLosses (String incrementColumn, TextView countView, String selectedFighter) {

        // Set the new count of wins or losses by added 1.
        int newCount = Integer.parseInt(String.valueOf(countView.getText())) + 1;

        // Opens the database in writeable mode.
        SQLiteDatabase db = mDbOpenHelper.getWritableDatabase();

        // Defines the value we want to update the wins or
        // losses to.
        ContentValues cv = new ContentValues();
        cv.put(incrementColumn, newCount);

        // Runs the update statement using the content values defined above.
        db.update(TrackerEntry.TABLE_NAME, cv, TrackerEntry.COLUMN_FIGHTER + " = ?", new String[]{selectedFighter});
    }

    // This method resets the wins and losses for our selected
    // fighter back to zero in our database.
    private void resetWinsAndLosses(String selectedFighter) {

        // Opens our database in write mode.
        SQLiteDatabase db = mDbOpenHelper.getWritableDatabase();

        // Defines the values (in this case 0 for both) that we want to change
        // our selected fighters wins and losses to in the database.
        ContentValues cv = new ContentValues();
        cv.put(TrackerEntry.COLUMN_WINS, 0);
        cv.put(TrackerEntry.COLUMN_LOSSES, 0);

        // Runs the update statement using the content values defined above.
        db.update(TrackerEntry.TABLE_NAME, cv, TrackerEntry.COLUMN_FIGHTER + " = ?", new String[]{selectedFighter});
    }

    // This method updates and displays the fighter win position.
    private void displayWinPercentage() {

        // Define variable win, loss, and fight variables to hold counts.
        int winCount = Integer.parseInt(String.valueOf(mWinCount.getText()));
        int lossCount = Integer.parseInt(String.valueOf(mLossCount.getText()));
        int fightCount = winCount + lossCount;

        // Calculates our win percentage for the selected fighter.
        double winPercent = (double) winCount/ (double) fightCount * 100;

        // Displays the win percentage with 2 decimal points and
        // the percent sign.
        mWinPercentage.setText(String.format("%.2f", winPercent) + "%");

        // Sets the win percentage text to white, yellow, or red depending
        // on it's percentage.
        if (winPercent >= 50) {
            mWinPercentage.setTextColor(Color.WHITE);
        } else if (winPercent >= 25) {
            mWinPercentage.setTextColor(Color.YELLOW);
        } else {
            mWinPercentage.setTextColor(Color.RED);
        }
    }

    // This method replaces the displayed fighter with the image of the
    // fighter passed into it's parameters and the fighter's head image.
    private void replaceFighterImage (String selectedFighter) {

        // Formatted the passed in fighter's name String to match our image names convention.
        // Symbols are replaced with corresponding characters and all letters and converted to lower case.
        String imageResource = selectedFighter.replace(" ", "_").replace(".","")
                .replace("&", "and").replace("-", "_").toLowerCase();

        // Formatted string to match the head image naming format.
        String headResource = imageResource + "_head";

        // Gets the resourceID for our selected fighter's image.
        int imageResourceID = this.getResources().getIdentifier(imageResource, "drawable", this.getPackageName());

        // Gets the resourceID for our selected fighter's head image.
        int headImageResourceID = this.getResources().getIdentifier(headResource, "drawable", this.getPackageName());

        // Changes the displayed fighter's image and fighter's head image based on our resourceIDs.
        mFighterImage.setImageResource(imageResourceID);
        mFighterHeadImage.setImageResource(headImageResourceID);
    }
}