package com.mspr.arosaje.common;

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

public class choixMessage extends AppCompatActivity {
    TextView textView_title, textView_expeditor, textView_date, textView_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_message);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
        String date = intent.getStringExtra("date");
        String expeditor = intent.getStringExtra("expeditor");
        String description = intent.getStringExtra("description");

        textView_title = (TextView) findViewById(R.id.object_message);
        textView_expeditor = (TextView) findViewById(R.id.expediteur);
        textView_date = (TextView) findViewById(R.id.date_message);
        textView_description = (TextView) findViewById(R.id.description_message);

        textView_title.setText(title);
        textView_expeditor.setText(expeditor);
        textView_date.setText(date);
        textView_description.setText(description);
    }

    /*Bouton retour*/
    @Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this, get_messages.class);
        startActivity(intentBack);
    }

    // ********** App bar **********

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu_sans_deco, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.deco) {
            Intent accueil = new Intent(this, ClientConnexion.class);
            startActivity(accueil);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }*/

}
