package edu.cvtc.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PokemonRecyclerAdapter extends RecyclerView.Adapter<PokemonRecyclerAdapter.ViewHolder> {

    // Member Variables
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private final List<Pokemon> mPokemon;

    // Constructor
    public PokemonRecyclerAdapter(Context context, List<Pokemon> pokemon) {
        mContext = context;
        mPokemon = pokemon;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.pokemon_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Pokemon pokemon = mPokemon.get(position);
        holder.mPokemonName.setText(pokemon.getName());

        String imageResource = "pokemon_" + pokemon.getName().replace(" ", "_").replace(".","")
                .replace("&", "and").replace("-", "_").replace("'", "_").toLowerCase();

        // Gets the resourceID for our selected pokemon's image.
        int imageResourceID = mContext.getResources().getIdentifier(imageResource, "drawable", mContext.getPackageName());

        // Changes the displayed pokemon's image on our resourceIDs.
        holder.mPokemonImage.setImageResource(imageResourceID);

        holder.mId = pokemon.getId();
    }

    @Override
    public int getItemCount() {
        return mPokemon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Member variables for inner class
        public final TextView mPokemonName;
        public final ImageView mPokemonImage;
        public int mId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mPokemonName = (TextView) itemView.findViewById(R.id.pokemon_name);
            mPokemonImage = (ImageView) itemView.findViewById(R.id.pokemon_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, PokemonDetailsActivity.class);
                    intent.putExtra(PokemonDetailsActivity.POKEMON_ID, mId);
                    mContext.startActivity(intent);
                }
            });

        }
    }
}
