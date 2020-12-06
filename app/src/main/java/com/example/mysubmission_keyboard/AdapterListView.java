package com.example.mysubmission_keyboard;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.request.RequestOptions;

import java.net.InterfaceAddress;
import java.util.ArrayList;

public class AdapterListView extends RecyclerView.Adapter<AdapterListView.HolderListView> {

    private ArrayList<ItemData> itemDataArrayList;

    public AdapterListView (ArrayList<ItemData> list){
        this.itemDataArrayList = list;
    }
    @NonNull
    @Override
    public HolderListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_view, parent, false);
        return new HolderListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderListView holder, int position) {
        final ItemData itemData = itemDataArrayList.get(position);

        Glide.with(holder.itemView.getContext()).load(itemData.getItemPhoto()).apply(new RequestOptions().override(80, 80)).into(holder.itemPhoto);
        holder.itemTitle.setText(itemData.getItemName());
        holder.itemDesc.setText(itemData.getItemDesc());
        holder.itemPrice.setText(itemData.getItemPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ItemDetails.class);
                intent.putExtra(ItemDetails.imageUrl, itemDataArrayList.get(holder.getAdapterPosition()).getItemPhoto());
                intent.putExtra(ItemDetails.title, itemDataArrayList.get(holder.getAdapterPosition()).getItemName());
                intent.putExtra(ItemDetails.description, itemDataArrayList.get(holder.getAdapterPosition()).getItemDesc());
                intent.putExtra(ItemDetails.price, itemDataArrayList.get(holder.getAdapterPosition()).getItemPrice());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemDataArrayList.size();
    }

    public class HolderListView extends RecyclerView.ViewHolder {

        ImageView itemPhoto;
        TextView itemTitle, itemDesc, itemPrice;

        public HolderListView(@NonNull View itemView) {
            super(itemView);

            itemPhoto = itemView.findViewById(R.id.item_photo);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDesc = itemView.findViewById(R.id.item_description);
            itemPrice = itemView.findViewById(R.id.item_price);
        }
    }

}
