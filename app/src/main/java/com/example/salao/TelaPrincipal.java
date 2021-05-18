package com.example.salao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity {
    Button voltarLogin;
    Button voltarHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        voltarLogin = findViewById(R.id.voltar_login);
        voltarHome = findViewById(R.id.voltar_home);

        voltarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, Home.class);
                startActivity(i);
            }
        });
        voltarHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}