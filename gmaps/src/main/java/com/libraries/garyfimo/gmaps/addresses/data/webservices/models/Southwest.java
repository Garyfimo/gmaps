package com.libraries.garyfimo.gmaps.addresses.data.webservices.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gfiguerola on 7/6/17.
 */

public class Southwest {

    @SerializedName("lat")
    private Double mLatitude;
    @SerializedName("lng")
    private Double mLongitude;

    public Double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(Double latitude) {
        mLatitude = latitude;
    }

    public Double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(Double longitude) {
        mLongitude = longitude;
    }
}
