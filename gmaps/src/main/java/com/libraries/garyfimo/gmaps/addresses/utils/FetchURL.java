package com.libraries.garyfimo.gmaps.addresses.utils;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gfiguerola on 7/6/17.
 */

public class FetchURL {

    public static Map<String, String> getAddressMapParams(LatLng latLng) {
        Map<String, String> params = new HashMap<>();
        params.put("latlng", String.format("%s,%s", latLng.latitude, latLng.longitude));
        return params;
    }
}
