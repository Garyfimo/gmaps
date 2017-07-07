package com.libraries.garyfimo.gmaps.routes.data.webservices.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gfiguerola on 6/28/17.
 */

public class Route {

    @SerializedName("legs")
    private List<Leg> mLegs;

    public List<Leg> getLegs() {
        return mLegs;
    }

    public void setLegs(List<Leg> legs) {
        mLegs = legs;
    }
}
