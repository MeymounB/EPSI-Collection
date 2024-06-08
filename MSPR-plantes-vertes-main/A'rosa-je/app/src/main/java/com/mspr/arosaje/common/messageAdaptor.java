package com.mspr.arosaje.common;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mspr.arosaje.R;

import org.json.JSONException;

import java.util.ArrayList;

public class messageAdaptor extends
        RecyclerView.Adapter<messageAdaptor.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView desc;
        public TextView date;
        private final Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            title = (TextView) itemView.findViewById(R.id.nom_get_messages);
            desc = (TextView) itemView.findViewById(R.id.titre_get_messages);
            date = (TextView) itemView.findViewById(R.id.date_get_messages);
            itemView.setOnClickListener(this::onClick);
        }

        public void onClick(View view) {
            int position = getAbsoluteAdapterPosition(); // gets item position
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                info_messages info_messages = mInfoMessage.get(position);
                final Intent intent;
                intent = new Intent(context, choixMessage.class);
                intent.putExtra("id", info_messages.getId());
                intent.putExtra("title", info_messages.getTitles());
                intent.putExtra("date", info_messages.getDate());
                intent.putExtra("expeditor", info_messages.getExpeditor());
                intent.putExtra("description", info_messages.getDescription());
                context.startActivity(intent);
            }
        }
    }

    private final ArrayList<info_messages> mInfoMessage;

    // Pass in the plant array into the constructor
    public messageAdaptor(ArrayList<info_messages> infomessages) {
        mInfoMessage = infomessages;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public messageAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View messageView = inflater.inflate(R.layout.list_messages, parent, false);

        // Return a new holder instance
        return new ViewHolder(messageView);
    }

    @Override
    public void onBindViewHolder(messageAdaptor.ViewHolder holder, int position) {
        // Get the data model based on position
        info_messages infomessages = mInfoMessage.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.title;
        textView.setText(infomessages.getExpeditor());
        TextView desc = holder.desc;
        desc.setText(infomessages.getTitles());
        TextView date = holder.date;
        date.setText(infomessages.getDate());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mInfoMessage.size();
    }
}
