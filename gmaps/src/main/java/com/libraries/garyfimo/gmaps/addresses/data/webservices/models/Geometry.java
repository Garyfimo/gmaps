package com.libraries.garyfimo.gmaps.addresses.data.webservices.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gfiguerola on 7/6/17.
 */

public class Geometry {

    @SerializedName("bounds")
    private Bound mBound;
    @SerializedName("location")
    private Location mLocation;
    @SerializedName("location_type")
    private String mLocationType;
    @SerializedName("viewport")
    private Viewport mViewport;

    public Bound getBound() {
        return mBound;
    }

    public void setBound(Bound bound) {
        mBound = bound;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public String getLocationType() {
        return mLocationType;
    }

    public void setLocationType(String locationType) {
        mLocationType = locationType;
    }

    public Viewport getViewport() {
        return mViewport;
    }

    public void setViewport(Viewport viewport) {
        mViewport = viewport;
    }
}
