package com.example.fernando.practicalista;

import android.app.Activity;
import android.content.Intent;
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
                Intent myIntent = new Intent(MainActivity.this, Segunda.class);

                switch (selectedFromList){
                    case "Flaca":

                        myIntent.putExtra("key", "Acosadora"); //Optional parameters
                        MainActivity.this.startActivity(myIntent);

                        break;
                    case "Bryan":
                        myIntent.putExtra("key", "Rockstar de Monterrey"); //Optional parameters
                        MainActivity.this.startActivity(myIntent);

                        break;
                    case "Chuy":
                        myIntent.putExtra("key", "Chuyditas"); //Optional parameters
                        MainActivity.this.startActivity(myIntent);

                        break;
                    case "Ian":
                        myIntent.putExtra("key", "Lord Vladi"); //Optional parameters
                        MainActivity.this.startActivity(myIntent);

                        break;
                    case "Yepiz":
                        myIntent.putExtra("key", "Rompecuellos"); //Optional parameters
                        MainActivity.this.startActivity(myIntent);

                        break;
                    case "Jacob":
                        myIntent.putExtra("key", "Barbas"); //Optional parameters
                        MainActivity.this.startActivity(myIntent);

                        break;
                    case "Victor":
                        myIntent.putExtra("key", "Carpeta de videos"); //Optional parameters
                        MainActivity.this.startActivity(myIntent);

                        break;
                }
            }
        });
    }


}
