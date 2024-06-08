package com.mspr.arosaje.client;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mspr.arosaje.R;
import com.mspr.arosaje.database.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ClientChoixArticleProfil extends AppCompatActivity {
    TextView textView_nom, textView_espece, textView_date_ajout, textView_description;
    ImageView img_view;

    EditText commentaire;

    Button btn_ajout_commentaire, btn_gardienner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_choisir_article_profil);

        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");
        String espece = intent.getStringExtra("espece");
        String description = intent.getStringExtra("description");
        String date = intent.getStringExtra("date");
        String url_photo = intent.getStringExtra("url_photo");
        String id = intent.getStringExtra("id");

        textView_nom = (TextView) findViewById(R.id.nom_choisir);
        textView_espece = (TextView) findViewById(R.id.espece_choisir);
        textView_date_ajout = (TextView) findViewById(R.id.date_ajout_choisir);
        textView_description = (TextView) findViewById(R.id.descriptif_choisir);
        img_view = (ImageView) findViewById(R.id.image_profil);
        btn_ajout_commentaire = (Button) findViewById(R.id.btn_ajout_commentaire);
        commentaire = findViewById(R.id.champ_commentaire);
        btn_gardienner = findViewById(R.id.btn_gardienner_choix);

        textView_nom.setText(nom);
        textView_espece.setText(espece);
        textView_date_ajout.setText(date);
        textView_description.setText(description);
        Glide.with(this).load(url_photo).into(img_view);

        btn_ajout_commentaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                try {
                    JSONObject respObj = new JSONObject();
                    respObj.put("text", String.valueOf(commentaire.getText()));

                    VolleySingleton
                            .getInstance(ClientChoixArticleProfil.this)
                            .postData("/api/plant/" + id + "/comment", respObj, response -> Toast
                                    .makeText(ClientChoixArticleProfil.this, "Commentaire ajouté", Toast.LENGTH_SHORT)
                                    .show());
                    refresh(nom, espece, description, date, url_photo, id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        RecyclerView rvPlantsAccueil = (RecyclerView) findViewById(R.id.vertical_recycle_view_commentaire_profil);

        try {
            VolleySingleton
                    .getInstance(ClientChoixArticleProfil.this)
                    .getData("/api/plant/" + id + "/comment", response -> {
                        try {
                            Log.e("response", String.valueOf(response));
                            // Initialize infoplants
                            ArrayList<info_commentaire> infocommentaire = info_commentaire.createList(response);
                            // Create adapter passing in the sample plant data
                            PlantAdapter4 adapter = new PlantAdapter4(infocommentaire);
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

        btn_gardienner.setOnClickListener(v2 -> openActivityGardienner(nom, espece, description, date, url_photo, id));
    }

    public void refresh(String nom, String espece, String description, String date, String url, String id) {
        Intent intent = new Intent(this, ClientChoixArticleProfil.class);
        intent.putExtra("nom", nom);
        intent.putExtra("espece", espece);
        intent.putExtra("description", description);
        intent.putExtra("date", date);
        intent.putExtra("url_photo", url);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    /*Bouton retour*/
    @Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this, ClientProfil.class);
        startActivity(intentBack);
    }

    public void openActivityGardienner(String nom, String espece, String description, String date, String url, String id) {
        Intent gardienner = new Intent(this, Client_create_gardiennage.class);
        gardienner.putExtra("nom", nom);
        gardienner.putExtra("espece", espece);
        gardienner.putExtra("description", description);
        gardienner.putExtra("date", date);
        gardienner.putExtra("url_photo", url);
        gardienner.putExtra("id", id);
        startActivity(gardienner);
        finish();
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
