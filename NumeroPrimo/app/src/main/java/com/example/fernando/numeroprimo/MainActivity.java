package com.example.fernando.numeroprimo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button calcular;
    private EditText numero;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcular = (Button) findViewById(R.id.calcular);
        numero = (EditText) findViewById(R.id.numero);
        resultado = (TextView) findViewById(R.id.resultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String escrito = numero.getText().toString();

                if(escrito.isEmpty()){
                    resultado.setText("");
                    Toast.makeText(getApplicationContext(), "Ingrese un numero", Toast.LENGTH_LONG).show();
                }else{
                    int num = Integer.parseInt(numero.getText().toString());
                    int res=num%2;
                    if(num==0){
                        Toast.makeText(getApplicationContext(), "Ingrese un numero que no sea 0", Toast.LENGTH_LONG).show();
                    }else{
                        if(res==0){
                            resultado.setText("Es un numero par");
                        }else {
                            resultado.setText("Es un numero primo");
                        }
                    }
                }
            }
            });
    }
}
