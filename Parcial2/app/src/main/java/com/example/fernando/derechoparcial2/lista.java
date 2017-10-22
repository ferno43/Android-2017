package com.example.fernando.derechoparcial2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class lista extends Activity {
    private ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        lista = (ListView) findViewById(R.id.lista);


        String[] companeros={"Leer placa","Vehiculos afiliados","Acerca de","Cerrar sesion"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(lista.getContext(),android.R.layout.simple_list_item_1,companeros);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {

                String selectedFromList =(String) (lista.getItemAtPosition(myItemInt));


                switch (selectedFromList){
                    case "Leer placa":
                        Intent leerqr = new Intent(lista.this, qr.class);
                        lista.this.startActivity(leerqr);
                        finish();




                        break;
                    case "Vehiculos afiliados":
                        Intent vehiculos = new Intent(lista.this, principal.class);
                        lista.this.startActivity(vehiculos);
                        finish();






                        break;
                    case "Acerca de":
                        createRadioListDialog();






                        break;
                    case "Cerrar sesion":
                        Intent volverlista = new Intent(lista.this, login.class);
                        lista.this.startActivity(volverlista);
                        finish();

                        break;
                }
            }
        });

    }
    public void createRadioListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acerca de:")
                .setMessage("Fernando López Ramos"+"\n3286")
                .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent volverlogin = new Intent(lista.this, login.class);
                        lista.this.startActivity(volverlogin);
                        finish();


                    }
                })
                .setNegativeButton("Web", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uri uriUrl = Uri.parse("https://github.com/ferno43/Android-2017");
                        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                        startActivity(launchBrowser);

                    }
                });
        builder.show();
    }


}
