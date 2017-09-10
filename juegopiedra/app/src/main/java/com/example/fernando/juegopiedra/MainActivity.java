package com.example.fernando.juegopiedra;

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
import android.widget.ImageView;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private ImageView piedra;
    private ImageView papel;
    private ImageView tijera;
    private SensorManager mSensorMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        piedra = (ImageView) findViewById(R.id.piedra);
        papel = (ImageView) findViewById(R.id.papel);
        tijera = (ImageView) findViewById(R.id.tijera);
        ShakeListener mShaker = new ShakeListener(this);

        mShaker.setOnShakeListener(new ShakeListener.OnShakeListener () {
            public void onShake() {

                int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
                if (randomNum == 1) {
                    piedra.setVisibility(View.VISIBLE);
                    tijera.setVisibility(View.INVISIBLE);
                    papel.setVisibility(View.INVISIBLE);

                } else {
                    if (randomNum == 2) {
                        piedra.setVisibility(View.INVISIBLE);
                        tijera.setVisibility(View.VISIBLE);
                        papel.setVisibility(View.INVISIBLE);

                    } else {
                        piedra.setVisibility(View.INVISIBLE);
                        tijera.setVisibility(View.INVISIBLE);
                        papel.setVisibility(View.VISIBLE);

                    }
                }
            }


    });
    }
}
