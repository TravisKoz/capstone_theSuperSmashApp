package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.ItemEntry;
public class ItemDetailsActivity extends AppCompatActivity {

    // Constants
    public static final String ITEM_ID = "edu.cvtc.myapplication.ITEM_ID";
    public static final int ID_NO_SET = -1;

    // Member Variables
    private int mItemId;
    private int mItemNamePosition;
    private int mItemCategoryPosition;
    private int mItemDescriptionPosition;

    // Member objects
    private TextView mItemName;
    private TextView mItemCategory;
    private TextView mItemDescription;
    private ImageView mItemImage;

    private SuperSmashOpenHelper mDBOpenHelper;
    private Cursor mItemCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        mDBOpenHelper = new SuperSmashOpenHelper(this);

        Intent intent = getIntent();
        mItemId = intent.getIntExtra(ITEM_ID, ID_NO_SET);

        // Layout References
        mItemName = findViewById(R.id.details_item_name);
        mItemCategory = findViewById(R.id.details_item_category);
        mItemDescription = findViewById(R.id.details_item_description);
        mItemImage = findViewById(R.id.details_item_image);
        loadItemData();
    }

    private void loadItemData() {
        // Open a connection to the database
        SQLiteDatabase db = mDBOpenHelper.getReadableDatabase();

        String selection = SuperSmashDatabaseContract.ItemEntry._ID + " = ?";
        String[] selectionArgs = {Integer.toString(mItemId)};

        // Create a list of the columns we are pulling from
        // the database.
        String[] itemColumns = {
                ItemEntry.COLUMN_NAME,
                ItemEntry.COLUMN_CATEGORY,
                ItemEntry.COLUMN_DESCRIPTION
        };

        // Fill our cursor with the information we have provided
        mItemCursor = db.query(ItemEntry.TABLE_NAME, itemColumns,
                        selection, selectionArgs, null, null, null);

        // Get the positions of the fields in the cursor so that
        // we are able to retrieve them into our layout.
        mItemNamePosition = mItemCursor.getColumnIndex(ItemEntry.COLUMN_NAME);
        mItemCategoryPosition = mItemCursor.getColumnIndex(ItemEntry.COLUMN_CATEGORY);
        mItemDescriptionPosition = mItemCursor.getColumnIndex(ItemEntry.COLUMN_DESCRIPTION);

        mItemCursor.moveToNext();

        // Call the method to display the item
        displayItem();
    }

    private void displayItem() {
        // Retrieve the values from the cursor based upon
        // the position of the columns.
        String itemName = mItemCursor.getString(mItemNamePosition);
        String itemCategory = mItemCursor.getString(mItemCategoryPosition);
        String itemDescription = mItemCursor.getString(mItemDescriptionPosition);

        // Use information to populate layout TextViews
        mItemName.setText(itemName);
        mItemCategory.setText(itemCategory);
        mItemDescription.setText(itemDescription);

        String imageNameSRC = itemName.replace(" ", "_").replace("!","")
                        .replace("&", "and").replace("-", "_").replace("'", "")
                        .replace(".", "").toLowerCase();

        String imageCategorySRC = itemCategory.replace(" ", "_").replace("!","")
                        .replace("&", "and").replace("-", "_").replace("'", "")
                        .replace(".", "").toLowerCase();

        String imageNameFormat = "item_" + imageCategorySRC + "_" + imageNameSRC;

        int imageResourceID =
                this.getResources().getIdentifier(imageNameFormat, "drawable", this.getPackageName());

        mItemImage.setImageResource(imageResourceID);
    }

    @Override
    protected void onDestroy() {
        mDBOpenHelper.close();
        super.onDestroy();
    }
}