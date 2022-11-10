package edu.cvtc.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.BattleNoteEntry;

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

        SuperSmashDataWorker worker = new SuperSmashDataWorker(db);
        worker.insertBattleNotes();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
