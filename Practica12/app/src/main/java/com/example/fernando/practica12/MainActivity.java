package com.example.fernando.practica12;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button imagen, cerrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen = (Button) findViewById(R.id.imagen);
        cerrar = (Button) findViewById(R.id.cerrar);

        cerrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createRadioListDialog();

            }
        });

        imagen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Dialog settingsDialog = new Dialog(v.getContext());
                settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                settingsDialog.setContentView(getLayoutInflater().inflate(R.layout.image_layout, null));
                settingsDialog.setCanceledOnTouchOutside(true);
                settingsDialog.show();

            }
        });




    }

    public void createRadioListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cerrar app")
                .setMessage("Seguro que quiere cerrar esta app?")
                .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);

                    }
                })
                .setNegativeButton("No cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }
}
