package com.example.fernando.finalmoviles1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerEsp, spinnerHosp;
    private ListView lista;
    private String[] arrayEsp, arrayHosp,arraySpinE, arraySpinH;
    String JsonURL = "";

    //ArrayList<String> list = new ArrayList<String>();
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);
        spinnerEsp = (Spinner) findViewById(R.id.spinnerEsp);
        spinnerHosp = (Spinner) findViewById(R.id.spinnerHosp);
        requestQueue = Volley.newRequestQueue(this);

        this.arraySpinE = new String[] {
                "","Otorrinolaringologo", "Pediatra", "Cardiologia"
        };
        ArrayAdapter<String> adapterEsp = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinE);
        spinnerEsp.setAdapter(adapterEsp);
        this.arraySpinH = new String[] {
                "","Angeles", "ChristusMuguersa", "StarMedica"
        };
        ArrayAdapter<String> adapterHosp = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinH);
        spinnerHosp.setAdapter(adapterHosp);

        spinnerEsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                lista.setVisibility(View.VISIBLE);
                String especialidad = (String) spinnerEsp.getSelectedItem();
                JsonURL="http://fernandolopez1.esy.es/slimapi/public/query10/"+especialidad;


                // Creating the JsonArrayRequest class called arrayreq, passing the required parameters
                //JsonURL is the URL to be fetched from
                JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.GET, JsonURL,
                        // The second parameter Listener overrides the method onResponse() and passes
                        //JSONArray as a parameter
                        new Response.Listener<JSONObject>() {

                            // Takes the response from the JSON request
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    //Toast.makeText(getApplicationContext(), "Conecta", Toast.LENGTH_SHORT).show();

                                        String med = response.getString("Medico");
                                        String hos = response.getString("Hospital");
                                        String esp = response.getString("Especialidad");


                                        String juntar= "Medico: "+med+"\nHospital: "+hos+"\nEspecialidad: "+esp;
                                        //list.add(juntar);
                                    arrayEsp= new String[]{juntar};





                                    ArrayAdapter<String> adaptador=new ArrayAdapter<String>(lista.getContext(),android.R.layout.simple_list_item_1,arrayEsp);
                                    lista.setAdapter(adaptador);


                                }
                                // Try and catch are included to handle any errors due to JSON
                                catch (JSONException e) {
                                    // If an error occurs, this prints the error to the log
                                    e.printStackTrace();
                                }
                            }
                        },
                        // The final parameter overrides the method onErrorResponse() and passes VolleyError
                        //as a parameter
                        new Response.ErrorListener() {
                            @Override
                            // Handles errors that occur due to Volley
                            public void onErrorResponse(VolleyError error) {
                                Log.e("Volley", "Error");
                            }
                        }
                );
                // Adds the JSON array request "arrayreq" to the request queue
                requestQueue.add(obreq);



            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerHosp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                lista.setVisibility(View.VISIBLE);
                String hospital = (String) spinnerHosp.getSelectedItem();
                JsonURL="http://fernandolopez1.esy.es/slimapi/public/query11/"+hospital;
                //Toast.makeText(getApplicationContext(), JsonURL, Toast.LENGTH_SHORT).show();

                // Creating the JsonArrayRequest class called arrayreq, passing the required parameters
                //JsonURL is the URL to be fetched from
                JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.GET, JsonURL,
                        // The second parameter Listener overrides the method onResponse() and passes
                        //JSONArray as a parameter
                        new Response.Listener<JSONObject>() {

                            // Takes the response from the JSON request
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    //Toast.makeText(getApplicationContext(), "Conecta", Toast.LENGTH_SHORT).show();

                                    String med = response.getString("Medico");
                                    final String hos = response.getString("Hospital");
                                    String esp = response.getString("Especialidad");


                                    String juntar= "Medico: "+med+"\nHospital: "+hos+"\nEspecialidad: "+esp;
                                    //list.add(juntar);
                                    arrayHosp= new String[]{juntar};





                                    ArrayAdapter<String> adaptador=new ArrayAdapter<String>(lista.getContext(),android.R.layout.simple_list_item_1,arrayHosp);
                                    lista.setAdapter(adaptador);
                                    lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                    {

                                        @Override
                                        public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                                            Intent intent = new Intent(getBaseContext(), MapsActivity.class);
                                            intent.putExtra("TEXTO", hos);
                                            startActivity(intent);
                                            finish();





                                        }
                                    });



                                }
                                // Try and catch are included to handle any errors due to JSON
                                catch (JSONException e) {
                                    // If an error occurs, this prints the error to the log
                                    e.printStackTrace();
                                }
                            }
                        },
                        // The final parameter overrides the method onErrorResponse() and passes VolleyError
                        //as a parameter
                        new Response.ErrorListener() {
                            @Override
                            // Handles errors that occur due to Volley
                            public void onErrorResponse(VolleyError error) {
                                Log.e("Volley", "Error");
                            }
                        }
                );
                // Adds the JSON array request "arrayreq" to the request queue
                requestQueue.add(obreq);



            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}
