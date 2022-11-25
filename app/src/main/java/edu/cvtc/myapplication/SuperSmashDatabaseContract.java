package edu.cvtc.myapplication;

import android.provider.BaseColumns;

// This class sets ups constants that are used
//in the creation of our database tables
public final class SuperSmashDatabaseContract {

    private SuperSmashDatabaseContract() {
    }

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

    // The BaseColumns class allows us to automatically add an ID to each
    // of our tables.  An ID will be used to select individual records and/or
    // update those records.
    public static final class FighterEntry implements BaseColumns {
        // Constants holding our table and field names.
        public static final String
                TABLE_NAME = "fighters";
        public static final String
                COLUMN_NAME = "name";
        public static final String
                COLUMN_FRANCHISE = "franchise";
        public static final String
                COLUMN_SPECIAL_NEUTRAL = "special_neutral";
        public static final String
                COLUMN_SPECIAL_SIDE = "special_side";
        public static final String
                COLUMN_SPECIAL_DOWN = "special_down";
        public static final String
                COLUMN_SPECIAL_UP = "special_up";
        public static final String
                COLUMN_NEUTRAL_DESCRIPTION = "neutral_description";
        public static final String
                COLUMN_SIDE_DESCRIPTION = "side_description";
        public static final String
                COLUMN_DOWN_DESCRIPTION = "down_description";
        public static final String
                COLUMN_UP_DESCRIPTION = "up_description";
        public static final String
                COLUMN_FINAL_SMASH = "final_smash";
        public static final String
                COLUMN_FINAL_DESCRIPTION = "final_description";

        // Constants holding our values for the index name and values based on
        // the fighter name.
        public static final String INDEX1 = TABLE_NAME + "_index1";
        public static final String SQL_CREATE_INDEX1 =
                "CREATE INDEX " + INDEX1 + " ON " + TABLE_NAME +
                        "(" + COLUMN_NAME + ")";

        // Constant to create the table using the table name, fields, and id.
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME + " TEXT NOT NULL, " +
                        COLUMN_FRANCHISE + " TEXT, " +
                        COLUMN_SPECIAL_NEUTRAL + " TEXT, " +
                        COLUMN_SPECIAL_SIDE + " TEXT, " +
                        COLUMN_SPECIAL_DOWN + " TEXT, " +
                        COLUMN_SPECIAL_UP + " TEXT, " +
                        COLUMN_NEUTRAL_DESCRIPTION + " TEXT, " +
                        COLUMN_SIDE_DESCRIPTION + " TEXT, " +
                        COLUMN_DOWN_DESCRIPTION + " TEXT, " +
                        COLUMN_UP_DESCRIPTION + " TEXT, " +
                        COLUMN_FINAL_SMASH + " TEXT, " +
                        COLUMN_FINAL_DESCRIPTION + " TEXT)";
    }

    public static final class TrackerEntry implements BaseColumns {
        // Constants holding our table and field names
        public static final String
            TABLE_NAME = "tracker";
        public static final String
            COLUMN_FIGHTER = "fighter";
        public static final String
            COLUMN_WINS = "wins";
        public static final String
            COLUMN_LOSSES = "losses";

        // Constants holding our values for the index name and values based on
        // the fighter name.
        public static final String INDEX1 = TABLE_NAME + "_index1";
        public static final String SQL_CREATE_INDEX1 =
                "CREATE INDEX " + INDEX1 + " ON " + TABLE_NAME +
                        "(" + COLUMN_FIGHTER + ")";

        // Constant to create the table using the table name, fields, and id.
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_FIGHTER + " TEXT NOT NULL, " +
                        COLUMN_WINS + " INTEGER, " +
                        COLUMN_LOSSES + " INTEGER)";
    }
}
