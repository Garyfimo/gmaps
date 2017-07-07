package com.libraries.garyfimo.gmaps.addresses.presentation.presenters;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by gfiguerola on 7/7/17.
 */

public interface AddressPresenter {

    void getAddress(LatLng latLng);
}
