package com.libraries.garyfimo.gmaps.routes.domain.listener;


import com.libraries.garyfimo.gmaps.routes.data.webservices.models.response.RouteResponse;

/**
 * Created by gfiguerola on 6/28/17.
 */

public interface RouteInteractorListener {

    void onRequestRouteSuccess(RouteResponse response);
}
