package com.libraries.garyfimo.gmaps.routes.data.webservices.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gfiguerola on 6/28/17.
 */

public class Distance {

    @SerializedName("text")
    private String mText;
    @SerializedName("value")
    private int mValue;

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getValue() {
        return mValue;
    }

    public void setValue(int value) {
        mValue = value;
    }
}
