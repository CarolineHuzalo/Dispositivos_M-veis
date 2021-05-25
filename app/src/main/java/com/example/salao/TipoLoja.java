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

public class TipoLoja extends AppCompatActivity {

    RequestQueue requestQueue;
    TextView loja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_loja);
        loja = (TextView) findViewById(R.id.textLoja);
        requestQueue = Volley.newRequestQueue(this);
        getdados();

    }

    private void getdados() {
        String url = "https://my-json-server.typicode.com/CarolineHuzalo/dispositivos_moveis_JSON/Endereco";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        loja.append(jsonObject.get("Localidade").toString() + "\nEndereço: " + jsonObject.get("Endereço").toString() + "\nNumero: " + jsonObject.get("Numero").toString() + "\nTelefone: " + jsonObject.get("Telefone").toString() + "\nEmail: " + jsonObject.get("Email").toString());
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