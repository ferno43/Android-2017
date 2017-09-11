package com.example.fernando.marcador;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button s1,s2,r1,r2;
    private TextView m1,m2;
    private SensorManager mSensorMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = (Button) findViewById(R.id.s1);
        s2 = (Button) findViewById(R.id.s2);
        r1 = (Button) findViewById(R.id.r1);
        r2 = (Button) findViewById(R.id.r2);
        m1 = (TextView) findViewById(R.id.m1);
        m2 = (TextView) findViewById(R.id.m2);
        ShakeListener mShaker = new ShakeListener(this);


        s1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int a=Integer.parseInt(m1.getText().toString());
                int total=a+1;
                m1.setText(String.valueOf(total));
            }
        });

        r1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int a=Integer.parseInt(m1.getText().toString());
                int total=a-1;
                if(total<0){
                    m1.setText(String.valueOf("0"));
                }else {
                    m1.setText(String.valueOf(total));
                }
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int a=Integer.parseInt(m2.getText().toString());
                int total=a+1;
                m2.setText(String.valueOf(total));
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int a=Integer.parseInt(m2.getText().toString());
                int total=a-1;
                if(total<0){
                    m2.setText(String.valueOf("0"));
                }else {
                    m2.setText(String.valueOf(total));
                }

            }
        });

        mShaker.setOnShakeListener(new ShakeListener.OnShakeListener () {
            public void onShake() {
                m1.setText("0");
                m2.setText("0");

            }
        });



    }
}
