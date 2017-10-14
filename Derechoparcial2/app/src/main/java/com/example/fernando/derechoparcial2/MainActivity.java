package com.example.fernando.derechoparcial2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    private ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);

        String[] companeros={"Escanear codigo QR","Pasar datos entre actividades","Dialogos","Grid","Salir"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(lista.getContext(),android.R.layout.simple_list_item_1,companeros);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {

                String selectedFromList =(String) (lista.getItemAtPosition(myItemInt));


                switch (selectedFromList){
                    case "Escanear codigo QR":
                        Intent myIntent = new Intent(MainActivity.this, qr.class);
                        MainActivity.this.startActivity(myIntent);
                        finish();



                        break;
                    case "Pasar datos entre actividades":
                        Intent myIntent1 = new Intent(MainActivity.this, Pasar.class);
                        MainActivity.this.startActivity(myIntent1);
                        finish();



                        break;
                    case "Dialogos":
                        Intent myIntent2 = new Intent(MainActivity.this, Dialog.class);
                        MainActivity.this.startActivity(myIntent2);
                        finish();




                        break;
                    case "Grid":
                        Intent myIntent3 = new Intent(MainActivity.this, principal.class);
                        MainActivity.this.startActivity(myIntent3);
                        finish();


                        break;
                    case "Salir":
                        createRadioListDialog();


                        break;
                }
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
