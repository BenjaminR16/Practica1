package com.example.practica1;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class ConversorTmp extends AppCompatActivity {

    //declaramos variables
    private EditText num1, num2;
    private TextView tv, tv2;
    private Button boton, vueltaMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_conversor_tmp);

        //referenciamos al layout
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        tv = findViewById(R.id.resultadoTV);
        tv2 = findViewById(R.id.resultadoTV2);
        boton = findViewById(R.id.boton);
        vueltaMenu = findViewById(R.id.backMenu);

        //Clic boton de vuelta al menu
        vueltaMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openMenu(v);
            }
        });

        //Clic boton con con funcion
        boton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               convertirTemperatura();
           }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void convertirTemperatura(){
        String celsius = num1.getText().toString();
        String fahrenheit = num2.getText().toString();

        if(!celsius.isEmpty()){
            double celsiusD = Double.parseDouble(celsius);
            double fahrengeitD = (celsiusD * 9/5) + 32;
            tv.setText(String.valueOf(fahrengeitD)); //enseñarlo por pantalla
        }else if(!fahrenheit.isEmpty()){
            double fahrenheitD = Double.parseDouble(fahrenheit);
            double celsiusD = (fahrenheitD - 32) * 5/9;
            tv2.setText(String.valueOf(celsiusD));
        }
    }

    //metodo para volver al menu
    private void openMenu(View view) {
        Intent intent = new Intent(this, MainButtons.class);
        startActivity(intent);
    }

}