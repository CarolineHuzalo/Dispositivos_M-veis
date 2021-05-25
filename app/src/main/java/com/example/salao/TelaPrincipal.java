package com.example.salao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity {
    Button cabelereiro;
    Button manicure;
    Button promocao;
    Button loja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        cabelereiro = findViewById(R.id.cabelos);
        manicure = findViewById(R.id.manicure);
        promocao = findViewById(R.id.promocoes);
        loja = findViewById(R.id.loja);

        cabelereiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, ServicosCabelereiro.class);
                startActivity(i);
            }
        });
        manicure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, ServicosManicure.class);
                startActivity(i);
            }
        });
        promocao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, TipoPromocoes.class);
                startActivity(i);
            }
        });
        loja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, TipoLoja.class);
                startActivity(i);
            }
        });
    }

}