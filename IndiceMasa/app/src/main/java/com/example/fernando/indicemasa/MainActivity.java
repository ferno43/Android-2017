package com.example.fernando.indicemasa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText peso;
    private EditText estatura;
    private TextView estatus;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        peso = (EditText) findViewById(R.id.peso);
        estatura = (EditText) findViewById(R.id.estatura);
        estatus = (TextView) findViewById(R.id.estatus);
        calcular = (Button) findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String escrito = peso.getText().toString();
                String escrito1 = estatura.getText().toString();


                if (escrito.isEmpty() || escrito1.isEmpty()) {
                    estatus.setText("");
                    Toast.makeText(getApplicationContext(), "Ingrese todos los valores", Toast.LENGTH_LONG).show();
                } else {
                    double p = Double.parseDouble(peso.getText().toString());
                    double e = Double.parseDouble(estatura.getText().toString());
                    double imc = (p / (e * e));
                    if (imc >= 19 && imc <= 24.9) {
                        estatus.setText("El paciente se encuentra en el peso adecuado");
                    } else {
                        estatus.setText("El paciente no se encuentra en el peso adecuado");
                    }
                }
            }
        });
    }
}

    /*public void onClick(View v){
        String escrito = peso.getText().toString();
        String escrito1 = estatura.getText().toString();
        peso=(EditText) findViewById(R.id.peso);
        estatura=(EditText) findViewById(R.id.estatura);
        estatus=(TextView) findViewById(R.id.estatus);
        int p = Integer.parseInt(peso.getText().toString());
        int e = Integer.parseInt(estatura.getText().toString());

        int imc=(p/(e*e));

        if(escrito.isEmpty() || escrito1.isEmpty()){
            Toast.makeText(getApplicationContext(),"Ingrese todos los valores", Toast.LENGTH_LONG).show();
        }
        else{

            if(imc>19 && imc<24.9) {
                estatus.setText("El paciente se encuentra en el peso adecuado");
            }else{
                estatus.setText("El paciente se encuentra en el peso adecuado");
            }
        }


    }*/


