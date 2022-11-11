package edu.cvtc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.BattleNoteEntry;


import edu.cvtc.myapplication.databinding.ActivityNotesBinding;

public class NotesActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    // Member Variables
    private SuperSmashOpenHelper mDbOpenHelper;
    private RecyclerView mRecyclerItems;
    private LinearLayoutManager mBattleNotesLayoutManager;
    private BattleNoteRecyclerAdapter mBattleNotesRecyclerAdapter;

    public static final int LOADER_BATTLE_NOTES = 0;

    // Boolean to check if the 'onCreateLoader' method had run
    private boolean mIsCreated = false;

    private ActivityNotesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        // Enables the up arrow for the activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this, BattleNoteActivity.class));
            }
        });

        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        // Retrieve the information from your database;
        DataManager.getBattleNotesFromDatabase(mDbOpenHelper);

        // Set a reference to your list of notes layout
        mRecyclerItems = (RecyclerView) findViewById(R.id.list_notes);
        mBattleNotesLayoutManager = new LinearLayoutManager(this);

        // We do not have a cursor yet, so pass null
        mBattleNotesRecyclerAdapter = new BattleNoteRecyclerAdapter(this, null);

        // Display the battle notes
        displayBattleNotes();
    }

    private void displayBattleNotes() {
        mRecyclerItems.setLayoutManager(mBattleNotesLayoutManager);
        mRecyclerItems.setAdapter(mBattleNotesRecyclerAdapter);
    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Using restartLoader instead of initLoader to make sure
        // you re-query the database each time the activity is
        // loaded in the app.
        LoaderManager.getInstance(this).
                restartLoader(LOADER_BATTLE_NOTES, null, this);
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        // Create new cursor loader
        CursorLoader loader = null;

        if (id == LOADER_BATTLE_NOTES) {
            loader = new CursorLoader(this) {
                @Override
                public Cursor loadInBackground() {
                    mIsCreated = true;
                    // Open your database in read mode.
                    SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

                    // Create a list of columns you want to return.
                    String[] battleNoteColumns = {
                            BattleNoteEntry.COLUMN_HEADING,
                            BattleNoteEntry.COLUMN_BODY,
                            BattleNoteEntry._ID
                    };

                    // Create an order by field for sorting purposes.
                    String battleNoteOrderBy = BattleNoteEntry.COLUMN_HEADING;

                    // Populate your cursor with the results of the query.
                    return db.query(BattleNoteEntry.TABLE_NAME, battleNoteColumns,
                            null, null, null, null,
                            battleNoteOrderBy);
                }
            };
        }
        return loader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        if (loader.getId() == LOADER_BATTLE_NOTES && mIsCreated) {
            // Associate the cursor with our RecyclerAdapter
            mBattleNotesRecyclerAdapter.changeCursor(data);
            mIsCreated = false;
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        if (loader.getId() == LOADER_BATTLE_NOTES) {
            // Change the cursor to null (cleanup)
            mBattleNotesRecyclerAdapter.changeCursor(null);
        }
    }
}