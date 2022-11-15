package edu.cvtc.myapplication;

import android.content.ContentValues;

import android.database.sqlite.SQLiteDatabase;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.BattleNoteEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.FighterEntry;

// The class helps create our database. This class will
// establish a connection to our database and insert
// our default data into our tables.
public class SuperSmashDataWorker {
    // Member Attributes
    private SQLiteDatabase mDb;

    // Constructor
    public SuperSmashDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    private void insertBattleNote(String heading, String body) {
        ContentValues values = new ContentValues();
        values.put(BattleNoteEntry.COLUMN_HEADING, heading);
        values.put(BattleNoteEntry.COLUMN_BODY, body);

        long newRowId = mDb.insert(BattleNoteEntry.TABLE_NAME, null, values);
    }

    // Method used to populate our database with initial Battle Notes data.
    public void insertBattleNotes() {
        insertBattleNote("Note 1", "My Message");
        insertBattleNote("Note 2", "My Message");
    }

    private void insertFighter(String name, String image, String franchise, String franchiseSymbol,
                               String specialNeutral, String specialSide, String specialDown,
                               String specialUp) {
        ContentValues values = new ContentValues();
        values.put(FighterEntry.COLUMN_NAME, name);
        values.put(FighterEntry.COLUMN_IMAGE, image);
        values.put(FighterEntry.COLUMN_FRANCHISE, franchise);
        values.put(FighterEntry.COLUMN_FRANCHISE_SYMBOL, franchiseSymbol);
        values.put(FighterEntry.COLUMN_SPECIAL_NEUTRAL, specialNeutral);
        values.put(FighterEntry.COLUMN_SPECIAL_SIDE, specialSide);
        values.put(FighterEntry.COLUMN_SPECIAL_DOWN, specialDown);
        values.put(FighterEntry.COLUMN_SPECIAL_UP, specialUp);

        long newRowId = mDb.insert(FighterEntry.TABLE_NAME, null, values);
    }

    // Method Used to populate out database with initial Fighters data.
    private void insertFighters() {
        insertFighter("Mario", "mario", "Mario", "mario_series",
                "Fireball", "Cape", "Super Jump Punch", "F.L.U.D.D");
        insertFighter("Link", "link", "The Legend of Zelda", "zelda_series",
                "Hero's Bow", "Boomerang", "Spin Attack", "Remote Bomb");
    }
}
