package com.mspr.arosaje.client;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class info_plant extends AppCompatActivity {
    private String mId, mName, mDescription, mEspece, mDate;
    JSONArray mUrlPhoto;
    JSONObject gard_id = null;

    public info_plant(String id, String name, String description, String espece, String date, JSONArray url_photo, JSONObject gard) {
        mId = id;
        mName = name;
        mDescription = description;
        mEspece = espece;
        mDate = date;
        mUrlPhoto = url_photo;
        if (gard != null) {
            gard_id = gard;
        }
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getEspece() {
        return mEspece;
    }

    public String getDate() {
        return mDate;
    }

    public String getUrlPhoto() throws JSONException {
        return mUrlPhoto.getJSONObject(0).getString("src");
    }

    public String getidGard() throws JSONException {
        JSONArray songsArray = gard_id.toJSONArray(gard_id.names());
        return songsArray.getString(0);
    }

    public String getDateGard() throws JSONException {
        JSONArray songsArray = gard_id.toJSONArray(gard_id.names());
        return songsArray.getString(4);
    }

    public static ArrayList<info_plant> createList(JSONArray arrayList) throws JSONException {
        ArrayList<info_plant> infoplants = new ArrayList<info_plant>();

        for (int i = 0; i < arrayList.length(); i++) {
            JSONObject jsonobject = arrayList.getJSONObject(i);
            if (jsonobject.has("gard") && !jsonobject.isNull("gard")) {
                infoplants.add(new info_plant(jsonobject.getString("id"), jsonobject.getString("name"), jsonobject.getString("description"), jsonobject.getString("specie"), jsonobject.getString("createdAt"), jsonobject.getJSONArray("photos"), jsonobject.getJSONObject("gard")));
            } else {
                infoplants.add(new info_plant(jsonobject.getString("id"), jsonobject.getString("name"), jsonobject.getString("description"), jsonobject.getString("specie"), jsonobject.getString("createdAt"), jsonobject.getJSONArray("photos"), null));
            }
        }

        return infoplants;
    }
}
