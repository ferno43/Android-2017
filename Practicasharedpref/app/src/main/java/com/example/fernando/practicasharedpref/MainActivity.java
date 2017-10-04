package com.example.fernando.practicasharedpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences = null;
    SharedPreferences.Editor editor;
    private Button boton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button) findViewById(R.id.boton);


        sharedPreferences = getSharedPreferences("com.myAppName", MODE_PRIVATE);
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Segunda.class);
                myIntent.putExtra("key", "calla"); //Optional parameters
                MainActivity.this.startActivity(myIntent);


            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (sharedPreferences.getBoolean("firstRun", true)) {
            //You can perform anything over here. This will call only first time
            //putextra
            Toast.makeText(getApplicationContext(), "Primer uso", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(MainActivity.this, Paseo.class);
            MainActivity.this.startActivity(myIntent);
            editor = sharedPreferences.edit();
            editor.putBoolean("firstRun", false);
            editor.commit();

        }else{
            Toast.makeText(getApplicationContext(), "No es primera vez", Toast.LENGTH_SHORT).show();
        }
    }
}

