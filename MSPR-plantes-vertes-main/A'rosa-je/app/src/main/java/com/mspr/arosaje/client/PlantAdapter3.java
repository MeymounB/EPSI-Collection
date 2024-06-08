package com.mspr.arosaje.client;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mspr.arosaje.R;
import com.mspr.arosaje.botanist.BotanisteChoixArticle;

import org.json.JSONException;

import java.util.ArrayList;

public class PlantAdapter3 extends
        RecyclerView.Adapter<PlantAdapter3.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView desc;
        private final Context context;
        ImageView img_view;

        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            title = (TextView) itemView.findViewById(R.id.textView2);
            desc = (TextView) itemView.findViewById(R.id.textView3);
            img_view = (ImageView) itemView.findViewById(R.id.image_list_profil);
            itemView.setOnClickListener(this::onClick);
        }

        public void onClick(View view) {
            int position = getAbsoluteAdapterPosition(); // gets item position
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                info_plant infoplant = mInfoplants.get(position);
                final Intent intent;
                intent = new Intent(context, BotanisteChoixArticle.class);
                intent.putExtra("nom", infoplant.getName());
                intent.putExtra("espece", infoplant.getEspece());
                intent.putExtra("description", infoplant.getDescription());
                intent.putExtra("date", infoplant.getDate());
                intent.putExtra("id", infoplant.getId());
                try {
                    intent.putExtra("url_photo", infoplant.getUrlPhoto());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                context.startActivity(intent);
            }
        }
    }

    private ArrayList<info_plant> mInfoplants;

    // Pass in the plant array into the constructor
    public PlantAdapter3(ArrayList<info_plant> infoplants) {
        mInfoplants = infoplants;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public PlantAdapter3.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View plantView = inflater.inflate(R.layout.list_card_plant, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(plantView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlantAdapter3.ViewHolder holder, int position) {
        // Get the data model based on position
        info_plant infoplant = mInfoplants.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.title;
        textView.setText(infoplant.getName());
        TextView desc = holder.desc;
        desc.setText(infoplant.getDescription());

        try {
            if (infoplant.getUrlPhoto() != null)
                Glide.with(holder.context).load(infoplant.getUrlPhoto()).into(holder.img_view);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mInfoplants.size();
    }
}
