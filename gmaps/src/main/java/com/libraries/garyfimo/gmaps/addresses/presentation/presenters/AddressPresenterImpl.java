package com.libraries.garyfimo.gmaps.addresses.presentation.presenters;

import com.google.android.gms.maps.model.LatLng;
import com.libraries.garyfimo.gmaps.addresses.data.webservices.models.Result;
import com.libraries.garyfimo.gmaps.addresses.data.webservices.models.response.AddressResponse;
import com.libraries.garyfimo.gmaps.addresses.domain.AddressInteractor;
import com.libraries.garyfimo.gmaps.addresses.domain.AddressInteractorImpl;
import com.libraries.garyfimo.gmaps.addresses.domain.listener.AddressInteractorListener;
import com.libraries.garyfimo.gmaps.addresses.presentation.views.AddressView;

/**
 * Created by gfiguerola on 7/7/17.
 */

public class AddressPresenterImpl implements AddressPresenter, AddressInteractorListener {

    private AddressInteractor mInteractor;
    private AddressView mView;

    public AddressPresenterImpl(AddressView view) {
        mView = view;
        mInteractor = new AddressInteractorImpl(this);
    }

    @Override
    public void getAddress(LatLng latLng) {
        mInteractor.requestAddress(latLng);
    }

    @Override
    public void onRequestAddressSuccess(AddressResponse response) {
        if (response.getResults().size() > 0) {
            Result result = response.getResults().get(0);
            mView.onGetAddressSuccess(result.getFormattedAddress());
        }
    }
}
