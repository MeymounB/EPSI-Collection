package com.mspr.arosaje.client;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.mspr.arosaje.R;
import com.mspr.arosaje.auth.AuthManager;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

public class ClientInscription extends AppCompatActivity {

    android.widget.EditText post, code_post, ville, email, mdp, conf_mdp, numero_rue, prenom, nom;
    String type_user = "customer";
    Button b1, b_login;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_inscription);

        post = findViewById(R.id.adress_postal);
        code_post = findViewById(R.id.code_postal);
        ville = findViewById(R.id.ville);
        email = findViewById(R.id.email_address);
        mdp = findViewById(R.id.password_insc);
        conf_mdp = findViewById(R.id.confirm_password);
        numero_rue = findViewById(R.id.numero_rue);
        prenom = findViewById(R.id.prenom_insc);
        nom = findViewById(R.id.nom_insc);

        Log.e("post", String.valueOf(post));

        b1 = findViewById(R.id.button1);
        b_login = findViewById(R.id.login);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject respObj = new JSONObject();
                    respObj.put("street", String.valueOf(post.getText()));
                    respObj.put("zipCode", String.valueOf(code_post.getText()));
                    respObj.put("city", String.valueOf(ville.getText()));
                    respObj.put("email", String.valueOf(email.getText()));
                    respObj.put("password", String.valueOf(mdp.getText()));
                    respObj.put("passwordConfirm", String.valueOf(mdp.getText()));
                    respObj.put("firstname", String.valueOf(nom.getText()));
                    respObj.put("lastname", String.valueOf(prenom.getText()));
                    respObj.put("streetNumber", String.valueOf(numero_rue.getText()));

                    AuthManager.getInstance(ClientInscription.this).register(respObj, "/" + type_user, response -> {
                        Toast.makeText(ClientInscription.this, "Inscription effectuée", Toast.LENGTH_SHORT).show();
                        Intent identification = new Intent(getApplicationContext(), ClientConnexion.class);
                        startActivity(identification);
                        finish();
                    });
                } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
        });

        b_login.setOnClickListener(v2 -> openActivityClientConnexion());
    }

    public void openActivityClientConnexion() {
        Intent ClientConnexion = new Intent(this, ClientConnexion.class);
        startActivity(ClientConnexion);
        finish();
    }

    public void radio_insc(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        final int customerId = R.id.client_insc;
        final int botanistId = R.id.botaniste_insc;
        // Check which radio button was clicked
        switch (view.getId()) {
            case customerId:
                if (checked)
                    type_user = "customer";
                break;
            case botanistId:
                if (checked)
                    type_user = "botaniste";
                break;
        }
    }

}