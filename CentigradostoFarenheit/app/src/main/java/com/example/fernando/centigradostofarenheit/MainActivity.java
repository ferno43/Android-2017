package com.example.fernando.centigradostofarenheit;

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

    private EditText centigrado;
    private TextView far;
    private Button calcular;
    private RelativeLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        centigrado = (EditText) findViewById(R.id.centigrado);
        far = (TextView) findViewById(R.id.far);
        calcular = (Button) findViewById(R.id.calcular);
        l = (RelativeLayout) findViewById(R.id.activity_main);


        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String escrito = centigrado.getText().toString();



                if (escrito.isEmpty()) {
                    far.setText("");
                    Toast.makeText(getApplicationContext(), "Ingrese valores", Toast.LENGTH_LONG).show();
                } else {
                    double c = Double.parseDouble(centigrado.getText().toString());

                    double f = ((c*1.8)+32);
                    if (f>100) {
                        l.setBackgroundColor(Color.parseColor("#800000"));
                        far.setText(String.valueOf(f));

                    } else {
                        l.setBackgroundColor(Color.parseColor("#ffffff"));
                        far.setText(String.valueOf(f));
                    }
                }
            }
        });
    }
}
