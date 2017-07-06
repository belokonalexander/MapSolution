package com.example.alexander.mapsolution;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.alexander.mapsolution.Adapter.NavigationItem;
import com.example.alexander.mapsolution.Utils.LogHelper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.internal.Utils;

public class MainActivity extends AppCompatActivity implements IMapNavigation {


    SupportMapFragment mapFragment;
    GoogleMap googleMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(googleMap1 -> MainActivity.this.googleMap = googleMap1);
    }

    @Override
    public void navigate(NavigationItem navigationItem) {
            LatLng pos = new LatLng(navigationItem.getLat(), navigationItem.getLng());
            googleMap.clear();
            googleMap.addMarker(new MarkerOptions().position(pos).title(navigationItem.getName()));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
    }
}
