package com.mspr.arosaje.botanist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.mspr.arosaje.R;

public class VerifBotaniste extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verification_botaniste);

    }

    /*Page de retour a définir*/
    /*@Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this, saisir.class);
        startActivity(intentBack);
    }*/
}
