package com.libraries.garyfimo.gmaps.routes.domain;

import com.google.android.gms.maps.model.LatLng;
import com.libraries.garyfimo.gmaps.routes.data.webservices.RouteWebService;
import com.libraries.garyfimo.gmaps.routes.data.webservices.WSRouteListener;
import com.libraries.garyfimo.gmaps.routes.data.webservices.models.response.RouteResponse;
import com.libraries.garyfimo.gmaps.routes.domain.listener.RouteInteractorListener;
import com.libraries.garyfimo.gmaps.routes.utils.Configuration;

import java.util.List;

/**
 * Created by gfiguerola on 6/28/17.
 */

public class RouteInteractorImpl implements RouteInteractor, WSRouteListener {

    RouteInteractorListener mListener;

    public RouteInteractorImpl(RouteInteractorListener listener) {
        mListener = listener;
    }

    @Override
    public void requestRoutes(LatLng origin, LatLng destination, Configuration configuration) {
        RouteWebService webService = new RouteWebService(this);
        webService.doRequest(origin, destination, configuration);
    }

    @Override
    public void requestRoutes(LatLng origin, LatLng destination, Configuration configuration, List<LatLng> wayPoints) {
        RouteWebService webService = new RouteWebService(this);
        webService.doRequest(origin, destination, configuration, wayPoints);
    }

    @Override
    public void onRequestSuccess(RouteResponse response) {
        mListener.onRequestRouteSuccess(response);
    }
}
