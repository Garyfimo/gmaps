package com.libraries.garyfimo.gmaps.addresses.data.webservices;

import com.libraries.garyfimo.gmaps.addresses.data.webservices.models.response.AddressResponse;

/**
 * Created by gfiguerola on 7/6/17.
 */

public interface WSAddressListener {

    void onRequestSuccess(AddressResponse response);
}
