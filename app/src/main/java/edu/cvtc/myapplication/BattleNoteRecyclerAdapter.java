package edu.cvtc.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.BattleNoteEntry;

public class BattleNoteRecyclerAdapter extends
        RecyclerView.Adapter<BattleNoteRecyclerAdapter.ViewHolder> {

    // Member variables
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private Cursor mCursor;
    private int mBattleNoteHeadingPosition;
    private int mBattleNoteBodyPosition;
    private int mIdPosition;

    // Constructor
    public BattleNoteRecyclerAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
        mLayoutInflater = LayoutInflater.from(context);

        // Used to get the positions of the columns we
        // are interested in
        populateColumnPositions();
    }

    private void populateColumnPositions() {
        if (mCursor != null) {
            // Get column indexes from mCursor
            mBattleNoteHeadingPosition =
                    mCursor.getColumnIndex(BattleNoteEntry.COLUMN_HEADING);
            mBattleNoteBodyPosition =
                    mCursor.getColumnIndex(BattleNoteEntry.COLUMN_BODY);
            mIdPosition = mCursor.getColumnIndex(BattleNoteEntry._ID);
        }
    }

    public void changeCursor(Cursor cursor) {
        // If the cursor is open, close it
        if (mCursor != null) {
            mCursor.close();
        }

        // Create a new cursor based upon
        // the object passed in.
        mCursor = cursor;

        // Get the positions of the columns in our
        // cursor
        populateColumnPositions();

        // Tell the activity that that data set
        // has changed.
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.note_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Move the cursor to the correct row
        mCursor.moveToPosition(position);

        // Get the actual values
        String battleNoteHeading =
                mCursor.getString(mBattleNoteHeadingPosition);
        String battleNoteBody =
                mCursor.getString(mBattleNoteBodyPosition);
        int id = mCursor.getInt(mIdPosition);

        // Pass the information into the holder.
        holder.mBattleNoteHeading.setText(battleNoteHeading);
        holder.mId = id;
    }

    @Override
    public int getItemCount() {
        // If the cursor is null, return 0. Otherwise
        // return the count of records in it.
        return mCursor == null ? 0 : mCursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Member variables for inner class
        public final TextView mBattleNoteHeading;
        public int mId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mBattleNoteHeading = (TextView) itemView.findViewById(R.id.battle_note_heading);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, BattleNoteActivity.class);
                    intent.putExtra(BattleNoteActivity.NOTE_ID, mId);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
