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

import java.util.ArrayList;
import java.util.List;

public class WaypointsExampleActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waypoints_example);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng origin = new LatLng(-12.1220124, -77.0329625);
        LatLng destination = new LatLng(-12.1227398, -77.0354911);
        mMap.addMarker(new MarkerOptions().position(origin).title("Origin"));
        mMap.addMarker(new MarkerOptions().position(destination).title("Destination"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(origin));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(origin, 16.0f));
        Configuration cgf = new Configuration.Builder()
//                .setColor(R.color.emerald) // change direction's line color, if you are not set color, there are random colors
                .setTravelMode(TravelMode.walking) // change the way of travel : DRIVING, WALKING, BICYCLING
                .setWidth(7) // change direction's line width
                .setOptimize(true)
                .build();
        GRoutesMaps.getInstance(this, cgf).draw(origin, destination, getWayPoints(), mMap);
    }


    private List<LatLng> getWayPoints() {
        List<LatLng> resultList = new ArrayList<>();
        LatLng wayPoint1 = new LatLng(-12.1234244, -77.0306032);
        LatLng wayPoint2 = new LatLng(-12.1249585, -77.0382244);
        LatLng wayPoint3 = new LatLng(-12.1264876, -77.0299837);
        mMap.addMarker(new MarkerOptions().position(wayPoint1).title("Way point 1"));
        mMap.addMarker(new MarkerOptions().position(wayPoint2).title("Way point 2"));
        mMap.addMarker(new MarkerOptions().position(wayPoint3).title("Way point 3"));
        resultList.add(wayPoint1);
        resultList.add(wayPoint2);
        resultList.add(wayPoint3);
        return resultList;
    }
}
