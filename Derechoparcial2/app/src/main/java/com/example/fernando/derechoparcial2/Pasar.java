package com.example.fernando.derechoparcial2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pasar extends AppCompatActivity {
    private EditText nombre, apellido;
    private Button avanzar, regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasar);
        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        avanzar = (Button) findViewById(R.id.avanzar);
        regresar = (Button) findViewById(R.id.regresar);

        avanzar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String n=nombre.getText().toString();
                String a=apellido.getText().toString();
                if(n.equals("") || a.equals("")){
                    Toast.makeText(getApplicationContext(), "Introduzca su nombre y apellido", Toast.LENGTH_SHORT).show();

                }else{
                    String total=n+" "+a;
                    Intent myIntent = new Intent(Pasar.this, avanzar.class);
                    myIntent.putExtra("key", total);
                    Pasar.this.startActivity(myIntent);
                    finish();

                }

            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(Pasar.this, MainActivity.class);
                Pasar.this.startActivity(myIntent);
                finish();

            }
        });

    }
}
