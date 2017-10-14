package com.example.fernando.derechoparcial2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class lectura extends AppCompatActivity {
    private Button regresar;

    EditText txt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectura);
        txt =(EditText)findViewById(R.id.txtLeido);
        regresar =(Button) findViewById(R.id.regresar);
        String s = getIntent().getStringExtra("TEXTO");
        txt.setText(s);

        regresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(lectura.this, MainActivity.class);
                lectura.this.startActivity(myIntent);
                finish();

            }
        });
    }

}
