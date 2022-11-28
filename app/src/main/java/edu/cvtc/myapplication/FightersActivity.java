package edu.cvtc.myapplication;

import android.os.Bundle;
import android.view.View;

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
    public static int index = -1;
    public static int top = -1;

    private int lastFirstVisiblePosition;

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
        mRecyclerItems.setHasFixedSize(true);

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
    @Override
    public void onResume() {
        super.onResume();
        //set recyclerview position
        if (index != -1) {
            mFightersLayoutManager.scrollToPositionWithOffset(index, top);
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();
        //read current recyclerview position
        index = mFightersLayoutManager.findFirstVisibleItemPosition();
        View v = mRecyclerItems.getChildAt(0);
        top = (v == null) ? 0 : (v.getTop() - mRecyclerItems.getPaddingTop());
    }

}