package com.example.fernando.practica4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //String nombre="Fernando";
        //String apellido=" Lopez";
        int numtortas=3;
        int precio=40;
        int total=numtortas*precio;
        super.onCreate(savedInstanceState);
        if (total>80){
            Toast toast = Toast.makeText(this, "Tiene una soda gratis", Toast.LENGTH_LONG);
            toast.show();
        }else{
            Toast toast = Toast.makeText(this, "No tiene una soda gratis", Toast.LENGTH_LONG);
            toast.show();
        }
        setContentView(R.layout.activity_main);
    }
}
