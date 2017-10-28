package com.example.fernando.practicamapa;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;

import static com.example.fernando.practicamapa.R.id.map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
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

        // Add a marker in Sydney and move the camera
         //final LatLng sydney = new LatLng(-34, 151);
        final LatLng sydney = new LatLng(-33.8688197, 151.20929550000005);
        //
        final LatLng ny = new LatLng(40.7127753, -74.0059728);
        Marker marny = mMap.addMarker(new MarkerOptions()
                .position(ny)
                .title("New York"));




        final LatLng vyc = new LatLng(49.2827291, -123.12073750000002);
        Marker marvyc = mMap.addMarker(new MarkerOptions()
                .position(vyc)
                .title("Vancouver"));


        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //float zoomLevel = 16.0f; //This goes up to 21
        //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));
        int height = 100;
        int width = 100;
        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.icono);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);

        /*MarkerOptions marsy = new MarkerOptions().position(sydney).title("Marker in Sydney");
        marsy.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        googleMap.addMarker(marsy);*/
        Marker syd = mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
                .position(sydney)
                .title("Sydney"));








        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker m) {
                float zoomLevel = 16.0f; //This goes up to 21
                String valor =  m.getTitle();
                if(valor.equals("New York")){
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ny, zoomLevel));

                }else if(valor.equals("Vancouver")){
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(vyc, zoomLevel));
                }else if(valor.equals("Sydney")){
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));
                }
                return true;

            }
        });
    }


}
