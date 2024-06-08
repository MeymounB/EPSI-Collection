package com.mspr.arosaje.client;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mspr.arosaje.R;
import com.mspr.arosaje.auth.AuthManager;
import com.mspr.arosaje.botanist.BotanisteAccueil;
import com.mspr.arosaje.database.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;


public class ClientConnexion extends AppCompatActivity {

    Button btn_insc, btn_conn;
    android.widget.EditText mail_conn, password_conn;
    Intent identification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_connexion);
        btn_insc = findViewById(R.id.btn_insc);
        btn_conn = findViewById(R.id.btn_conn);
        mail_conn = findViewById(R.id.mail_conn);
        password_conn = findViewById(R.id.password_conn);

        btn_insc.setOnClickListener(v2 -> openActivityClientCInscription());

        btn_conn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                String mail, password;
                mail = String.valueOf(mail_conn.getText());
                password = String.valueOf(password_conn.getText());

                try {
                    AuthManager.getInstance(ClientConnexion.this).login(mail, password, response -> {
                        Toast.makeText(ClientConnexion.this, "Connexion effectuée", Toast.LENGTH_SHORT).show();
                        try {
                            if (response.getString("roles").equals("[\"ROLE_USER\",\"ROLE_CUSTOMER\"]")) {
                                identification = new Intent(getApplicationContext(), ClientAccueil.class);
                            } else {
                                identification = new Intent(getApplicationContext(), BotanisteAccueil.class);
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        startActivity(identification);
                        finish();
                    });
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void openActivityClientCInscription() {
        Intent ClientInscription = new Intent(this, ClientInscription.class);
        startActivity(ClientInscription);
        finish();
    }

    /*Bouton retour*/
    @Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this, ClientAccueil.class);
        startActivity(intentBack);
    }

}
