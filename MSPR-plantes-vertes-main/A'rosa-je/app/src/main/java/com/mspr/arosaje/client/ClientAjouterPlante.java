package com.mspr.arosaje.client;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mspr.arosaje.R;
import com.mspr.arosaje.database.VolleySingleton;
import com.mspr.arosaje.img.CloudinaryManager;
import com.mspr.arosaje.img.ImageManager;

import org.json.JSONObject;

import java.io.File;

public class ClientAjouterPlante extends AppCompatActivity {

    Button btn_ajout_image, btn_enregistrer_plante;
    ImageView click_image_id;
    EditText nom, espece, description;

    private static final int pic_id = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_ajouter_article);

        btn_enregistrer_plante = (Button) findViewById((R.id.btn_enregistrer_plante));
        btn_ajout_image = (Button) findViewById(R.id.btn_ajout_image);
        click_image_id = (ImageView) findViewById(R.id.click_image);
        nom = findViewById(R.id.nom_ajout_plante);
        espece = findViewById(R.id.espece_ajout_plante);
        description = findViewById(R.id.description_ajout_plante);

        btn_ajout_image.setOnClickListener(v -> {
            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(camera_intent, pic_id);
        });

        btn_enregistrer_plante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                try {
                    JSONObject respObj = new JSONObject();
                    respObj.put("name", String.valueOf(nom.getText()));
                    respObj.put("type", String.valueOf(espece.getText()));
                    respObj.put("description", String.valueOf(description.getText()));

                    if(ImageManager.getRemoteImg() != null) {
                        respObj.put("photo", ImageManager.getRemoteImg());
                    }

                    Log.d("RES", "onSuccess: " + ImageManager.getRemoteImg());

                    VolleySingleton
                            .getInstance(ClientAjouterPlante.this)
                            .postData("/api/plant", respObj, response -> Toast
                                    .makeText(ClientAjouterPlante.this, "Plante ajoutée", Toast.LENGTH_SHORT)
                                    .show());
                    redirect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Match the request 'pic id with requestCode
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {

            // BitMap is data structure of image file
            // which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            //create a file to write bitmap data
            File img = ImageManager.createFile(photo, this.getCacheDir());

            // Set the image in imageview for display
            click_image_id.setImageBitmap(photo);
            CloudinaryManager.getInstance(this).uploadImage(img);
        }
    }

    public void redirect() {
        Intent intentBack = new Intent(this, ClientAccueil.class);
        startActivity(intentBack);
    }

    @Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this, ClientAccueil.class);
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
