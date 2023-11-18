package com.example.taxescalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPricipal extends AppCompatActivity {
Button btCredito, btDebito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCredito = findViewById(R.id.btnCred2);
        btDebito = findViewById(R.id.btnDeb2);

        btCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaCredito = new Intent(getApplicationContext(), Credito.class);
                startActivity(telaCredito);
            }
        });

        btDebito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaDebito = new Intent(getApplicationContext(), Debito.class);
                startActivity(telaDebito);
            }
        });
    }
}