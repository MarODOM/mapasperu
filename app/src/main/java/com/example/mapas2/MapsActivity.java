package com.example.mapas2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker markerPrueba;

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

        LatLng MachuPicchu = new LatLng( -13.1641, -72.5449);
        mMap.addMarker(new MarkerOptions().position(MachuPicchu).title("MachuPicchu")
                .snippet("La mejor mmaravilla del mundo por ser la mas majestuosa")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.uno)));

        LatLng Choquequirao = new LatLng( -13.3926,-72.8736);
        mMap.addMarker(new MarkerOptions().position(Choquequirao).title("Fortaleza de Choquequirao")
                .snippet("Fortaleza impresionante y hermosa")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cuatro)));

        LatLng Nazca = new LatLng(-14.7601, -75.0819);
        markerPrueba= googleMap.addMarker(new MarkerOptions().position(Nazca).title("Lineas de Nazca")
                .snippet("Monumento Arqueologico de Nazca en la arena")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng Kuelap = new LatLng(-6.4192, -77.9236);
        mMap.addMarker(new MarkerOptions().position(Kuelap).title("Fortaleza deKuelap")
                .snippet("Hermoso lugar escondido entre la selva, calida e impresionante")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hermosillo)));


        LatLng Caral = new LatLng(-10.8932, -77.5213);
        mMap.addMarker(new MarkerOptions().position(Caral).draggable(true).title("Ciudad de Caral")
                .snippet("Hermoso lugar escondido entre la selva, calida e impresionante")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MachuPicchu,6));
        googleMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.equals(markerPrueba))
        {
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);

            Toast.makeText(this, lat + " , " +lng,Toast.LENGTH_LONG ).show();;
        }
        return false;
    }
}