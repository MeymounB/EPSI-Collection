package com.mspr.arosaje.client;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mspr.arosaje.R;
import com.mspr.arosaje.database.VolleySingleton;

import org.json.JSONException;

import java.util.ArrayList;

public class Client_list_rdv extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_list_rdv);

//        b1 = (Button) findViewById(R.id.btn_register);

        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");
        String espece = intent.getStringExtra("espece");
        String description = intent.getStringExtra("description");
        String date = intent.getStringExtra("date");
        String url_photo = intent.getStringExtra("url_photo");
        String id = intent.getStringExtra("id");

        // Lookup the recyclerview in activity layout
        RecyclerView rvPlants = (RecyclerView) findViewById(R.id.vertical_recycle_view_list_rdv_attente);
        RecyclerView rvPlants2 = (RecyclerView) findViewById(R.id.vertical_recycle_view_list_rdv_accepte);
        RecyclerView rvPlants3 = (RecyclerView) findViewById(R.id.vertical_recycle_view_list_rdv_a_garder);


        // Demandes en attentes
        try {
            VolleySingleton
                    .getInstance(Client_list_rdv.this)
                    .getData("/api/plant/pendingGard", response -> {
                        try {
                            // Initialize infoplants
                            ArrayList<info_gardiennage> infogardiennages = info_gardiennage.createList(response);
                            // Create adapter passing in the sample plant data
                            GardiennageAdapter adapter = new GardiennageAdapter(infogardiennages);
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

        // Gardiennages planifiés
        try {
            VolleySingleton
                    .getInstance(Client_list_rdv.this)
                    .getData("/api/plant/inProgressGard", response -> {
                        try {
                            // Initialize infoplants
                            ArrayList<info_gardiennage> infogardiennages = info_gardiennage.createList(response);
                            // Create adapter passing in the sample plant data
                            GardiennageAdapter2 adapter = new GardiennageAdapter2(infogardiennages);
                            // Attach the adapter to the recyclerview to populate items
                            rvPlants2.setAdapter(adapter);
                            // Set layout manager to position the items
                            rvPlants2.setLayoutManager(new LinearLayoutManager(this));
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Plante à faire garder
        try {
            VolleySingleton
                    .getInstance(Client_list_rdv.this)
                    .getData("/api/plant/myGards", response -> {
                        try {
                            // Initialize infoplants
                            ArrayList<info_gardiennage> infogardiennages = info_gardiennage.createList(response);
                            // Create adapter passing in the sample plant data
                            GardiennageAdapter3 adapter = new GardiennageAdapter3(infogardiennages);
                            // Attach the adapter to the recyclerview to populate items
                            rvPlants3.setAdapter(adapter);
                            // Set layout manager to position the items
                            rvPlants3.setLayoutManager(new LinearLayoutManager(this));
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

        if (id == R.id.empty) {
            Intent accueil = new Intent(this, ClientConnexion.class);
            startActivity(accueil);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
