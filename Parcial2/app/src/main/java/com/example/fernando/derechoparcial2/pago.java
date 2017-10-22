package com.example.fernando.derechoparcial2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class pago extends AppCompatActivity {
    private Button boton;
    private RadioButton efectivo, tarjeta, paypal;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        radioGroup =(RadioGroup) findViewById(R.id.radioGroup);
        boton =(Button) findViewById(R.id.boton);
        efectivo =(RadioButton) findViewById(R.id.radio1);
        tarjeta =(RadioButton) findViewById(R.id.radio2);
        paypal =(RadioButton) findViewById(R.id.radio3);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(efectivo.isChecked()){
                    Toast.makeText(getApplicationContext(), "Pago por efectivo", Toast.LENGTH_SHORT).show();
                }else if(tarjeta.isChecked()){
                    Toast.makeText(getApplicationContext(), "Pago por tarjeta", Toast.LENGTH_SHORT).show();
                }else if(paypal.isChecked()){
                    Toast.makeText(getApplicationContext(), "Pago por paypal", Toast.LENGTH_SHORT).show();
                }
            }
        });
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(pago.this, lista.class);
                pago.this.startActivity(myIntent);

                finish();

            }
        });
    }
}
