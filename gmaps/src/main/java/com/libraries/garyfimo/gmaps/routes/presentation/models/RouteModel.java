package com.libraries.garyfimo.gmaps.routes.presentation.models;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by gfiguerola on 6/30/17.
 */

public class RouteModel {

    private int mColor;
    private List<LatLng> mDirections;

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    public List<LatLng> getDirections() {
        return mDirections;
    }

    public void setDirections(List<LatLng> directions) {
        mDirections = directions;
    }
}
