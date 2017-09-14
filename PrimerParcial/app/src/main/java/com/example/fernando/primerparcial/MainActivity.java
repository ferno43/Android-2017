package com.example.fernando.primerparcial;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button m1,m2, suma1, suma2, suma3, suma4, calcular;
    private EditText total;
    private TextView actual, porcentaje;
    private RelativeLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m1 = (Button) findViewById(R.id.m1);
        m2 = (Button) findViewById(R.id.m2);
        suma1 = (Button) findViewById(R.id.suma1);
        suma2 = (Button) findViewById(R.id.suma2);
        suma3 = (Button) findViewById(R.id.suma3);
        suma4 = (Button) findViewById(R.id.suma4);
        calcular = (Button) findViewById(R.id.calcular);
        total = (EditText) findViewById(R.id.total);
        actual = (TextView) findViewById(R.id.actual);
        porcentaje = (TextView) findViewById(R.id.porcentaje);
        l = (RelativeLayout) findViewById(R.id.activity_main);


        suma1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String escrito = total.getText().toString();

                if (escrito.isEmpty()) {
                    actual.setText("0");
                    Toast.makeText(getApplicationContext(), "Ingrese total", Toast.LENGTH_LONG).show();
                } else {
                    int b=Integer.parseInt(actual.getText().toString());
                    b=b+5;
                    actual.setText(String.valueOf(b));
                }

            }
        });

        suma2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String escrito = total.getText().toString();

                if (escrito.isEmpty()) {
                    actual.setText("0");
                    Toast.makeText(getApplicationContext(), "Ingrese total", Toast.LENGTH_LONG).show();
                } else {
                    int b=Integer.parseInt(actual.getText().toString());
                    b=b+15;
                    actual.setText(String.valueOf(b));
                }

            }
        });

        suma3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String escrito = total.getText().toString();

                if (escrito.isEmpty()) {
                    actual.setText("0");
                    Toast.makeText(getApplicationContext(), "Ingrese total", Toast.LENGTH_LONG).show();
                } else {
                    int b=Integer.parseInt(actual.getText().toString());
                    b=b+30;
                    actual.setText(String.valueOf(b));
                }

            }
        });

        suma4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String escrito = total.getText().toString();

                if (escrito.isEmpty()) {
                    actual.setText("0");
                    Toast.makeText(getApplicationContext(), "Ingrese total", Toast.LENGTH_LONG).show();
                } else {
                    int b=Integer.parseInt(actual.getText().toString());
                    b=b+50;
                    actual.setText(String.valueOf(b));
                }

            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int a=Integer.parseInt(total.getText().toString());
                int b=Integer.parseInt(actual.getText().toString());
                int por=(b*100)/a;
                porcentaje.setText(String.valueOf(por+"%"));
                if((a*.7)<=((por/100)*a)){
                    l.setBackgroundColor(Color.parseColor("#800000"));
                }else{
                    l.setBackgroundColor(Color.parseColor("#ffffff"));
                }

            }
        });

        m1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String escrito = total.getText().toString();

                if (escrito.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ingrese total", Toast.LENGTH_LONG).show();
                }else{
                int a=Integer.parseInt(total.getText().toString());
                int res=a*80;
                Toast.makeText(getApplicationContext(), String.valueOf(res)+" total", Toast.LENGTH_LONG).show();}

            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int a=Integer.parseInt(actual.getText().toString());
                int res=a*80;
                Toast.makeText(getApplicationContext(), String.valueOf(res)+" actual", Toast.LENGTH_LONG).show();

            }
        });
    }
}
