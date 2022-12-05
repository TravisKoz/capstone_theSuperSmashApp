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

public class AssistTrophyRecyclerAdapter extends RecyclerView.Adapter<AssistTrophyRecyclerAdapter.ViewHolder> {

    // Member Variables
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private final List<AssistTrophy> mTrophies;

    // Constructor
    public AssistTrophyRecyclerAdapter(Context context, List<AssistTrophy> trophies) {
        mContext = context;
        mTrophies = trophies;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.trophy_list, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        AssistTrophy trophy = mTrophies.get(position);
        holder.mTrophyName.setText(trophy.getName());

        // Formatted the passed in trophy's name String to match our image names convention.
        // Symbols are replaced with corresponding characters and all letters and converted to lower case.
        String imageResource = "trophy_" + trophy.getName().replace(" ", "_").replace(".","")
                .replace("&", "and").replace("-", "_").replace("'", "_").toLowerCase();

        // Gets the resourceID for our selected trophy's image.
        int imageResourceID = mContext.getResources().getIdentifier(imageResource, "drawable", mContext.getPackageName());

        // Changes the displayed fighter's image and fighter's series image based on our resourceIDs.
        holder.mTrophyImage.setImageResource(imageResourceID);

        holder.mId = trophy.getId();

    }

    @Override
    public int getItemCount() {
        return mTrophies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Member variables for inner class
        public final TextView mTrophyName;
        public final ImageView mTrophyImage;
        public int mId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTrophyName = (TextView) itemView.findViewById(R.id.assist_trophy_name);
            mTrophyImage = (ImageView) itemView.findViewById(R.id.assist_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, TrophyDetailsActivity.class);
                    intent.putExtra(TrophyDetailsActivity.TROPHY_ID, mId);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
