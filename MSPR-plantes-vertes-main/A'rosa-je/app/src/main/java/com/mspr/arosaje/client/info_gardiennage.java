package com.mspr.arosaje.client;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class info_gardiennage extends AppCompatActivity {
    private String mId, mName, mDescription, mEspece, mDate;
    JSONArray mUrlPhoto;

    JSONObject gard_id, owner_info = null;

    public info_gardiennage(String id, String name, String description, String espece, String date, JSONArray url_photo, JSONObject gard, JSONObject owner) {
        mId = id;
        mName = name;
        mDescription = description;
        mEspece = espece;
        mDate = date;
        mUrlPhoto = url_photo;
        if (gard != null) {
            gard_id = gard;
        }
        if (owner != null) {
            owner_info = owner;
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

    public String getTitleGard() throws JSONException {
        JSONArray songsArray = gard_id.toJSONArray(gard_id.names());
        Log.e("ttt", songsArray.getString(5));
        return songsArray.getString(5);
    }

    public String getDateGard() throws JSONException {
        JSONArray songsArray = gard_id.toJSONArray(gard_id.names());
        return songsArray.getString(4);
    }

    public String getNameGard() throws JSONException {
        JSONArray songsArray = owner_info.toJSONArray(owner_info.names());
        return songsArray.getString(2);
    }

    public String getGuardian() throws JSONException {
        return gard_id.getJSONObject("botanist").getString("firstname");
    }

    public static ArrayList<info_gardiennage> createList(JSONArray arrayList) throws JSONException {
        ArrayList<info_gardiennage> infoplants = new ArrayList<info_gardiennage>();

        for (int i = 0; i < arrayList.length(); i++) {
            JSONObject jsonobject = arrayList.getJSONObject(i);
            infoplants.add(new info_gardiennage(jsonobject.getString("id"), jsonobject.getString("name"), jsonobject.getString("description"), jsonobject.getString("specie"), jsonobject.getString("createdAt"), jsonobject.getJSONArray("photos"), jsonobject.getJSONObject("gard"), jsonobject.getJSONObject("owner")));
        }

        return infoplants;
    }
}
