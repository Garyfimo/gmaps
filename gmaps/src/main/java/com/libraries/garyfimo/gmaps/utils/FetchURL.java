package com.libraries.garyfimo.gmaps.utils;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gfiguerola on 6/30/17.
 */

public class FetchURL {

    public static String getWayPointsString(List<LatLng> wayPoints) {
        StringBuilder sb = new StringBuilder();
        for (LatLng latLng : wayPoints) {
            sb.append(String.format("%s,%s|", latLng.latitude, latLng.longitude));
        }
        return sb.length() > 0 ? sb.deleteCharAt(sb.length() - 1).
                toString() : sb.toString();
    }

    public static Map<String, String> getRouteMapParams(LatLng origin, LatLng destination, String mode) {
        Map<String, String> params = new HashMap<>();
        params.put("origin", String.format("%s,%s", origin.latitude, origin.longitude));
        params.put("destination", String.format("%s,%s", destination.latitude, destination.longitude));
        params.put("mode", mode);

        return params;
    }

    public static Map<String, String> getRouteMapParams(LatLng origin, LatLng destination, String mode, List<LatLng> wayPoints, boolean optimize) {
        Map<String, String> params = getRouteMapParams(origin, destination, mode);
        params.put("waypoints", getWayPointsString(wayPoints));
        params.put("optimize", String.valueOf(optimize));
        return params;
    }
}
