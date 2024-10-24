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

public class MainButtons extends AppCompatActivity {

    Button cal, conv, clicks, toDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_buttons);

        cal = findViewById(R.id.calculadora);
        conv = findViewById(R.id.conversor);
        clicks = findViewById(R.id.clicks);
        toDo = findViewById(R.id.toDoList);

        // Listener para el botón de Calculadora
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opeCal(v);
            }
        });

        // Listener para el botón de Conversor de Temperatura
        conv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConv(v);
            }
        });

        // Listener para el botón de Contador de Clicks
        clicks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClicks(v);
            }
        });

        // Listener para el botón de Lista de Tareas (To-Do List)
        toDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openToDo(v);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void opeCal(View view) {
        Intent intent = new Intent(this, Calculadora.class);
        startActivity(intent);
    }

    private void openConv(View view){
        Intent intent = new Intent(this, ConversorTmp.class);
        startActivity(intent);
    }

    private void openClicks(View view){
        Intent intent = new Intent(this, ContadorClicks.class);
        startActivity(intent);
    }

    private void openToDo(View view){
        Intent intent = new Intent(this, ToDoList.class);
        startActivity(intent);
    }

}