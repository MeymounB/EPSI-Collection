package com.mspr.arosaje.botanist;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mspr.arosaje.client.ClientAccueil;
import com.mspr.arosaje.client.ClientConnexion;
import com.mspr.arosaje.R;
import com.mspr.arosaje.client.PlantAdapter2;
import com.mspr.arosaje.client.PlantAdapter3;
import com.mspr.arosaje.client.info_plant;
import com.mspr.arosaje.database.VolleySingleton;

import org.json.JSONException;

import java.util.ArrayList;

public class BotanisteAccueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.botaniste_accueil);

        RecyclerView rvPlantsAccueil = (RecyclerView) findViewById(R.id.vertical_recycle_view_accueil_botaniste);

        try {
            VolleySingleton
                    .getInstance(BotanisteAccueil.this)
                    .getData("/api/plantAll", response -> {
                        try {
                            // Initialize infoplants
                            ArrayList<info_plant> infoplants = info_plant.createList(response);
                            // Create adapter passing in the sample plant data
                            PlantAdapter3 adapter = new PlantAdapter3(infoplants);
                            // Attach the adapter to the recyclerview to populate items
                            rvPlantsAccueil.setAdapter(adapter);
                            // Set layout manager to position the items
                            rvPlantsAccueil.setLayoutManager(new LinearLayoutManager(this));
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Page de retour a définir*/
    /*@Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this, saisir.class);
        startActivity(intentBack);
    }*/

    // ********** App bar **********

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu_deco, menu);
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
