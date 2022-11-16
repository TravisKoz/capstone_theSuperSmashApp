package edu.cvtc.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.cvtc.myapplication.databinding.ActivityFightersBinding;

public class FightersActivity extends AppCompatActivity {

    private ActivityFightersBinding binding;

    // Member Variables
    private SuperSmashOpenHelper mDbOpenHelper;
    private RecyclerView mRecyclerItems;
    private LinearLayoutManager mFightersLayoutManager;
    private FighterRecyclerAdapter mFighterRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFightersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        // Enables the up arrow for the activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        // Retrieve the information from our database
        DataManager.getFightersFromDatabase(mDbOpenHelper);

        // Set a reference to our list of fighters layout
        mRecyclerItems = (RecyclerView) findViewById(R.id.list_fighters);
        mFightersLayoutManager = new LinearLayoutManager(this);

        // Get our fighters
        List<Fighter> fighters = DataManager.getInstance().getFighters();

        // Fill the RecycleAdapter with our fighters
        mFighterRecyclerAdapter = new FighterRecyclerAdapter(this, fighters);

        // Display the Fighters
        displayFighters();
    }

    private void displayFighters() {
        mRecyclerItems.setLayoutManager(mFightersLayoutManager);
        mRecyclerItems.setAdapter(mFighterRecyclerAdapter);
    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }
}