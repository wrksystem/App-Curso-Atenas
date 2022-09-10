package com.example.appcursoatenas;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView peso, altura, result, legenda;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        peso = findViewById(R.id.editTextPeso);
        altura = findViewById(R.id.editTextAltura);
        calcular = findViewById(R.id.calcular);
        result = findViewById(R.id.result);
        legenda = findViewById(R.id.legenda);

        calcular.setOnClickListener(view -> {
            if (TextUtils.isEmpty(peso.getText().toString())) {
                peso.setError("Dados não Preenchidos");
                peso.requestFocus();
                return;
            }

            if (TextUtils.isEmpty(altura.getText().toString())) {
                altura.setError("Dados não Preenchidos");
                altura.requestFocus();
                return;
            }

            double pesoConvertido = Double.parseDouble(peso.getText().toString());
            double alturaConvertido = Double.parseDouble(altura.getText().toString());

            double altura2 = alturaConvertido * alturaConvertido;
            double imc = pesoConvertido / altura2;

            String resultadoFormatado = String.format("%.2f", imc);

            result.setText(resultadoFormatado);

            double resultedF2 = Double.parseDouble(resultadoFormatado);

            if (resultedF2 < 18.5) {
                result.setTextColor(getResources().getColor(android.R.color.holo_blue_bright));
                legenda.setText("DESNUTRIÇÃO");

            } else if (resultedF2 >= 18.5 && resultedF2 < 24.9) {
                result.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                legenda.setText("PESO IDEAL");

            } else if (resultedF2 >= 25 && resultedF2 < 29.9) {
                result.setTextColor(getResources().getColor(android.R.color.holo_orange_light));
                legenda.setText("SOBREPESO");

            } else if (resultedF2 >= 25 && resultedF2 < 29.9) {
                result.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
                legenda.setText("OBESIDADE");

            } else if (resultedF2 > 30) {
                result.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                legenda.setText("OBESIDADE EXTREMA");

            }
        });



    }
}