package com.example.fernando.parcial3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Button boton;
    // Will show the string "data" that holds the results
    TextView results;
    // URL of object to be parsed
    String JsonURL = "https://api.myjson.com/bins/v7c97";
    // This string will hold the results
    String data = "";
    // Defining the Volley request queue that handles the URL request concurrently
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Creates the Volley request queue
        requestQueue = Volley.newRequestQueue(this);

        // Casts results into the TextView found within the main layout XML with id jsonData
        results = (TextView) findViewById(R.id.jsonData);
        boton = (Button) findViewById(R.id.boton);
        final ImageView image =(ImageView)findViewById(R.id.imagen);

        // Creating the JsonObjectRequest class called obreq, passing required parameters:
        //GET is used to fetch data from the server, JsonURL is the URL to be fetched from.
        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.GET, JsonURL,
                // The third parameter Listener overrides the method onResponse() and passes
                //JSONObject as a parameter
                new Response.Listener<JSONObject>() {

                    // Takes the response from the JSON request
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject obj = response.getJSONObject("datos");
                            // Retrieves the string labeled "colorName" and "description" from
                            //the response JSON Object
                            //and converts them into javascript objects

                            String nombre = obj.getString("nombre");
                            String ap = obj.getString("ap");
                            String am = obj.getString("am");
                            String dir = obj.getString("direccion");
                            final String coord = obj.getString("latd");
                            String tip = obj.getString("tip");
                            String foto = obj.getString("foto");





                            byte[] decodedString = Base64.decode(foto, Base64.DEFAULT);

                            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                            image.setImageBitmap(decodedByte);




                            // Adds strings from object to the "data" string
                            data += "Nombre: " + nombre + "\nApellido Paterno: " + ap
                            + "\nApellido Materno: " + am + "\nDireccion: " + dir + "\nCoordenadas: " + coord +
                            "\nTipo de sangre: " + tip +"\nFoto:";

                            // Adds the data string to the TextView "results"
                            results.setText(data);

                            boton.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    Intent myIntent = new Intent(MainActivity.this, MapsActivity.class);
                                    myIntent.putExtra("TEXTO", coord);
                                    MainActivity.this.startActivity(myIntent);



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
        // Adds the JSON object request "obreq" to the request queue
        requestQueue.add(obreq);



    }
}