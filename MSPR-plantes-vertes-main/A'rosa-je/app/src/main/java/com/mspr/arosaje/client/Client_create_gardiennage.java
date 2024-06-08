package com.mspr.arosaje.client;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import com.bumptech.glide.Glide;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.mspr.arosaje.R;
import com.mspr.arosaje.database.VolleySingleton;
import com.mspr.arosaje.img.ImageManager;

import org.json.JSONObject;

public class Client_create_gardiennage extends AppCompatActivity {

    TextView date_range_text;
    Button open_calendar, btn_enregistrer;
    ImageView img_view;
    EditText title, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_create_gardiennage);

        date_range_text = findViewById(R.id.select_date);
        open_calendar = findViewById(R.id.calendar);
        img_view = (ImageView) findViewById(R.id.image_create_rdv);
        title = findViewById(R.id.titre);
        message = findViewById(R.id.message_add_rdv);
        btn_enregistrer = findViewById(R.id.btn_register);

        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");
        String espece = intent.getStringExtra("espece");
        String description = intent.getStringExtra("description");
        String date = intent.getStringExtra("date");
        String url_photo = intent.getStringExtra("url_photo");
        String id = intent.getStringExtra("id");

        Glide.with(this).load(url_photo).into(img_view);

        MaterialDatePicker materialDatePicker = MaterialDatePicker.Builder.dateRangePicker().setSelection(Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds())).build();

        open_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "Tag_picker");
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        date_range_text.setText(materialDatePicker.getHeaderText());
                    }
                });
            }
        });
        btn_enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                try {
                    JSONObject respObj = new JSONObject();
                    respObj.put("plantId", Integer.valueOf(id));
                    respObj.put("title", String.valueOf(title.getText()));
                    respObj.put("description", String.valueOf(message.getText()));
                    respObj.put("date_rdv", String.valueOf(date_range_text.getText()));

                    Log.d("RES", "onSuccess: " + respObj);

                    VolleySingleton
                            .getInstance(Client_create_gardiennage.this)
                            .postData("/api/gard", respObj, response -> Toast
                                    .makeText(Client_create_gardiennage.this, "Demande de gardiennage effectuée", Toast.LENGTH_SHORT)
                                    .show());
                    redirect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void redirect() {
        Intent intentBack = new Intent(this, ClientProfil.class);
        startActivity(intentBack);
    }
}
