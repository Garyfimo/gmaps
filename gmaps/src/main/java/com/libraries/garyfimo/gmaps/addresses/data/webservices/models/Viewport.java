package com.libraries.garyfimo.gmaps.addresses.data.webservices.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gfiguerola on 7/6/17.
 */

public class Viewport {

    @SerializedName("northeast")
    private Northeast mNortheast;
    @SerializedName("southwest")
    private Southwest mSouthwest;

    public Northeast getNortheast() {
        return mNortheast;
    }

    public void setNortheast(Northeast northeast) {
        mNortheast = northeast;
    }

    public Southwest getSouthwest() {
        return mSouthwest;
    }

    public void setSouthwest(Southwest southwest) {
        mSouthwest = southwest;
    }
}
