package com.libraries.garyfimo.gmaps.addresses.domain;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by gfiguerola on 7/6/17.
 */

public interface AddressInteractor {

    void requestAddress(LatLng latLng);
}
