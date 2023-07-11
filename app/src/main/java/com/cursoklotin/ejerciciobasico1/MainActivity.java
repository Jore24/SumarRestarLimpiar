package com.cursoklotin.ejerciciobasico1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvResultado;
    EditText numero1, numero2;
    Button btnSumar, btnRestar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = findViewById(R.id.tvResultado);
        numero1 = findViewById(R.id.txtNumero1);
        numero2 = findViewById(R.id.txtNumero2);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        btnSumar.setOnClickListener(v -> {
            if (validarCampos()) {
                int resultado = sumar(Integer.parseInt(numero1.getText().toString()), Integer.parseInt(numero2.getText().toString()));
                tvResultado.setText("La suma es: " + resultado);
            }
        });

        btnRestar.setOnClickListener(v -> {
            if (validarCampos()) {
                int resultado = restar(Integer.parseInt(numero1.getText().toString()), Integer.parseInt(numero2.getText().toString()));
                tvResultado.setText("La resta es: " + resultado);
            }
        });

        btnLimpiar.setOnClickListener(v -> {
            numero1.setText("");
            numero2.setText("");
            tvResultado.setText("Resultado");
        });
    }

    private boolean validarCampos() {
        String valor1 = numero1.getText().toString();
        String valor2 = numero2.getText().toString();

        if (valor1.isEmpty() || valor2.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos números", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private int sumar(int a, int b) {
        if (a == 0 || b == 0) {
            Toast.makeText(this, "No se puede sumar con 0", Toast.LENGTH_SHORT).show();
        }

        if (a < 0 || b < 0) {
            Toast.makeText(this, "No se puede sumar con negativos", Toast.LENGTH_SHORT).show();
        }

        return a + b;
    }

    private int restar(int a, int b) {
        return a - b;
    }
}

