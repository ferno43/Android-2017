package com.example.fernando.practica11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radiog;
    private RadioButton rbm, rbf;
    private EditText sr, sr1, sra, sra1, sra2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radiog = (RadioGroup) findViewById(R.id.radiog);
        rbm = (RadioButton) findViewById(R.id.rbm);
        rbf = (RadioButton) findViewById(R.id.rbf);
        sr = (EditText) findViewById(R.id.sr);
        sr1 = (EditText) findViewById(R.id.sr1);
        sra = (EditText) findViewById(R.id.sra);
        sra1 = (EditText) findViewById(R.id.sra1);
        sra2 = (EditText) findViewById(R.id.sra2);

        radiog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.rbm) {

                    Toast.makeText(getApplicationContext(), "Masculino", Toast.LENGTH_SHORT).show();
                    rbf.setChecked(false);
                    sr.setVisibility(View.VISIBLE);
                    sr1.setVisibility(View.VISIBLE);
                    sra.setVisibility(View.INVISIBLE);
                    sra1.setVisibility(View.INVISIBLE);
                    sra2.setVisibility(View.INVISIBLE);
                } else if(checkedId == R.id.rbf) {
                    Toast.makeText(getApplicationContext(), "Femenino", Toast.LENGTH_SHORT).show();
                    rbm.setChecked(false);
                    sr.setVisibility(View.INVISIBLE);
                    sr1.setVisibility(View.INVISIBLE);
                    sra.setVisibility(View.VISIBLE);
                    sra1.setVisibility(View.VISIBLE);
                    sra2.setVisibility(View.VISIBLE);

                } else{

                }
            }

        });

    }
}
