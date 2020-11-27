package com.example.mapas2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivityTipos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
        private Button btn_Hibrido, btn_Normal, btn_Satelital, btn_Terreno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_tipos);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn_Hibrido=(Button)findViewById(R.id.btnHibrido);
        btn_Normal=(Button)findViewById(R.id.btnNormal);
        btn_Satelital=(Button)findViewById(R.id.btnSatelital);
        btn_Terreno=(Button)findViewById(R.id.btnTerreno);
    }


    public void cambiarTerreno(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }

    public void cambiarNormal(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void cambiarSatelital(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void cambiarHibrido(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}