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

public class PlantAdapter4 extends
        RecyclerView.Adapter<PlantAdapter4.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nom, desc, date;
        private final Context context;
        ImageView img_view;

        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            nom = (TextView) itemView.findViewById(R.id.nom_list_commentaire);
            desc = (TextView) itemView.findViewById(R.id.description_list_commentaire);
            date = (TextView) itemView.findViewById(R.id.date_list_commentaire);
        }
    }

    private ArrayList<info_commentaire> mInfocommentaires;

    // Pass in the commentaire array into the constructor
    public PlantAdapter4(ArrayList<info_commentaire> info_commentaire) {
        mInfocommentaires = info_commentaire;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public PlantAdapter4.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View commentaireView = inflater.inflate(R.layout.list_commentaire, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(commentaireView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlantAdapter4.ViewHolder holder, int position) {
        // Get the data model based on position
        info_commentaire infocommentaire = mInfocommentaires.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.nom;
        try {
            textView.setText(infocommentaire.getUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        TextView desc = holder.desc;
        desc.setText(infocommentaire.getText());
        TextView date = holder.date;
        date.setText(infocommentaire.getDate());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mInfocommentaires.size();
    }
}
