package edu.cvtc.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FighterRecyclerAdapter extends
        RecyclerView.Adapter<FighterRecyclerAdapter.ViewHolder> {

    // Member variables
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private List<Fighter> mFighters;

    // Constructor
    public FighterRecyclerAdapter(Context context, List<Fighter> fighters) {
        mContext = context;
        mFighters = fighters;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.fighter_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Fighter fighter = mFighters.get(position);
        holder.mFighterName.setText(fighter.getName());

        String symbolResource = fighter.getFranchise().replace(" ", "_").replace("!","")
                .replace("&", "and").replace("-", "_").replace(".", "").toLowerCase();

        // Formatted string to match the head image naming format.
        String seriesResource = symbolResource + "_series";

        // Get the resourceID for our fighter's series.
        int seriesResourceID = mContext.getResources().getIdentifier(seriesResource, "drawable", mContext.getPackageName());

        // Changes the displayed fighter's image and fighter's series image based on our resourceIDs.
        holder.mFighterFranchise.setImageResource(seriesResourceID);
        holder.mId = fighter.getId();

    }

    @Override
    public int getItemCount() {
        return mFighters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Member variables for inner class
        public final TextView mFighterName;
        public final ImageView mFighterFranchise;
        public int mId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mFighterName = (TextView) itemView.findViewById(R.id.fighter_name);
            mFighterFranchise = (ImageView) itemView.findViewById(R.id.game_symbol_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, FighterDetailsActivity.class);
                    intent.putExtra(FighterDetailsActivity.FIGHTER_ID, mId);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
