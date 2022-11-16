package edu.cvtc.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
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

        switch (fighter.getFranchise()) {

            case ("Super Mario"):
                holder.mFighterFranchise.setImageResource(R.drawable.mario_series);
                break;
            case ("Donkey Kong"):
                holder.mFighterFranchise.setImageResource(R.drawable.donkey_kong_series);
                break;
            case ("The Legend of Zelda"):
                holder.mFighterFranchise.setImageResource(R.drawable.zelda_series);
                break;
            case ("Metroid"):
                holder.mFighterFranchise.setImageResource(R.drawable.metroid_series);
                break;
            case ("Yoshi"):
                holder.mFighterFranchise.setImageResource(R.drawable.yoshi_series);
                break;
            case ("Kirby"):
                holder.mFighterFranchise.setImageResource(R.drawable.kirby_series);
                break;
            case ("Star Fox"):
                holder.mFighterFranchise.setImageResource(R.drawable.star_fox_series);
                break;
            case ("Pokemon"):
                holder.mFighterFranchise.setImageResource(R.drawable.pokemon_series);
                break;
            default:
                holder.mFighterFranchise.setImageResource(R.drawable.super_smash);
        }

        holder.mCurrentPosition = position;

    }

    @Override
    public int getItemCount() {
        return mFighters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Member variables for inner class
        public final TextView mFighterName;
        public final ImageView mFighterFranchise;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mFighterName = (TextView) itemView.findViewById(R.id.fighter_name);
            mFighterFranchise = (ImageView) itemView.findViewById(R.id.game_symbol_image);
        }
    }
}
