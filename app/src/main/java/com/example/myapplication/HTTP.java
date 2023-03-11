package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public abstract class HTTP extends AppCompatActivity {
    protected String page;

    protected void CONNECT(String email, String password, String age, String address,String first_name,String family_name) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.8.102//projet/"+page,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("success")) {
                            response();
                        } else {
                            responseError(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        responseError2(error);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return getStringStringMap(email, password, age, address,first_name,family_name);
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    protected abstract void response();
    protected abstract void responseError(String response);
    protected abstract void responseError2(VolleyError error);
    protected abstract Map<String, String> getStringStringMap(String email, String password, String age, String address,String first_name,String family_name);

}
