package com.example.fernando.finalmoviles1;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        String s = getIntent().getStringExtra("TEXTO");
        regresar = (Button) findViewById(R.id.boton);
        Double la,lo;
        if(s.equals("Angeles")){
            la=28.6301993;
            lo=-106.12435519999997;
        }else if(s.equals("StarMedica")){
            la=28.6640225;
            lo=-106.13056119999999;
        }else{
            la=28.6316118;
            lo=-106.07561399999997;
        }
        LatLng hospital = new LatLng(la,lo);
        float zoomLevel = 16.0f;
        mMap.addMarker(new MarkerOptions().position(hospital).title(s));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(hospital, zoomLevel));

        regresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MapsActivity.this, MainActivity.class);
                MapsActivity.this.startActivity(myIntent);
                finish();



            }
        });
    }
}
