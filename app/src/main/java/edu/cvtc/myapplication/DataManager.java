package edu.cvtc.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.BattleNoteEntry;

// This class is used to communicate with the database.
// We we use it to load and save information to the database
public class DataManager {

    // Member Attributes
    private static DataManager ourInstance = null;
    private List<BattleNote> mBattleNotes = new ArrayList<>();

    // Set a reference to our new instance.
    public static DataManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataManager();
        }
        return ourInstance;
    }

    // Returns a list of our battle notes.
    public List<BattleNote> getBattleNotes() {
        return mBattleNotes;
    }

    private static void loadBattleNotesFromDatabase(Cursor cursor) {
        // Retrieve the field positions in our database.
        // The positions of fields may change over time as the database grows, so
        // we want to use your constants to reference where those positions are in
        // the table.
        int listHeadingPosition =
                cursor.getColumnIndex(BattleNoteEntry.COLUMN_HEADING);
        int listBodyPosition =
                cursor.getColumnIndex(BattleNoteEntry.COLUMN_BODY);
        int idPosition = cursor.getColumnIndex(BattleNoteEntry._ID);

        // Create an instance of our DataManager and use the DataManager
        // to clear any information from the array list.
        DataManager dm = getInstance();
        dm.mBattleNotes.clear();

        // Loop through the cursor rows and add new course objects to
        // our array list.
        while (cursor.moveToNext()) {
            String listHeading =
                    cursor.getString(listHeadingPosition);
            String listBody =
                    cursor.getString(listBodyPosition);
            int id = cursor.getInt(idPosition);

            BattleNote list = new BattleNote(id, listHeading, listBody);

            dm.mBattleNotes.add(list);
        }

        // Closes the cursor (to prevent memory leaks)
        cursor.close();
    }

    // Populate our Cursor object before calling the
    // loadBattleNotesFromDatabase.
    public static void getBattleNotesFromDatabase(SuperSmashOpenHelper dbHelper) {
        // Open our database in read mode.
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Create a list of columns you want to return.
        String[] battleNotesColumns = {
                BattleNoteEntry.COLUMN_HEADING,
                BattleNoteEntry.COLUMN_BODY,
                BattleNoteEntry._ID
        };

        // Create an order by field with the results of the query.
        String battleNoteOrderBy = BattleNoteEntry.COLUMN_HEADING;

        // Populate our cursor with the results of the query.
        final Cursor battleNoteCursor = db.query(BattleNoteEntry.TABLE_NAME,
                battleNotesColumns,
                null, null, null, null,
                battleNoteOrderBy);

        // Call the method to load our array list.
        loadBattleNotesFromDatabase(battleNoteCursor);
    }

    public int createNewBattleNote() {
        // Create an empty course object to use on your activity screen
        // when you want a "blank" record to show up. It will return the
        // size of the new course array list.
        BattleNote battleNote = new BattleNote(null, null);
        mBattleNotes.add(battleNote);
        return mBattleNotes.size();
    }

    public void removeCourse(int index) {
        mBattleNotes.remove(index);
    }
}
