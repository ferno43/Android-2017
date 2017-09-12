package com.example.fernando.practicalogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText user;
    private EditText contra;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.user);
        contra = (EditText) findViewById(R.id.contra);
        boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (user.getText().toString().equals("fernalop_12@hotmail.com")  && contra.getText().toString().equals("1234")) {

                    Intent intent = new Intent(getApplicationContext(), login.class);
                    startActivity(intent);
                } else {
                    if (user.getText().toString().equals("")  || contra.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Introduzca sus datos", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
