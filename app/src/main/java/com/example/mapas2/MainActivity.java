package com.example.mapas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTipos, btnUbicacion, btnSitios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSitios=(Button)findViewById(R.id.btnSitiosT);
        btnSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });

        btnTipos=(Button)findViewById(R.id.btnTiposM);
        btnTipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent (getApplicationContext(),MapsActivityTipos.class);
                startActivity(intento);
            }
        });

        btnUbicacion=(Button)findViewById(R.id.btnU);
        btnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentos = new Intent (getApplicationContext(),MapsActivityUbicacion.class);
                startActivity(intentos);
            }
        });
    }
}