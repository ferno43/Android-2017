package com.example.fernando.derechoparcial2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText usuario, password;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);
        boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String u=usuario.getText().toString();
                String p=password.getText().toString();
                if(u.equals("") || p.equals("")){
                    Toast.makeText(getApplicationContext(), "Introduzca su usuario y password", Toast.LENGTH_SHORT).show();

                }else if(u.equals("segundoparcial") && p.equals("1")){
                    Intent myIntent = new Intent(login.this, lista.class);
                    login.this.startActivity(myIntent);
                    finish();

                }else{
                    Toast.makeText(getApplicationContext(), "Usuario o password incorrecto", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
