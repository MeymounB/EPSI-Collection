package com.example.projet_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Restaurant4 extends AppCompatActivity {
    private Button button;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant4);
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

        Intent intent = new Intent(this, Restaurant5.class);
        startActivity(intent);
    }

    public void goBack(){
        Intent intent2 = new Intent(this, Restaurant3.class);
        startActivity(intent2);
    }


}