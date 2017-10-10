package com.example.fernando.listaejemplo;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);

        String[] companeros={"Flaca","Bryan","Chuy","Victor","Ian","Yepiz","Jacob"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(lista.getContext(),android.R.layout.simple_list_item_1,companeros);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {

                String selectedFromList =(String) (lista.getItemAtPosition(myItemInt));

                switch (selectedFromList){
                    case "Flaca":
                        Toast.makeText(getApplicationContext(), "Acosadora", Toast.LENGTH_SHORT).show();

                        break;
                    case "Bryan":
                        Toast.makeText(getApplicationContext(), "Rockstar de Monterrey", Toast.LENGTH_SHORT).show();

                        break;
                    case "Chuy":
                        Toast.makeText(getApplicationContext(), "Chuyditas", Toast.LENGTH_SHORT).show();

                        break;
                    case "Ian":
                        Toast.makeText(getApplicationContext(), "Lord Vladi", Toast.LENGTH_SHORT).show();

                        break;
                    case "Yepiz":
                        Toast.makeText(getApplicationContext(), "Rompe cuellos", Toast.LENGTH_SHORT).show();

                        break;
                    case "Jacob":
                        Toast.makeText(getApplicationContext(), "Barbas", Toast.LENGTH_SHORT).show();

                        break;
                    case "Victor":
                        Toast.makeText(getApplicationContext(), "Videos", Toast.LENGTH_SHORT).show();

                        break;
                }
            }
        });
    }


}
