package com.example.practica1;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ToDoList extends AppCompatActivity {

    private Button vueltaMenu, botonBorrar;
    private CheckBox tick1, tick2, tick3, tick4, tick5;
    private EditText task1, task2, task3, task4, task5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_to_do_list);

        vueltaMenu = findViewById(R.id.backMenu);


        vueltaMenu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v){
               openMenu(v);
            }
        });

        task1 = findViewById(R.id.editText1);
        task2 = findViewById(R.id.editText2);
        task3 = findViewById(R.id.editText3);
        task4 = findViewById(R.id.editText4);
        task5 = findViewById(R.id.editText5);

        botonBorrar = findViewById(R.id.borrar);

        tick1 = findViewById(R.id.checkBox);
        tick2 = findViewById(R.id.checkBox2);
        tick3 = findViewById(R.id.checkBox3);
        tick4 = findViewById(R.id.checkBox4);
        tick5 = findViewById(R.id.checkBox5);


        /*
        Array o Lista: Cuando necesitas manejar todos los CheckBox en conjunto.

        CheckBox[] nombre = new CheckBox[5];
        nombre[0] = findViewById(R.id.idCheckBox1);
        nombre[1] = findViewById(R.id.idCheckBox1);
        nombre[2] = findViewById(R.id.idCheckBox1);
        nombre[3] = findViewById(R.id.idCheckBox1);
        nombre[4] = findViewById(R.id.idCheckBox1);

       Ejemplo: Verificar el estado de todos los CheckBox
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isChecked()) {
                // Realizar acción si está seleccionado
            }
        }


        ViewGroup: Cuando los CheckBox están en una estructura contenedora común y deseas procesarlos automáticamente
        TableLayout nombre = findViewById(R.id.idtableLayout);
        for (int i = 0; i < nombre.getChildCount(); i++) {
            View row = nombre.getChildAt(i);
            if (row instanceof TableRow) {
                for (int j = 0; j < ((TableRow) row).getChildCount(); j++) {
                    View item = ((TableRow) row).getChildAt(j);
                    if (item instanceof CheckBox) {
                        CheckBox checkBox = (CheckBox) item;
                        // Realizar acciones con el CheckBox

                        if (checkBox.isChecked()) {
                        // Realizar acción si está seleccionado
                        }
                    }
                }
            }
        }

        */

        tick1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                task1.setPaintFlags(task1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                task1.setPaintFlags(task1.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                task1.setText("");
            }
        });

        tick2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                task2.setPaintFlags(task2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                task2.setPaintFlags(task2.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                task2.setText("");
            }
        });

        tick3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                task3.setPaintFlags(task3.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                task3.setPaintFlags(task3.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                task3.setText("");
            }
        });

        tick4.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                task4.setPaintFlags(task4.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                task1.setPaintFlags(task4.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                task4.setText("");
            }
        });

        tick5.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                task5.setPaintFlags(task5.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                task5.setPaintFlags(task5.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                task5.setText("");
            }
        });


        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tick1.setChecked(false);
                tick2.setChecked(false);
                tick3.setChecked(false);
                tick4.setChecked(false);
                tick5.setChecked(false);
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