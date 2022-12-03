package edu.cvtc.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import edu.cvtc.myapplication.databinding.ActivityItemsBinding;

public class ItemsActivity extends AppCompatActivity {

    public ActivityItemsBinding binding;

    // Items Member variables
    private SuperSmashOpenHelper mDbOpenHelper;
    private RecyclerView mRecyclerItemsView;
    private LinearLayoutManager mItemsLayoutManager;
    private ItemRecyclerAdapter mItemRecyclerAdapter;
    public static int index = -1;
    public static int top = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_items);

        binding = ActivityItemsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.itemsToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDbOpenHelper = new SuperSmashOpenHelper(this);

        initializeContent();

    }

    private void initializeContent() {
        DataManager.getItemsFromDatabase(mDbOpenHelper);

        // Set a reference to our list of items layout
        mRecyclerItemsView = (RecyclerView) findViewById(R.id.list_items_recyclerview);
        mItemsLayoutManager = new LinearLayoutManager(this);
        mRecyclerItemsView.setHasFixedSize(true);

        // Get the items
        List<ItemSSB> items = DataManager.getInstance().getItems();

        mItemRecyclerAdapter = new ItemRecyclerAdapter(this, items);

        //call the displayItems function
        displayItems();
    }

    private void displayItems() {
        mRecyclerItemsView.setLayoutManager(mItemsLayoutManager);
        mRecyclerItemsView.setAdapter(mItemRecyclerAdapter);
    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        index = mItemsLayoutManager.findFirstVisibleItemPosition();
        View view = mRecyclerItemsView.getChildAt(0);
        top = (view == null) ? 0 : (view.getTop() - mRecyclerItemsView.getPaddingTop());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (index != -1) {
            mItemsLayoutManager.scrollToPositionWithOffset(index, top);
        }
    }
}