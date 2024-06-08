package com.mspr.arosaje.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mspr.arosaje.R;
import com.mspr.arosaje.database.VolleySingleton;

import org.json.JSONException;

import java.util.ArrayList;


public class ClientAccueil extends AppCompatActivity {

    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_accueil);

        b1 = (Button) findViewById(R.id.btn_gardienner);
        b2 = (Button) findViewById(R.id.btn_monprofil);
        b3 = (Button) findViewById(R.id.btn_addPlant);

        RecyclerView rvPlantsAccueil = (RecyclerView) findViewById(R.id.vertical_recycle_view_accueil);

        try {
            VolleySingleton
                    .getInstance(ClientAccueil.this)
                    .getData("/api/plant/notInGard", response -> {
                        try {
                            // Initialize infoplants
                            ArrayList<info_plant> infoplants = info_plant.createList(response);
                            // Create adapter passing in the sample plant data
                            PlantAdapter2 adapter = new PlantAdapter2(infoplants);
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

        // ***************** Changement de page au clic *****************

        b1.setOnClickListener(v2 -> openActivityGardienner());

        b2.setOnClickListener(v2 -> openActivityProfil());

        b3.setOnClickListener(v2 -> openActivityAjouterPlante());

    }

    /*Page d'acceuil donc le bouton retour quitte l'app? */
    /*D'apres l'interWEB un bouton exit app n'est pas une bonne pratique*/
    /*@Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this, saisir.class);
        startActivity(intentBack);
    }*/

    public void openActivityGardienner() {
        Intent gardienner = new Intent(this, Client_list_rdv.class);
        startActivity(gardienner);
        finish();
    }

    public void openActivityProfil() {
        Intent monProfil = new Intent(this, ClientProfil.class);
        startActivity(monProfil);
        finish();
    }

    public void openActivityAjouterPlante() {
        Intent ajouterPlante = new Intent(this, ClientAjouterPlante.class);
        startActivity(ajouterPlante);
        finish();
    }

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
