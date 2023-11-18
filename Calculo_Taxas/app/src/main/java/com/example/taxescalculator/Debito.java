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

public class Debito extends AppCompatActivity {
    private TextView valorLiquidoDeb;
    private EditText valorDeb;
    private Button voltarDeb;
    private RadioGroup cartoesDeb;
    private RadioButton master, visa, elo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debito);
        valorDeb = findViewById(R.id.txtValorDeb);
        valorLiquidoDeb = findViewById(R.id.txtLiquidoDeb);
        master = findViewById(R.id.rdnMasterDeb);
        visa = findViewById(R.id.rsnVisaDeb);
        elo = findViewById(R.id.rdnEloDeb);
        cartoesDeb = findViewById(R.id.rdgCartoesDeb);
        voltarDeb = findViewById(R.id.btnVoltarDeb);

        debitoSelecionar();

        voltarDeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaPrincipal = new Intent(getApplicationContext(), TelaPricipal.class);
                startActivity(telaPrincipal);
            }
        });
    }

    public void debitoSelecionar() {
        cartoesDeb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                double valorBrutoDeb = Double.parseDouble(String.valueOf(valorDeb.getText()));
                if (checkedId == R.id.rdnMasterDeb) {
                    double porcentagem = 1.90 / 100;
                    double valoresDeb = valorBrutoDeb - (valorBrutoDeb * porcentagem);
                    valorLiquidoDeb.setText("R$" + String.format("%.2f", valoresDeb));
                } else if (checkedId == R.id.rsnVisaDeb) {
                    double porcentagem = 1.98 / 100;
                    double valoresDeb = valorBrutoDeb - (valorBrutoDeb * porcentagem);
                    valorLiquidoDeb.setText("R$" + String.format("%.2f", valoresDeb));
                } else if (checkedId == R.id.rdnEloDeb) {
                    double porcentagem = 2.43 / 100;
                    double valoresDeb = valorBrutoDeb - (valorBrutoDeb * porcentagem);
                    valorLiquidoDeb.setText("R$" + String.format("%.2f", valoresDeb));
                }
            }
        });
    }

}
