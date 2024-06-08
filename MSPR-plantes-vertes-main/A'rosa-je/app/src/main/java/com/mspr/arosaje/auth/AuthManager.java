package com.mspr.arosaje.auth;

import android.content.Context;

import com.android.volley.Response;

import com.mspr.arosaje.database.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

public class AuthManager {
    private static AuthManager instance;

    private final VolleySingleton db;

    private static Object User;

    private static String token;

    private AuthManager(Context ctx) {
        this.db = VolleySingleton.getInstance(ctx);
    }

    public static synchronized AuthManager getInstance(Context ctx) {
        if (instance == null) {
            instance = new AuthManager(ctx);
        }
        return instance;
    }

    public void login(String mail, String pwd, Response.Listener<JSONObject> onSuccess) throws JSONException {
        try {
            JSONObject respObj = new JSONObject();
            respObj.put("username", mail);
            respObj.put("password", pwd);

            this.db
                    .postData("/api/login", respObj, onSuccess);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void register(JSONObject respObj, String type, Response.Listener<JSONObject> onSuccess) {
        try {
            this.db
                    .postData("/api/register" + type, respObj, onSuccess);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getUser() {
        return User;
    }

    public static void setUser(Object user) {
        User = user;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        AuthManager.token = token;
    }
}
