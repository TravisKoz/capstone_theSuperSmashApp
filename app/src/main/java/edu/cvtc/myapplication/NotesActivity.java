package edu.cvtc.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.cvtc.myapplication.databinding.ActivityNotesBinding;

public class NotesActivity extends AppCompatActivity {

    // Member Variables
    private SuperSmashOpenHelper mDbOpenHelper;
    private RecyclerView mRecyclerItems;
    private LinearLayoutManager mBattleNotesLayoutManager;
    private BattleNoteRecyclerAdapter mBattleNotesRecyclerAdapter;
    public static final int ITEM_BATTLE_NOTES = 0;

    private AppBarConfiguration appBarConfiguration;
    private ActivityNotesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

        // Get our battle notes
        List<BattleNote> battleNotes = DataManager.getInstance().getBattleNotes();

        // Fill the RecyclerAdapter with our battle notes
        mBattleNotesRecyclerAdapter = new BattleNoteRecyclerAdapter(this, battleNotes);

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

}