package com.libraries.garyfimo.gmaps.routes.data.webservices.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gfiguerola on 6/28/17.
 */

public class StartLocation {

    @SerializedName("lat")
    private float mLatitude;
    @SerializedName("lng")
    private float mLongitude;


    public float getLatitude() {
        return mLatitude;
    }

    public void setLatitude(float latitude) {
        mLatitude = latitude;
    }

    public float getLongitude() {
        return mLongitude;
    }

    public void setLongitude(float longitude) {
        mLongitude = longitude;
    }
}
