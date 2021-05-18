package com.example.salao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {
    EditText nome;
    EditText senha;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        nome = findViewById(R.id.nome);
        senha = findViewById(R.id.senha);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (senha.getText().toString().equals(nome.getText().toString())){
                    Intent i = new Intent(Home.this,TelaPrincipal.class );
                    startActivity(i);
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
                    builder.setTitle("ERRO");
                    builder.setMessage("Senha Inválida");
                    builder.setCancelable(true);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(Home.this, Home.class );
                            startActivity(i);
                        }
                    });
                    AlertDialog alertDialog =builder.create();
                    alertDialog.show();
                }
            }
        });


    }
}