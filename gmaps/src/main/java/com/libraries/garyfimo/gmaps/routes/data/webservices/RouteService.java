package com.libraries.garyfimo.gmaps.routes.data.webservices;


import com.libraries.garyfimo.gmaps.routes.data.webservices.models.response.RouteResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by gfiguerola on 6/28/17.
 */

public interface RouteService {

    @GET("directions/json?")
    public Call<RouteResponse> requestRoutes(
            @QueryMap Map<String, String> params
    );
}
