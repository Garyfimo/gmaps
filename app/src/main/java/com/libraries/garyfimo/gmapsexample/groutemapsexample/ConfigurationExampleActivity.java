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
import com.libraries.garyfimo.gmaps.routes.utils.Configuration;
import com.libraries.garyfimo.gmaps.routes.utils.TravelMode;
import com.libraries.garyfimo.gmapsexample.R;

public class ConfigurationExampleActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration_example);
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

        LatLng origin = new LatLng(-12.1220124, -77.0329625);
        LatLng destination = new LatLng(-12.1223398, -77.0314911);
        mMap.addMarker(new MarkerOptions().position(origin).title("Origin"));
        mMap.addMarker(new MarkerOptions().position(destination).title("Destination"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(origin));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(origin, 16.0f));
        Configuration cgf = new Configuration.Builder()
                .setColor(R.color.emerald) // change direction's line color
                .setTravelMode(TravelMode.driving) // change the way of travel : DRIVING, WALKING, BICYCLING
                .setWidth(21) // change direction's line width
                .build();
        GRoutesMaps.getInstance(this, cgf).draw(origin, destination, mMap);
    }
}
