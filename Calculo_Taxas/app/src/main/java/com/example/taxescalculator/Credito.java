package com.example.taxescalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Credito extends AppCompatActivity {
    private TextView valorLiquidoCred;
    private EditText valorCred;
    private Button voltarCred;
    private RadioGroup cartoesCred;
    private RadioButton master, visa, elo, amex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credito);
        valorCred = findViewById(R.id.txtValorCred);
        valorLiquidoCred = findViewById(R.id.txtLiquidoCred);
        master = findViewById(R.id.rdnMasterCred);
        visa = findViewById(R.id.rdnVisaCred);
        elo = findViewById(R.id.rdnEloCred);
        amex = findViewById(R.id.rdnAmexCred);
        cartoesCred = findViewById(R.id.rdgCartoesCred);
        voltarCred = findViewById(R.id.btnVoltarCred);

        creditoSelecionar();

        voltarCred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaPrincipal = new Intent(getApplicationContext(), TelaPricipal.class);
                startActivity(telaPrincipal);
            }
        });
    }

    public void creditoSelecionar() {
        cartoesCred.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                double valorBrutoCred = Double.parseDouble(String.valueOf(valorCred.getText()));
                if (checkedId == R.id.rdnMasterCred) {
                    double porcentagem = 2.35 / 100;
                    double valoresCred = valorBrutoCred - (valorBrutoCred * porcentagem);
                    valorLiquidoCred.setText("R$" + String.format("%.2f", valoresCred));
                }else if (checkedId == R.id.rdnVisaCred) {
                    double porcentagem = 2.60 / 100;
                    double valoresCred = valorBrutoCred - (valorBrutoCred * porcentagem);
                    valorLiquidoCred.setText("R$" + String.format("%.2f", valoresCred));
                }else if (checkedId == R.id.rdnEloCred) {
                    double porcentagem = 3.75 / 100;
                    double valoresCred = valorBrutoCred - (valorBrutoCred * porcentagem);
                    valorLiquidoCred.setText("R$" + String.format("%.2f", valoresCred));
                }else if (checkedId == R.id.rdnAmexCred) {
                    double porcentagem = 4.13 / 100;
                    double valoresCred = valorBrutoCred - (valorBrutoCred * porcentagem);
                    valorLiquidoCred.setText("R$" + String.format("%.2f", valoresCred));
                }
            }
        });
    }
}