package com.example.fernando.practica4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        Toast toast=Toast.makeText(this,"cadena", Toast.LENGTH_LONG);
        toast.show();
        setContentView(R.layout.activity_main);
    }
}
