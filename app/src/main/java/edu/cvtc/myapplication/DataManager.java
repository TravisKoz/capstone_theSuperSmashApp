package edu.cvtc.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.BattleNoteEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.FighterEntry;

// This class is used to communicate with the database.
// We we use it to load and save information to the database
public class DataManager {

    // Member Attributes
    private static DataManager ourInstance = null;
    private List<BattleNote> mBattleNotes = new ArrayList<>();
    private List<Fighter> mFighters = new ArrayList<>();

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

    // Returns a list of our fighters()
    public List<Fighter> getFighters() {
        return mFighters;
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

    private static void loadFightersFromDatabase(Cursor cursor) {
        // Retrieve the field positions in your database.
        // The positions of fields may change over time as the database grows, so
        // you want to use your constants to reference where those positions are in
        // the table.
        int listNamePosition =
                cursor.getColumnIndex(FighterEntry.COLUMN_NAME);
        int listFranchisePosition =
                cursor.getColumnIndex(FighterEntry.COLUMN_FRANCHISE);
        int listSpecialNeutralPosition =
                cursor.getColumnIndex(FighterEntry.COLUMN_SPECIAL_NEUTRAL);
        int listSpecialSidePosition =
                cursor.getColumnIndex(FighterEntry.COLUMN_SPECIAL_SIDE);
        int listSpecialDownPosition =
                cursor.getColumnIndex(FighterEntry.COLUMN_SPECIAL_DOWN);
        int listSpecialUpPosition =
                cursor.getColumnIndex(FighterEntry.COLUMN_SPECIAL_UP);
        int listNeutralDescriptionPosition =
                cursor.getColumnIndex(FighterEntry.COLUMN_NEUTRAL_DESCRIPTION);
        int listSideDescriptionPosition =
                cursor.getColumnIndex(FighterEntry.COLUMN_SIDE_DESCRIPTION);
        int listDownDescriptionPosition =
                cursor.getColumnIndex(FighterEntry.COLUMN_DOWN_DESCRIPTION);
        int listUpDescriptionPosition =
                cursor.getColumnIndex(FighterEntry.COLUMN_UP_DESCRIPTION);
        int listFinalSmashPosition =
                cursor.getColumnIndex(FighterEntry.COLUMN_FINAL_SMASH);
        int listFinalSmashDescriptionPosition =
                cursor.getColumnIndex(FighterEntry.COLUMN_FINAL_DESCRIPTION);
        int idPosition =
                cursor.getColumnIndex(FighterEntry._ID);

        // Create an instance of your DataManager and use the DataManager
        // to clear any information from the array list.
        DataManager dm = getInstance();
        dm.mFighters.clear();

        // Loop through the cursor rows and add new fighter objects to
        // our array list.
        while (cursor.moveToNext()) {
            String listName =
                    cursor.getString(listNamePosition);
            String listFranchise =
                    cursor.getString(listFranchisePosition);
            String listSpecialNeutral =
                    cursor.getString(listSpecialNeutralPosition);
            String listSpecialSide =
                    cursor.getString(listSpecialSidePosition);
            String listSpecialDown =
                    cursor.getString(listSpecialDownPosition);
            String listSpecialUp =
                    cursor.getString(listSpecialUpPosition);
            String listNeutralDescription =
                    cursor.getString(listNeutralDescriptionPosition);
            String listSideDescription =
                    cursor.getString(listSideDescriptionPosition);
            String listDownDescription =
                    cursor.getString(listDownDescriptionPosition);
            String listUpDescription =
                    cursor.getString(listUpDescriptionPosition);
            String listFinalSmash =
                    cursor.getString(listFinalSmashPosition);
            String listFinalSmashDescription =
                    cursor.getString(listFinalSmashDescriptionPosition);
            int id = cursor.getInt(idPosition);

            Fighter list = new Fighter(id, listName, listFranchise, listSpecialNeutral,
                    listSpecialSide, listSpecialDown, listSpecialUp, listNeutralDescription,
                    listSideDescription, listDownDescription, listUpDescription, listFinalSmash,
                    listFinalSmashDescription);
            dm.mFighters.add(list);
        }

        // Close the cursor (to prevent memory leaks)
        cursor.close();
    }

    public static void getFightersFromDatabase(SuperSmashOpenHelper dbHelper) {
        // Open our database in read mode.
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Create a list columns we want to return.
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
                FighterEntry.COLUMN_FINAL_DESCRIPTION,
                FighterEntry._ID
        };

        // Create an order by field for sorting purposes.
        String fighterOrderBy = FighterEntry.COLUMN_NAME;

        // Populate our cursor with the results of the query.
        final Cursor fighterCursor = db.query(FighterEntry.TABLE_NAME,
                fighterColumns,
                null, null, null, null,
                fighterOrderBy);

        // Call the method to load our array list
        loadFightersFromDatabase(fighterCursor);
    }

    // Don't think I need this
    public void removeFighter(int index) {
        mFighters.remove(index);
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
