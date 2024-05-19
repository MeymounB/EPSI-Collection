package com.example.projet_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Restaurant5 extends AppCompatActivity {
    private Button button;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant5);
        button = (Button) findViewById(R.id.Suivant);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goForward();
            }
        });
        button1 = (Button) findViewById(R.id.Retour);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
    }

    public void goForward(){

        Intent intent = new Intent(this, Restaurant6.class);
        startActivity(intent);
    }

    public void goBack(){
        Intent intent2 = new Intent(this, Restaurant4.class);
        startActivity(intent2);
    }


}