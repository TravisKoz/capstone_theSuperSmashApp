package edu.cvtc.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import edu.cvtc.myapplication.databinding.ActivityTrophiesBinding;

public class TrophiesActivity extends AppCompatActivity {

    private ActivityTrophiesBinding binding;

    // Member Variables
    private SuperSmashOpenHelper mDbOpenHelper;
    private RecyclerView mRecyclerItems;
    private LinearLayoutManager mTrophiesLayoutManager;
    private AssistTrophyRecyclerAdapter mAssistTrophyRecyclerAdapter;
    public static int index = -1;
    public static int top = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTrophiesBinding.inflate(getLayoutInflater());
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
        DataManager.getTrophiesFromDatabase(mDbOpenHelper);

        // Set a reference to our list of fighters layout
        mRecyclerItems = (RecyclerView) findViewById(R.id.list_trophies);
        mTrophiesLayoutManager = new LinearLayoutManager(this);
        mRecyclerItems.setHasFixedSize(true);

        // Get our assist trophies
        List<AssistTrophy> trophies = DataManager.getInstance().getTrophies();

        // Fill the RecycleAdapter with our fighters
        mAssistTrophyRecyclerAdapter = new AssistTrophyRecyclerAdapter(this, trophies);

        // Display the Fighters
        displayTrophies();
    }

    private void displayTrophies() {
        mRecyclerItems.setLayoutManager(mTrophiesLayoutManager);
        mRecyclerItems.setAdapter(mAssistTrophyRecyclerAdapter);
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
            mTrophiesLayoutManager.scrollToPositionWithOffset(index, top);
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();
        //read current recyclerview position
        index = mTrophiesLayoutManager.findFirstVisibleItemPosition();
        View v = mRecyclerItems.getChildAt(0);
        top = (v == null) ? 0 : (v.getTop() - mRecyclerItems.getPaddingTop());
    }
}