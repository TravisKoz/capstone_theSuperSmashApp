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

// import com.bumptech.glide.Glide;

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
                String selectedFighter = mSpinner.getSelectedItem().toString();

              incrementWinsOrLosses(TrackerEntry.COLUMN_WINS, mWinCount, selectedFighter);

                Tracker winsAndLosses = getWinsAndLosses();
                displayWinsAndLosses(winsAndLosses);
                displayWinPercentage();
            }
        });

        // Sets a click event on our Loss Button.
        incrementLossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedFighter = mSpinner.getSelectedItem().toString();
                incrementWinsOrLosses(TrackerEntry.COLUMN_LOSSES, mLossCount, selectedFighter);

                Tracker winsAndLosses = getWinsAndLosses();
                displayWinsAndLosses(winsAndLosses);
                displayWinPercentage();
            }
        });

        // Sets a click event on our Reset Button.
        resetWinsAndLossesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedFighter = mSpinner.getSelectedItem().toString();

                resetWinsAndLosses(selectedFighter);

                Tracker winsAndLosses = getWinsAndLosses();
                displayWinsAndLosses(winsAndLosses);

                mWinPercentage.setText("0.00%");
                mWinPercentage.setTextColor(Color.WHITE);
            }
        });

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

//       Glide.with(this).load(R.drawable.mario_down_b).into(test);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String selectedFighter = mSpinner.getSelectedItem().toString();

        // Replaces the displayed image with the image of our newly selected fighter.
        replaceFighterImage(selectedFighter);

        Tracker winsAndLosses = getWinsAndLosses();

        displayWinsAndLosses(winsAndLosses);

        if (Integer.parseInt(String.valueOf(mWinCount.getText())) > 0) {
            displayWinPercentage();
        } else if (Integer.parseInt(String.valueOf(mLossCount.getText())) > 0) {
                displayWinPercentage();
        } else {
            mWinPercentage.setText("0.00%");
            mWinPercentage.setTextColor(Color.WHITE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }

    public Tracker getWinsAndLosses () {
        String selectedFighter = mSpinner.getSelectedItem().toString();

        Tracker tracker = new Tracker(null, 0, 0);
        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

        Cursor trackerCursor = db.rawQuery("select * from " + TrackerEntry.TABLE_NAME + " where "
                + TrackerEntry.COLUMN_FIGHTER + " = ?", new String[]{selectedFighter});

        int winPosition = trackerCursor.getColumnIndex(TrackerEntry.COLUMN_WINS);
        int lossPosition = trackerCursor.getColumnIndex(TrackerEntry.COLUMN_LOSSES);

        if (trackerCursor.moveToNext())
            tracker.setWins(trackerCursor.getInt(winPosition));
            tracker.setLosses(trackerCursor.getInt(lossPosition));

        // Closes the tracker to prevent memory leaks
        trackerCursor.close();

        return tracker;
    }

    private void displayWinsAndLosses(Tracker tracker) {
        mWinCount.setText(Integer.toString(tracker.getWins()));
        mLossCount.setText(Integer.toString(tracker.getLosses()));
    }

    private void incrementWinsOrLosses (String incrementColumn, TextView countView, String selectedFighter) {
        int newCount = Integer.parseInt(String.valueOf(countView.getText())) + 1;

        SQLiteDatabase db = mDbOpenHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(incrementColumn, newCount);

        db.update(TrackerEntry.TABLE_NAME, cv, TrackerEntry.COLUMN_FIGHTER + " = ?", new String[]{selectedFighter});
    }

    // This function resets the wins and losses for our selected
    // fighter back to zero in our database.
    private void resetWinsAndLosses(String selectedFighter) {

        // Opens our database in write mode.
        SQLiteDatabase db = mDbOpenHelper.getWritableDatabase();

        // Defines the values (in this case 0 for both) that we want to change
        // our selected fighters wins and losses to in the database.
        ContentValues cv = new ContentValues();
        cv.put(TrackerEntry.COLUMN_WINS, 0);
        cv.put(TrackerEntry.COLUMN_LOSSES, 0);

        // Runs the update statement used the content values defined above.
        db.update(TrackerEntry.TABLE_NAME, cv, TrackerEntry.COLUMN_FIGHTER + " = ?", new String[]{selectedFighter});
    }

    private void displayWinPercentage() {
        int winCount = Integer.parseInt(String.valueOf(mWinCount.getText()));
        int lossCount = Integer.parseInt(String.valueOf(mLossCount.getText()));
        int fightCount = winCount + lossCount;

        // Calculates our win percentage for the selected fighter.
        double winPercent = (double) winCount/ (double) fightCount * 100;

        // Displays the
        mWinPercentage.setText(String.format("%.2f", winPercent) + "%");

        if (winPercent >= 50) {
            mWinPercentage.setTextColor(Color.WHITE);
        } else if (winPercent >= 25) {
            mWinPercentage.setTextColor(Color.YELLOW);
        } else {
            mWinPercentage.setTextColor(Color.RED);
        }
    }

    // This function replaced the displayed fighter with the  image of the
    // fighter passed into it's parameters.
    private void replaceFighterImage (String selectedFighter) {

        // Formatted the passed in fighter's name String to match our image names convention.
        // spaces are replaced with underscores(_) and all letters and converted to lower case.
        String imageResource = selectedFighter.replace(" ", "_").replace(".","")
                .replace("&", "and").replace("-", "_").toLowerCase();

        String headResource = imageResource + "_head";

        // Gets the resourceID for our selected fighter's image.
        int imageResourceID = this.getResources().getIdentifier(imageResource, "drawable", this.getPackageName());


        // Gets the resourceID for our selected fighter's head image
        int headImageResourceID = this.getResources().getIdentifier(headResource, "drawable", this.getPackageName());

        // Changes the displayed fighter's image and fighter's head image based on our resourceIDs.
        mFighterImage.setImageResource(imageResourceID);
        mFighterHeadImage.setImageResource(headImageResourceID);
    }
}