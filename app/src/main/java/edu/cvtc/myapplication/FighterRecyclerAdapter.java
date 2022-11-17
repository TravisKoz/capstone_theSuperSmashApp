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
            case ("EarthBound"):
                holder.mFighterFranchise.setImageResource(R.drawable.earth_bound_series);
                break;
            case ("F-Zero"):
                holder.mFighterFranchise.setImageResource(R.drawable.f_zero_series);
                break;
            case ("Ice Climbers"):
                holder.mFighterFranchise.setImageResource(R.drawable.ice_climbers_series);
                break;
            case ("Fire Emblem"):
                holder.mFighterFranchise.setImageResource(R.drawable.fire_emblem_series);
                break;
            case ("Game & Watch"):
                holder.mFighterFranchise.setImageResource(R.drawable.game_watch_series);
                break;
            case ("Kid Icarus"):
                holder.mFighterFranchise.setImageResource(R.drawable.kid_icarus_series);
                break;
            case ("Wario"):
                holder.mFighterFranchise.setImageResource(R.drawable.wario_series);
                break;
            case ("Metal Gear"):
                holder.mFighterFranchise.setImageResource(R.drawable.metal_gear_series);
                break;
            case ("Sonic"):
                holder.mFighterFranchise.setImageResource(R.drawable.sonic_series);
                break;
            case ("Pikmin"):
                holder.mFighterFranchise.setImageResource(R.drawable.pikmin_series);
                break;
            case ("R.O.B."):
                holder.mFighterFranchise.setImageResource(R.drawable.rob_series);
                break;
            case ("Animal Crossing"):
                holder.mFighterFranchise.setImageResource(R.drawable.animal_crossing_series);
                break;
            case ("Mega Man"):
                holder.mFighterFranchise.setImageResource(R.drawable.mega_man_series);
                break;
            case ("Wii Fit"):
                holder.mFighterFranchise.setImageResource(R.drawable.wii_fit_series);
                break;
            case ("Punch-Out!!"):
                holder.mFighterFranchise.setImageResource(R.drawable.punchout_series);
                break;
            case ("PAC-MAN"):
                holder.mFighterFranchise.setImageResource(R.drawable.pac_man_series);
                break;
            case ("Xenoblade Chronicles"):
                holder.mFighterFranchise.setImageResource(R.drawable.xenoblade_chronicles_series);
                break;
            case ("Duck Hunt"):
                holder.mFighterFranchise.setImageResource(R.drawable.duck_hunt_series);
                break;
            case ("Street Fighter"):
                holder.mFighterFranchise.setImageResource(R.drawable.street_fighter_series);
                break;
            case ("Final Fantasy"):
                holder.mFighterFranchise.setImageResource(R.drawable.final_fantasy_series);
                break;
            case ("Bayonetta"):
                holder.mFighterFranchise.setImageResource(R.drawable.bayonetta_series);
                break;
            case ("Splatoon"):
                holder.mFighterFranchise.setImageResource(R.drawable.splatoon_series);
                break;
            case ("Castlevania"):
                holder.mFighterFranchise.setImageResource(R.drawable.castlevania_series);
                break;
            case ("Persona"):
                holder.mFighterFranchise.setImageResource(R.drawable.persona_series);
                break;
            case ("Fatal Fury"):
                holder.mFighterFranchise.setImageResource(R.drawable.fatal_fury_series);
                break;
            case ("Dragon Quest"):
                holder.mFighterFranchise.setImageResource(R.drawable.dragon_quest_series);
                break;
            case ("Banjo-Kazooie"):
                holder.mFighterFranchise.setImageResource(R.drawable.banjo_kazooie_series);
                break;
            case ("ARMS"):
                holder.mFighterFranchise.setImageResource(R.drawable.arms_series);
                break;
            case ("Minecraft"):
                holder.mFighterFranchise.setImageResource(R.drawable.minecraft_series);
                break;
            case ("Tekken"):
                holder.mFighterFranchise.setImageResource(R.drawable.tekken_series);
                break;
            case ("Kingdom Hearts"):
                holder.mFighterFranchise.setImageResource(R.drawable.kingdom_hearts_series);
                break;
            default:
                holder.mFighterFranchise.setImageResource(R.drawable.super_smash);
        }

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
