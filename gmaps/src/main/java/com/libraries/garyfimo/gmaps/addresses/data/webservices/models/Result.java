package com.libraries.garyfimo.gmaps.addresses.data.webservices.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gfiguerola on 7/6/17.
 */

public class Result {

    @SerializedName("address_components")
    private List<AddressComponent> mAddressComponents;
    @SerializedName("formatted_address")
    private String mFormattedAddress;
    @SerializedName("geometry")
    private Geometry mGeometry;
    @SerializedName("place_id")
    private String mPlaceId;
    @SerializedName("types")
    private List<String> mTypes;

    public List<AddressComponent> getAddressComponents() {
        return mAddressComponents;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        mAddressComponents = addressComponents;
    }

    public String getFormattedAddress() {
        return mFormattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        mFormattedAddress = formattedAddress;
    }

    public Geometry getGeometry() {
        return mGeometry;
    }

    public void setGeometry(Geometry geometry) {
        mGeometry = geometry;
    }

    public String getPlaceId() {
        return mPlaceId;
    }

    public void setPlaceId(String placeId) {
        mPlaceId = placeId;
    }

    public List<String> getTypes() {
        return mTypes;
    }

    public void setTypes(List<String> types) {
        mTypes = types;
    }
}
