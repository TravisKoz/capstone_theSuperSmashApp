package edu.cvtc.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.BattleNoteEntry;

public class BattleNoteActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    // Constants
    public static final String NOTE_ID =
            "edu.cvtc.myapplication.NOTE_ID";
    public static final String ORIGINAL_NOTE_HEADING =
            "edu.cvtc.myapplication.ORIGINAL_NOTE_HEADING";
    public static final String ORIGINAL_NOTE_BODY =
            "edu.cvtc.myapplication.ORIGINAL_NOTE_BODY";
    public static final int ID_NOT_SET = -1;

    public static final int LOADER_BATTLE_NOTES = 0;

    // INITIALIZE NEW BattleNote to empty
    private BattleNote mBattleNote = new BattleNote(0, "", "");

    // Member Variables
    private boolean mIsNewBattleNote;
    private boolean mIsCancelling;
    private int mBattleNoteId;
    private int mBattleNoteHeadingPosition;
    private int mBattleNoteBodyPosition;
    private String mOriginalBattleNoteHeading;
    private String mOriginalBattleNoteBody;

    // Member objects
    private EditText mTextBattleNoteHeading;
    private EditText mTextBattleNoteBody;
    private SuperSmashOpenHelper mDbOpenHelper;
    private Cursor mBattleNoteCursor;

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_note);

        // Sets the Up Arrow icon to a save icon.
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_save_icon);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        readDisplayStateValues();

        // If the bundle is null, save the values.  Otherwise
        // restore the original values.
        if (savedInstanceState == null) {
            saveOriginalBattleNoteValues();
        } else {
            restoreOriginalBattleNoteValues(savedInstanceState);
        }

        // Get reference to EditText objects in the layout.
        mTextBattleNoteHeading =
                findViewById(R.id.text_note_heading);
        mTextBattleNoteBody =
                findViewById(R.id.text_note_body);

        if (!mIsNewBattleNote) {
            LoaderManager.getInstance(this).initLoader(LOADER_BATTLE_NOTES, null, this);
        }
    }

    private void displayBattleNote() {
        // Retrieve the values from the cursor base upon
        // the position of the columns.
        String battleNoteHeading = mBattleNoteCursor.getString(mBattleNoteHeadingPosition);
        String battleNoteBody = mBattleNoteCursor.getString(mBattleNoteBodyPosition);

        // Use the information to populate the layout.
        mTextBattleNoteHeading.setText(battleNoteHeading);
        mTextBattleNoteBody.setText(battleNoteBody);
    }

    private void restoreOriginalBattleNoteValues(Bundle savedInstanceState) {
        // Get the original values from the savedInstanceState
        mOriginalBattleNoteHeading =
                savedInstanceState.getString(ORIGINAL_NOTE_HEADING);
        mOriginalBattleNoteBody =
                savedInstanceState.getString(ORIGINAL_NOTE_BODY);
    }

    private void saveOriginalBattleNoteValues() {
        // Only save values if you do not have a new course
        if (!mIsNewBattleNote) {
            mOriginalBattleNoteHeading = mBattleNote.getHeading();
            mOriginalBattleNoteBody = mBattleNote.getBody();
        }
    }

    private void readDisplayStateValues() {
        // Get the intent passed into the activity.
        Intent intent = getIntent();

        // Get the course id passed into the intent
        mBattleNoteId = intent.getIntExtra(NOTE_ID, ID_NOT_SET);

        // If the battle  note id isn't set, create a new battle note
        mIsNewBattleNote = mBattleNoteId == ID_NOT_SET;
        if (mIsNewBattleNote) {
            createNewBattleNote();
        }
    }

    private void createNewBattleNote() {
        // Create ContentValues object to hold our fields
        ContentValues values = new ContentValues();

        // For a new battle note, we don't know what the values
        // will be, so we set the columns to empty strings.
        values.put(BattleNoteEntry.COLUMN_HEADING, "");
        values.put(BattleNoteEntry.COLUMN_BODY, "");

        // Get connection to the database. Use the writable
        // method since we are changing the data.
        SQLiteDatabase db = mDbOpenHelper.getWritableDatabase();

        // Insert the new row in the database and assign the new id
        // to our member variable for course id. Cast the 'long'
        // return value to an int.
        mBattleNoteId = (int) db.insert(BattleNoteEntry.TABLE_NAME, null, values);
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        // Create a local cursor loader
        CursorLoader loader = null;

        // Check to see if the id is for our loader
        if (id == LOADER_BATTLE_NOTES) {
            loader = createLoaderBattleNotes();
        }
        return loader;
    }

    private CursorLoader createLoaderBattleNotes() {

        return new CursorLoader(this) {
            public Cursor loadInBackground() {
                // Open a connection to the database() {
                SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

                // Build the selection criteria. In this case, you want
                // to set the ID of the course to the passed-in
                // note id from the Intent.
                String selection = BattleNoteEntry._ID + " = ?";
                String[] selectionArgs = {Integer.toString(mBattleNoteId)};

                // Create a list of the columns we are pulling from
                // the database.
                String[] battleNoteColumns = {
                        BattleNoteEntry.COLUMN_HEADING,
                        BattleNoteEntry.COLUMN_BODY
                };

                // Fill our cursor with the information we have provided.
                return db.query(BattleNoteEntry.TABLE_NAME, battleNoteColumns,
                        selection, selectionArgs, null, null, null);
            }
        };
    }

    @Override
    // Called when data is loaded
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        // Check to see if this is our cursor for our loader
        if (loader.getId() == LOADER_BATTLE_NOTES) {
            loadFinishedBattleNotes(data);
        }
    }

    private void loadFinishedBattleNotes(Cursor data) {
        // Populate our member cursor with the data
        mBattleNoteCursor = data;

        // Get the positions of the fields in the cursor so that
        // we are able to retrieve them into our layout.
        mBattleNoteHeadingPosition =
                mBattleNoteCursor.getColumnIndex(BattleNoteEntry.COLUMN_HEADING);
        mBattleNoteBodyPosition =
                mBattleNoteCursor.getColumnIndex(BattleNoteEntry.COLUMN_BODY);

        // Make sure that you have moved to the correct record.
        // The cursor will not have populated any of the
        // fields until you move it.
        mBattleNoteCursor.moveToNext();

        // Call the method to display the battle note.
        displayBattleNote();
    }

    @Override
    // Called during cleanup
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        // Check to see if this is our cursor for our loader
        if (loader.getId() == LOADER_BATTLE_NOTES) {
            // If the cursor is not null, close it
            if (mBattleNoteCursor != null) {
                mBattleNoteCursor.close();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_battle_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as we specify a parent activity in AndroidManifest.xml
        int id = item.getItemId();

        if (id == R.id.action_cancel) {
            mIsCancelling = true;
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void saveCourseToDatabase(String battleNoteHeading,
                                      String battleNoteBody) {
        // Create selection criteria
        final String selection = BattleNoteEntry._ID + " = ?";
        final String[] selectionArgs = {Integer.toString(mBattleNoteId)};

        // Use a ContentValues object to put our information into.
        final ContentValues values = new ContentValues();
        values.put(BattleNoteEntry.COLUMN_HEADING, battleNoteHeading);
        values.put(BattleNoteEntry.COLUMN_BODY, battleNoteBody);

        AsyncTaskLoader<String> task = new AsyncTaskLoader<String>(this) {
            @Nullable
            @Override
            public String loadInBackground() {
                // Get connection to the database. Using the writable
                // method since we are changing the data.
                SQLiteDatabase db = mDbOpenHelper.getWritableDatabase();

                // Call the update method
                db.update(BattleNoteEntry.TABLE_NAME, values, selection, selectionArgs);
                return null;
            }
        };

        task.loadInBackground();
    }

    private void storePreviousBattleNoteValues() {
        mBattleNote.setHeading(mOriginalBattleNoteHeading);
        mBattleNote.setBody(mOriginalBattleNoteBody);
    }

    private void saveCourse() {
        // Get the values from the layout
        String battleNoteHeading = mTextBattleNoteHeading.getText().toString();
        String battleNoteBody = mTextBattleNoteBody.getText().toString();

        // Call the method to write to the database
        saveCourseToDatabase(battleNoteHeading, battleNoteBody);
    }

    private void deleteBattleNoteFromDatabase() {
        // Create selection criteria
        final String selection = BattleNoteEntry._ID + " = ?";
        final String[] selectionArgs = {Integer.toString(mBattleNoteId)};

        AsyncTaskLoader<String> task = new AsyncTaskLoader<String>(this) {
            @Nullable
            @Override
            public String loadInBackground() {
                // Get connection to the database. Using the writable
                // method since we are changing the data.
                SQLiteDatabase db = mDbOpenHelper.getWritableDatabase();

                // Call the delete method
                db.delete(BattleNoteEntry.TABLE_NAME, selection, selectionArgs);
                return null;
            }
        };

        task.loadInBackground();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Did the user cancel the process?
        if (mIsCancelling) {
            // Is this a battle note?
            if (mIsNewBattleNote) {
                // Delete the new battle note.
                deleteBattleNoteFromDatabase();
            } else {
                // Put the original values on the screen.
                storePreviousBattleNoteValues();
            }
        } else {
            // Save the data when leaving the activity.
            if (mTextBattleNoteHeading.getText().toString().equals("")) {
                deleteBattleNoteFromDatabase();
            } else {
                saveCourse();
            }
        }
    }
}
