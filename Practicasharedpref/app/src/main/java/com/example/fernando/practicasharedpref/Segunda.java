package com.example.fernando.practicasharedpref;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Segunda extends AppCompatActivity {
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        texto = (TextView) findViewById(R.id.texto);



        String data = getIntent().getExtras().getString("key");
            texto.setText(data);

    }
}
