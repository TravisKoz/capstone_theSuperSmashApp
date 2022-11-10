package edu.cvtc.myapplication;

import android.provider.BaseColumns;

// This class sets ups constants that are used
//in the creation of our database tables
public final class SuperSmashDatabaseContract {

    private SuperSmashDatabaseContract() {}

    // The BaseColumns class allows us to automatically add an ID to each
    // of our tables.  An ID will be used to select individual records and/or
    // update those records.
    public static final class BattleNoteEntry implements BaseColumns {
        // Constants holding our table and field names.
        public static final String
        TABLE_NAME = "battle_notes";
        public static final String
        COLUMN_HEADING = "heading";
        public static final String
        COLUMN_BODY = "body";

        // Constants holding our values for the index name and values based on
        // the heading.
        public static final String INDEX1 = TABLE_NAME + "_index1";
        public static final String SQL_CREATE_INDEX1 =
                "CREATE INDEX " + INDEX1 + " ON " + TABLE_NAME +
                        "(" + COLUMN_HEADING + ")";

        // Constant to create the table using the table name, fields, and id.
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_HEADING + " TEXT NOT NULL, " +
                        COLUMN_BODY + " TEXT)";
    }
}
