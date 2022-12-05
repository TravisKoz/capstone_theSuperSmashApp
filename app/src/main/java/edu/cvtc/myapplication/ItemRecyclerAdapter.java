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

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ViewHolder> {

    // Member Variables
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private List<ItemSSB> mItem;

    // Loaded Constructor
    public ItemRecyclerAdapter(Context context, List<ItemSSB> itemSSBS) {
        mContext = context;
        mItem = itemSSBS;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.items_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ItemSSB itemSSB = mItem.get(position);
        holder.mItemName.setText(itemSSB.getName());

        String imageNameSRC = itemSSB.getName().replace(" ", "_").replace("!","")
                .replace("&", "and").replace("-", "_").replace("'", "")
                .replace(".", "").toLowerCase();

        String imageCategorySRC = itemSSB.getCategory().replace(" ", "_").replace("!","")
                .replace("&", "and").replace("-", "_").replace("'", "")
                .replace(".", "").toLowerCase();

        String imageNameFormat = "item_" + imageCategorySRC + "_" + imageNameSRC;

        int imageResourceID =
                mContext.getResources().getIdentifier(imageNameFormat, "drawable", mContext.getPackageName());

        holder.mItemImage.setImageResource(imageResourceID);

        holder.mId = itemSSB.getId();
    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Member variables for inner class
        public final TextView mItemName;
        public final ImageView mItemImage;
        public int mId;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemName = (TextView) itemView.findViewById(R.id.item_name);
            mItemImage = (ImageView) itemView.findViewById(R.id.item_symbol_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, ItemDetailsActivity.class);
                    intent.putExtra(ItemDetailsActivity.ITEM_ID, mId);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
