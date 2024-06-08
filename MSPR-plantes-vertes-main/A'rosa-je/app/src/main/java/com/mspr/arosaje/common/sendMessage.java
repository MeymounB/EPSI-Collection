package com.mspr.arosaje.common;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.mspr.arosaje.R;
import com.mspr.arosaje.client.ClientAccueil;
import com.mspr.arosaje.client.ClientConnexion;
import com.mspr.arosaje.client.ClientProfil;
import com.mspr.arosaje.client.Client_list_rdv;
import com.mspr.arosaje.client.GardiennageAdapter;
import com.mspr.arosaje.client.info_gardiennage;
import com.mspr.arosaje.database.VolleySingleton;
import com.mspr.arosaje.img.CloudinaryManager;
import com.mspr.arosaje.img.ImageManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

public class sendMessage extends AppCompatActivity {

    Button btn_envoyer;
    EditText title, description;

    // Classe Utilisateur pour stocker l'ID et le nom
    private static class Utilisateur {
        int id;
        String nom;

        public Utilisateur(int id, String nom) {
            this.id = id;
            this.nom = nom;
        }

        public int getId() {
            return id;
        }

        public String getNom() {
            return nom;
        }

        @Override
        public String toString() {
            return nom;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_message);

        btn_envoyer = findViewById(R.id.btn_envoyer_message);
        title = findViewById(R.id.titre_write_message);
        description = findViewById(R.id.description_envoyer_message);
        Spinner spinner = findViewById(R.id.spinner);

        try {
            VolleySingleton.getInstance(sendMessage.this).getData("/api/users", new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        // Liste pour stocker les objets Utilisateur
                        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

                        // Parcours du tableau JSON
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject utilisateurObj = response.getJSONObject(i);
                            int id = utilisateurObj.getInt("id");
                            String nom = utilisateurObj.getString("firstname");

                            // Création de l'objet Utilisateur et ajout à la liste
                            Utilisateur utilisateur = new Utilisateur(id, nom);
                            utilisateurs.add(utilisateur);
                        }

                        // Adaptateur pour le Spinner
                        ArrayAdapter<Utilisateur> adapter = new ArrayAdapter<Utilisateur>(
                                sendMessage.this,
                                android.R.layout.simple_spinner_item,
                                utilisateurs
                        );
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        // Assignation de l'adaptateur au Spinner
                        spinner.setAdapter(adapter);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        btn_envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                try {
                    // Récupération de l'objet Utilisateur sélectionné
                    Utilisateur utilisateurSelectionne = (Utilisateur) spinner.getSelectedItem();

                    // Obtention de l'ID de l'utilisateur sélectionné
                    int idUtilisateur = utilisateurSelectionne.getId();

                    JSONObject respObj = new JSONObject();
                    respObj.put("title", String.valueOf(title.getText()));
                    respObj.put("description", String.valueOf(description.getText()));
                    respObj.put("receiver", idUtilisateur);

                    VolleySingleton.getInstance(sendMessage.this).postData("/api/message", respObj, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(sendMessage.this, "Message envoyé", Toast.LENGTH_SHORT).show();
                            redirect();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void redirect() {
        Intent intentBack = new Intent(this, ClientAccueil.class);
        startActivity(intentBack);
    }

    @Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this, ClientProfil.class);
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
