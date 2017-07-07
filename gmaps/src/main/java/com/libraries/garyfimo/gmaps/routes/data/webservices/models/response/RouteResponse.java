package com.libraries.garyfimo.gmaps.routes.data.webservices.models.response;

import com.google.gson.annotations.SerializedName;
import com.libraries.garyfimo.gmaps.routes.data.webservices.models.Route;

import java.util.List;

/**
 * Created by gfiguerola on 6/28/17.
 */

public class RouteResponse {


    @SerializedName("routes")
    private List<Route> mRoutes;

    public List<Route> getRoutes() {
        return mRoutes;
    }

    public void setRoutes(List<Route> routes) {
        mRoutes = routes;
    }
}
