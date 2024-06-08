package com.mspr.arosaje.database;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mspr.arosaje.auth.AuthManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleySingleton {
    private static VolleySingleton instance;
    private RequestQueue requestQueue;
    private final Context ctx;

    // ********** METTRE SYSTEMATIQUEMENT SA PROPRE IP **********
    private final String baseUrl = "http://172.17.48.1:8000";

    private static final String TAG = "VolleySingleton";

    private VolleySingleton(Context context) {
        this.ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (instance == null) {
            instance = new VolleySingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public void postData(String route, JSONObject data, Response.Listener<JSONObject> onSuccess) {
        Log.d(TAG, "postData: " + data);

        try {

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, baseUrl + route, data,
                    onSuccess,
                    error -> {
                        Toast.makeText(ctx, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
                        Log.e("ERROR1", "onErrorResponse: " + error);
                        Log.e("ERROR2", baseUrl + route);
                    }) {
                @Override
                public Map<String, String> getHeaders() {
                    Map<String, String> headers = new HashMap<>();

                    if (AuthManager.getToken() != null) // Si on est déjà login, il contient forcément le token de symfony
                        headers.put("Cookie", AuthManager.getToken()); // on le set dans les cookies
                    return headers;
                }

                @Override
                protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                    assert response.headers != null;
                    Map<String, String> responseHeaders = response.headers;
                    String rawCookies = responseHeaders.get("Set-Cookie");

                    if (rawCookies != null) { // on récupère le token à la connexion pour le stocker dans AuthManager si il existe
                        AuthManager.setToken(rawCookies);
                    }

                    Log.e("cookies", String.valueOf(rawCookies));
                    return super.parseNetworkResponse(response);
                }
            };

//            Log.d("REQ", "postData: " + request.getHeaders());

            addToRequestQueue(request);
        } catch (Exception e) {
            Log.e("ERROR3", String.valueOf(e));
            e.printStackTrace();
        }
    }

    public void getData(String route, Response.Listener<JSONArray> onSuccess) {
        try {
            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, baseUrl + route, null,
                    onSuccess,
                    error -> {
                        Toast.makeText(ctx, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
                        Log.e("ERROR", "onErrorResponse: " + error);
                    }) {
                @Override
                public Map<String, String> getHeaders() {
                    Map<String, String> headers = new HashMap<>();
                    if (AuthManager.getToken() != null)
                        headers.put("Cookie", AuthManager.getToken()); // on le set dans les cookies
                    return headers;
                }

                @Override
                protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
                    return super.parseNetworkResponse(response);
                }
            };
//            Log.d("REQ", "postData: " + request.getHeaders());
            addToRequestQueue(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}