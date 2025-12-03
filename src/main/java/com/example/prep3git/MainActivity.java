package com.example.prep3git;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etInputValor;
    private TextView tvResultado;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etInputValor = findViewById(R.id.etNumeroN);
        tvResultado = findViewById(R.id.tvResultado);
        btnCalc = findViewById(R.id.btnCalcular);

        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc() {
        int valor = Integer.parseInt(etInputValor.getText().toString());
        if (valor < 0 || valor > 20) {
            tvResultado.setText("Valor inválido!");
        }else{
            String res = getString(R.string.etResultadoPlaceholder) + calcularSerieRecursiva(valor);
            tvResultado.setText(res);
        }
    }
    private float calcularSerieRecursiva(int n) {
        if (n <= 0) {
            return 0.0f;
        }
        float termoAtual = (float) n / (n * n);
        return termoAtual + calcularSerieRecursiva(n - 1);
    }
}