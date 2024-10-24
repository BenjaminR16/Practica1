package com.example.practica1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContadorClicks extends AppCompatActivity {

    Button botonContador, vueltaMenu;
    TextView contadorView;
    int numClicks = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contador_clicks);

        botonContador = findViewById(R.id.boton);
        contadorView = findViewById(R.id.textView2);
        vueltaMenu = findViewById(R.id.backMenu);

        botonContador.setOnClickListener(v -> {
            numClicks++;
            contadorView.setText(String.valueOf(numClicks));
        });

        vueltaMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openMenu(v);
                }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void openMenu(View view){
        Intent intent = new Intent(this, MainButtons.class);
        startActivity(intent);
    }

}