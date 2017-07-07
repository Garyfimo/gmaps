package com.libraries.garyfimo.gmaps.addresses.data.webservices;


import com.libraries.garyfimo.gmaps.addresses.data.webservices.models.response.AddressResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by gfiguerola on 7/6/17.
 */

public interface AddressService {

    @GET("geocode/json?")
    public Call<AddressResponse> requestAddress(
            @QueryMap Map<String, String> params
    );
}
