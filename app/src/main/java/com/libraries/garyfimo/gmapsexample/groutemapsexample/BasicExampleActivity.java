package com.libraries.garyfimo.gmapsexample.groutemapsexample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.libraries.garyfimo.gmaps.routes.presentation.views.GRoutesMaps;
import com.libraries.garyfimo.gmapsexample.R;

public class BasicExampleActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_example);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng origin = new LatLng(-12.1220124, -77.0329625);
        LatLng destination = new LatLng(-12.1223398, -77.0314911);
        mMap.addMarker(new MarkerOptions().position(origin).title("Origin"));
        mMap.addMarker(new MarkerOptions().position(destination).title("Destination"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(origin));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(origin, 16.0f));
        // If you do not change the configuration
        // it takes
        // color        : emerald (#2ecc71)
        // width        : 7
        // travel mode  : WALKING
        GRoutesMaps.getInstance(this).draw(origin, destination, mMap);
    }
}
