package com.example.salao;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServicosManicure extends AppCompatActivity {

    RequestQueue requestQueue;
    TextView unha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos_manicure);
        unha = (TextView) findViewById(R.id.textManicure);
        requestQueue = Volley.newRequestQueue(this);
        getdados();
        setTitle("Salão da Barbie - Manicure");
    }

    private void getdados() {
        String url = "https://my-json-server.typicode.com/CarolineHuzalo/dispositivos_moveis_JSON/Manicure";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        unha.append(jsonObject.get("Tipo").toString() + " R$ " + jsonObject.get("Valor").toString()+"\n");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}