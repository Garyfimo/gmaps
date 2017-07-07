package com.libraries.garyfimo.gmaps.addresses.domain;

import com.google.android.gms.maps.model.LatLng;
import com.libraries.garyfimo.gmaps.addresses.data.webservices.AddressWebService;
import com.libraries.garyfimo.gmaps.addresses.data.webservices.WSAddressListener;
import com.libraries.garyfimo.gmaps.addresses.data.webservices.models.response.AddressResponse;
import com.libraries.garyfimo.gmaps.addresses.domain.listener.AddressInteractorListener;

/**
 * Created by gfiguerola on 7/6/17.
 */

public class AddressInteractorImpl implements AddressInteractor, WSAddressListener {

    AddressInteractorListener mListener;

    public AddressInteractorImpl(AddressInteractorListener listener) {
        mListener = listener;
    }

    @Override
    public void requestAddress(LatLng latLng) {
        AddressWebService webService = new AddressWebService(this);
        webService.doRequest(latLng);
    }

    @Override
    public void onRequestSuccess(AddressResponse response) {
mListener.onRequestAddressSuccess(response);
    }
}
