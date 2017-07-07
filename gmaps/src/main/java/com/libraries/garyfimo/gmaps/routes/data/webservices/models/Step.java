package com.libraries.garyfimo.gmaps.routes.data.webservices.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gfiguerola on 6/28/17.
 */

public class Step {

    @SerializedName("distance")
    Distance mDistance;
    @SerializedName("duration")
    Duration mDuration;
    @SerializedName("start_location")
    StartLocation mStartLocation;
    @SerializedName("end_location")
    EndLocation mEndLocation;
    @SerializedName("polyline")
    PolyLine mPolyLine;

    public Distance getDistance() {
        return mDistance;
    }

    public void setDistance(Distance distance) {
        mDistance = distance;
    }

    public Duration getDuration() {
        return mDuration;
    }

    public void setDuration(Duration duration) {
        mDuration = duration;
    }

    public StartLocation getStartLocation() {
        return mStartLocation;
    }

    public void setStartLocation(StartLocation startLocation) {
        mStartLocation = startLocation;
    }

    public EndLocation getEndLocation() {
        return mEndLocation;
    }

    public void setEndLocation(EndLocation endLocation) {
        mEndLocation = endLocation;
    }

    public PolyLine getPolyLine() {
        return mPolyLine;
    }

    public void setPolyLine(PolyLine polyLine) {
        mPolyLine = polyLine;
    }
}
