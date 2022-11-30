package edu.cvtc.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.BattleNoteEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.FighterEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.TrackerEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.ItemEntry;

// Allows us to crate an update our database
public class SuperSmashOpenHelper extends SQLiteOpenHelper {
    // Constants for our Database name and version
    public static final String DATABASE_NAME = "SuperSmash.db";
    public static final int DATABASE_VERSION = 1;

    // Constructor
    public SuperSmashOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BattleNoteEntry.SQL_CREATE_TABLE);
        db.execSQL(BattleNoteEntry.SQL_CREATE_INDEX1);

        db.execSQL(FighterEntry.SQL_CREATE_TABLE);
        db.execSQL(FighterEntry.SQL_CREATE_INDEX1);

        db.execSQL(TrackerEntry.SQL_CREATE_TABLE);
        db.execSQL(TrackerEntry.SQL_CREATE_INDEX1);

        db.execSQL(ItemEntry.SQL_CREATE_TABLE);
        db.execSQL(ItemEntry.SQL_CREATE_INDEX1);

        SuperSmashDataWorker worker = new SuperSmashDataWorker(db);
        worker.insertBattleNotes();
        worker.insertFighters();
        worker.insertTrackers();
        worker.insertItems();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
