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

public class GardiennageAdapter3 extends
        RecyclerView.Adapter<GardiennageAdapter3.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, date_gard, username;
        private final Context context;
        ImageView img_view;

        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            title = (TextView) itemView.findViewById(R.id.titre_gardiennage);
            date_gard = (TextView) itemView.findViewById(R.id.date_gardiennage);
            username = (TextView) itemView.findViewById(R.id.username_gardiennage);
            img_view = (ImageView) itemView.findViewById(R.id.image_list_profil);
            itemView.setOnClickListener(this::onClick);
        }

        public void onClick(View view) {
            int position = getAbsoluteAdapterPosition(); // gets item position
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                info_gardiennage infogardiennage = mInfogardiennages.get(position);
                final Intent intent;
                intent = new Intent(context, ClientChoixArticleGardiennageEnAttente.class);
                intent.putExtra("nom", infogardiennage.getName());
                intent.putExtra("espece", infogardiennage.getEspece());
                intent.putExtra("description", infogardiennage.getDescription());
                intent.putExtra("date", infogardiennage.getDate());
                intent.putExtra("id", infogardiennage.getId());
                try {
                    intent.putExtra("date_gardiennage", infogardiennage.getDateGard());
                    intent.putExtra("url_photo", infogardiennage.getUrlPhoto());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                context.startActivity(intent);
            }
        }
    }

    private ArrayList<info_gardiennage> mInfogardiennages;

    // Pass in the gardiennage array into the constructor
    public GardiennageAdapter3(ArrayList<info_gardiennage> infogardiennages) {
        mInfogardiennages = infogardiennages;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public GardiennageAdapter3.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View gardiennageView = inflater.inflate(R.layout.list_card_gardiennage, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(gardiennageView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GardiennageAdapter3.ViewHolder holder, int position) {
        // Get the data model based on position
        info_gardiennage infogardiennage = mInfogardiennages.get(position);

        // Set item views based on your views and data model
        try {
            TextView title = holder.title;
            title.setText(infogardiennage.getTitleGard());

            TextView username = holder.username;
            username.setText(infogardiennage.getNameGard());

            TextView date_gard = holder.date_gard;
            date_gard.setText(infogardiennage.getDateGard());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        try {
            if (infogardiennage.getUrlPhoto() != null)
                Glide.with(holder.context).load(infogardiennage.getUrlPhoto()).into(holder.img_view);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mInfogardiennages.size();
    }
}
