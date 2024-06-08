package com.mspr.arosaje.common;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mspr.arosaje.R;
import com.mspr.arosaje.client.ClientProfil;
import com.mspr.arosaje.client.PlantAdapter;
import com.mspr.arosaje.common.info_messages;
import com.mspr.arosaje.database.VolleySingleton;

import org.json.JSONException;

import java.util.ArrayList;

public class get_messages extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_messages);
        // Lookup the recyclerview in activity layout
        RecyclerView rvPlants = (RecyclerView) findViewById(R.id.vertical_recycle_view_get_messages);

        try {
            VolleySingleton
                    .getInstance(get_messages.this)
                    .getData("/api/message/user", response -> {
                        try {
                            // Initialize infomessages
                            ArrayList<info_messages> infomessages = info_messages.createList(response);
                            // Create adapter passing in the sample plant data
                            messageAdaptor adapter = new messageAdaptor(infomessages);
                            // Attach the adapter to the recyclerview to populate items
                            rvPlants.setAdapter(adapter);
                            // Set layout manager to position the items
                            rvPlants.setLayoutManager(new LinearLayoutManager(this));
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this, ClientProfil.class);
        startActivity(intentBack);
    }
}
