package com.libraries.garyfimo.gmaps.routes.data.webservices.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gfiguerola on 6/28/17.
 */

public class PolyLine {

    @SerializedName("points")
    private String mPoints;

    public String getPoints() {
        return mPoints;
    }

    public void setPoints(String points) {
        mPoints = points;
    }
}
