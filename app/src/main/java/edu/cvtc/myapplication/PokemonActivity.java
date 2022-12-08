package edu.cvtc.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import edu.cvtc.myapplication.databinding.ActivityPokemonBinding;


public class PokemonActivity extends AppCompatActivity {

    private ActivityPokemonBinding binding;

    private SuperSmashOpenHelper mDbOpenHelper;
    private RecyclerView mRecyclerItems;
    private LinearLayoutManager mPokemonLayout;
    private PokemonRecyclerAdapter mPokemonRecyclerAdapter;
    public static int index = -1;
    public static int top = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPokemonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.pokemonToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        // Retrieve the information from our database
        DataManager.getPokemonFromDatabase(mDbOpenHelper);

        // Set a reference to our list of fighters layout
        mRecyclerItems = (RecyclerView) findViewById(R.id.list_pokemon);
        mPokemonLayout = new LinearLayoutManager(this);
        mRecyclerItems.setHasFixedSize(true);

        // Get our pokemon
        List<Pokemon> pokemon = DataManager.getInstance().getPokemon();

        // Fill the RecycleAdapter with our pokemon
        mPokemonRecyclerAdapter = new PokemonRecyclerAdapter(this, pokemon);

        // Display the Fighters
        displayTrophies();
    }

    private void displayTrophies() {
        mRecyclerItems.setLayoutManager(mPokemonLayout);
        mRecyclerItems.setAdapter(mPokemonRecyclerAdapter);
    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        index = mPokemonLayout.findFirstVisibleItemPosition();
        View v = mRecyclerItems.getChildAt(0);
        top = (v == null) ? 0 : (v.getTop() - mRecyclerItems.getPaddingTop());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (index != -1) {
            mPokemonLayout.scrollToPositionWithOffset(index, top);
        }
    }
}