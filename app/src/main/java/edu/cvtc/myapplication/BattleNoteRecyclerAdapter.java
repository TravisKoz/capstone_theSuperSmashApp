package edu.cvtc.myapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BattleNoteRecyclerAdapter extends
        RecyclerView.Adapter<BattleNoteRecyclerAdapter.ViewHolder> {

    // Member variables
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private List<BattleNote> mBattleNotes;

    // Constructor
    public BattleNoteRecyclerAdapter(Context context, List<BattleNote> battlesNotes) {
        mContext = context;
        mBattleNotes = battlesNotes;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.note_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BattleNoteRecyclerAdapter.ViewHolder holder,
                                 @SuppressLint("RecyclerView") int position) {
        BattleNote battlenote = mBattleNotes.get(position);
        holder.mBattleNoteHeading.setText(battlenote.getHeading());
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mBattleNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Member variables for inner class
        public final TextView mBattleNoteHeading;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mBattleNoteHeading = (TextView) itemView.findViewById(R.id.battle_note_heading);
        }
    }
}
