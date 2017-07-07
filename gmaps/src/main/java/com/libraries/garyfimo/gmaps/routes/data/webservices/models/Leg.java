package com.libraries.garyfimo.gmaps.routes.data.webservices.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gfiguerola on 6/28/17.
 */

public class Leg {


    @SerializedName("steps")
    private List<Step> mSteps;

    public List<Step> getSteps() {
        return mSteps;
    }

    public void setSteps(List<Step> steps) {
        mSteps = steps;
    }
}
