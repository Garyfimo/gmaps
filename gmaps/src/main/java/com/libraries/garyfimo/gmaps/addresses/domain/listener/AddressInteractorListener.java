package com.libraries.garyfimo.gmaps.addresses.domain.listener;


import com.libraries.garyfimo.gmaps.addresses.data.webservices.models.response.AddressResponse;

/**
 * Created by gfiguerola on 7/6/17.
 */

public interface AddressInteractorListener {

    void onRequestAddressSuccess(AddressResponse response);
}
