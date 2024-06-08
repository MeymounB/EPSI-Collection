package com.mspr.arosaje.client;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mspr.arosaje.R;
import com.mspr.arosaje.common.get_messages;
import com.mspr.arosaje.common.sendMessage;
import com.mspr.arosaje.database.VolleySingleton;

import org.json.JSONException;

import java.util.ArrayList;

public class ClientProfil extends AppCompatActivity {

    Button write_message, getmessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_profil);

        write_message = findViewById(R.id.btn_ecrire_message);
        getmessages = findViewById(R.id.btn_messagerie);

        // Lookup the recyclerview in activity layout
        RecyclerView rvPlants = (RecyclerView) findViewById(R.id.vertical_recycle_view);

        try {
            VolleySingleton
                    .getInstance(ClientProfil.this)
                    .getData("/api/plant/me", response -> {
                        try {
                            // Initialize infoplants
                            ArrayList<info_plant> infoplants = info_plant.createList(response);
                            // Create adapter passing in the sample plant data
                            PlantAdapter adapter = new PlantAdapter(infoplants);
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

        // ***************** Changement de page au clic *****************

        write_message.setOnClickListener(v2 -> openActivityWriteMessages());

        getmessages.setOnClickListener(v2 -> openActivityGetMessages());
    }

    public void openActivityWriteMessages() {
        Intent writeMessage = new Intent(this, sendMessage.class);
        startActivity(writeMessage);
        finish();
    }

    public void openActivityGetMessages() {
        Intent getMessages = new Intent(this, get_messages.class);
        startActivity(getMessages);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this, ClientAccueil.class);
        startActivity(intentBack);
    }

    // ********** App bar **********

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu_sans_deco, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.deco) {
            Intent accueil = new Intent(this, ClientConnexion.class);
            startActivity(accueil);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
