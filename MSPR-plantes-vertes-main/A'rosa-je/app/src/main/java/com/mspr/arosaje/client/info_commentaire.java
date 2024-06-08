package com.mspr.arosaje.client;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class info_commentaire extends AppCompatActivity {
    private String mText, mCreatedAt;
    String mUser;

    public info_commentaire(String text, String createdAt, String user) {
        mText = text;
        mCreatedAt = createdAt;
        mUser = user;
    }

    public String getText() {
        return mText;
    }

    public String getDate() {
        return mCreatedAt;
    }

    public String getUser() throws JSONException {
        return mUser;
    }

    public static ArrayList<info_commentaire> createList(JSONArray arrayList) throws JSONException {
        ArrayList<info_commentaire> infocommentaires = new ArrayList<info_commentaire>();

        for (int i = 0; i < arrayList.length(); i++) {
            JSONObject jsonobject = arrayList.getJSONObject(i);
            infocommentaires.add(new info_commentaire(jsonobject.getString("text"), jsonobject.getString("createdAt"), jsonobject.getJSONObject("user").getString("firstname")));
        }

        return infocommentaires;
    }
}
