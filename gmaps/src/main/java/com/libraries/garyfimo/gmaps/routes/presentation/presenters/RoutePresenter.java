package com.libraries.garyfimo.gmaps.routes.presentation.presenters;

import com.google.android.gms.maps.model.LatLng;
import com.libraries.garyfimo.gmaps.routes.utils.Configuration;

import java.util.List;

/**
 * Created by gfiguerola on 6/30/17.
 */

public interface RoutePresenter {

    void getRoutes(LatLng origin, LatLng destination, Configuration configuration);

    void getRoutes(LatLng origin, LatLng destination, Configuration configuration, List<LatLng> wayPoints);
}
