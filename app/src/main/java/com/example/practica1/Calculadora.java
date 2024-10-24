package com.example.practica1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    private Button but1, but2, but3, but4, but5, but6, but7, but8, but9, but0, butMult, butSum, butRes, butDiv, butEqual, butClean, vueltaMenu;
    private TextView tv1;
    private String operador = "";
    private double num1 = 0, num2 = 0;
    private boolean segNumero = false;


    private View.OnClickListener numberClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Button b = (Button) v;
            if (!segNumero){
                tv1.append(b.getText().toString());
            }else{
                tv1.setText(b.getText().toString());
                segNumero = false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.resultadoTV);
        but1 = findViewById(R.id.buttom1);
        but2 = findViewById(R.id.buttom2);
        but3 = findViewById(R.id.buttom3);
        but4 = findViewById(R.id.buttom4);
        but5 = findViewById(R.id.buttom5);
        but6 = findViewById(R.id.buttom6);
        but7 = findViewById(R.id.buttom7);
        but8 = findViewById(R.id.buttom8);
        but9 = findViewById(R.id.buttom9);
        but0 = findViewById(R.id.buttom0);
        butMult = findViewById(R.id.buttomMult);
        butSum = findViewById(R.id.buttomSum);
        butRes = findViewById(R.id.buttomRest);
        butDiv = findViewById(R.id.buttomDiv);
        butEqual = findViewById(R.id.buttomEqual);
        butClean = findViewById(R.id.buttomClean);
        vueltaMenu = findViewById(R.id.backMenu);

        but1.setOnClickListener(numberClickListener);
        but2.setOnClickListener(numberClickListener);
        but3.setOnClickListener(numberClickListener);
        but4.setOnClickListener(numberClickListener);
        but5.setOnClickListener(numberClickListener);
        but6.setOnClickListener(numberClickListener);
        but7.setOnClickListener(numberClickListener);
        but8.setOnClickListener(numberClickListener);
        but9.setOnClickListener(numberClickListener);
        but0.setOnClickListener(numberClickListener);


        //vuelta al menu
        vueltaMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu(v);
            }

        });

        // Manejo de operadores
        butSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "+";
                num1 = Double.parseDouble(tv1.getText().toString());
                segNumero = true;
            }
        });

        butRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "-";
                num1 = Double.parseDouble(tv1.getText().toString());
                segNumero = true;
            }
        });

        butMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "*";
                num1 = Double.parseDouble(tv1.getText().toString());
                segNumero = true;
            }
        });

        butDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = "/";
                num1 = Double.parseDouble(tv1.getText().toString());
                segNumero = true;
            }
        });

        // Manejo del botón "C" para limpiar la pantalla
        butClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("");
            }
        });

        // Manejo del botón "=" para calcular el resultado
        butEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Double.parseDouble(tv1.getText().toString());
                double resultado = 0;

                switch (operador) {
                    case "+":
                        resultado = num1 + num2;
                        break;
                    case "-":
                        resultado = num1 - num2;
                        break;
                    case "*":
                        resultado = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            resultado = num1 / num2;
                        } else {
                            tv1.setText("Error");
                            return;
                        }
                        break;
                }
                tv1.setText(String.valueOf(resultado));
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //metodo para volver al menu
    private void openMenu(View view){
        Intent intent = new Intent(this, MainButtons.class);
        startActivity(intent);
    }


}