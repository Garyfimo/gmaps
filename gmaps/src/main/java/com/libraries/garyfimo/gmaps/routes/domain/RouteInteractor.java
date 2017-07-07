package com.libraries.garyfimo.gmaps.routes.domain;

import com.google.android.gms.maps.model.LatLng;
import com.libraries.garyfimo.gmaps.routes.utils.Configuration;

import java.util.List;

/**
 * Created by gfiguerola on 6/28/17.
 */

public interface RouteInteractor {

    void requestRoutes(LatLng origin, LatLng destination, Configuration configuration);

    void requestRoutes(LatLng origin, LatLng destination, Configuration configuration, List<LatLng> wayPoints);
}
