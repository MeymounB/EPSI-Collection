package com.mspr.arosaje.common;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.mspr.arosaje.client.info_gardiennage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class info_messages extends AppCompatActivity {
    private String mId, mTitle, mDescription, mExpeditor, mDate;

    public info_messages(String id, String title, String description, String expeditor, String date) {
        mId = id;
        mTitle = title;
        mDescription = description;
        mExpeditor = expeditor;
        mDate = date;
    }

    public String getId() {
        return mId;
    }

    public String getTitles() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getExpeditor() {
        return mExpeditor;
    }

    public String getDate() {
        return mDate;
    }

    public static ArrayList<info_messages> createList(JSONArray arrayList) throws JSONException {
        ArrayList<info_messages> infomessages = new ArrayList<info_messages>();

        for (int i = 0; i < arrayList.length(); i++) {
            JSONObject jsonobject = arrayList.getJSONObject(i);
            infomessages.add(new info_messages(jsonobject.getString("id"), jsonobject.getString("title"), jsonobject.getString("description"), jsonobject.getJSONObject("sender").getString("firstname"), jsonobject.getString("createdAt")));
        }

        return infomessages;
    }
}
