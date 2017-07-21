package com.libraries.garyfimo.gmaps.addresses.presentation.presenters;

import com.google.android.gms.maps.model.LatLng;
import com.libraries.garyfimo.gmaps.addresses.data.webservices.models.AddressComponent;
import com.libraries.garyfimo.gmaps.addresses.data.webservices.models.Result;
import com.libraries.garyfimo.gmaps.addresses.data.webservices.models.response.AddressResponse;
import com.libraries.garyfimo.gmaps.addresses.domain.AddressInteractor;
import com.libraries.garyfimo.gmaps.addresses.domain.AddressInteractorImpl;
import com.libraries.garyfimo.gmaps.addresses.domain.listener.AddressInteractorListener;
import com.libraries.garyfimo.gmaps.addresses.presentation.views.AddressView;
import com.libraries.garyfimo.gmaps.addresses.utils.RequestType;

/**
 * Created by gfiguerola on 7/7/17.
 */

public class AddressPresenterImpl implements AddressPresenter, AddressInteractorListener {

    private AddressInteractor mInteractor;
    private AddressView mView;
    private RequestType mRequestType;

    public AddressPresenterImpl(AddressView view) {
        mView = view;
        mInteractor = new AddressInteractorImpl(this);
    }

    @Override
    public void getAddress(LatLng latLng) {
        mRequestType = RequestType.ADDRESS;
        mInteractor.requestAddress(latLng);
    }

    @Override
    public void getGeoDecode(LatLng latLng) {
        mRequestType = RequestType.GEODECODE;
        mInteractor.requestAddress(latLng);
    }

    @Override
    public void onRequestAddressSuccess(AddressResponse response) {
        if (response.getResults().size() > 0) {
            Result result = response.getResults().get(0);
            if (mRequestType == RequestType.ADDRESS) {
                String address = String.format("%s %s", result.getAddressComponents().get(1).getShortName(), result.getAddressComponents().get(0).getShortName());
                mView.onGetAddressSuccess(address);
            } else if (mRequestType == RequestType.GEODECODE) {
                String district = "";
                String province = "";
                String department = "";
                for (AddressComponent ac : result.getAddressComponents()) {
                    if (ac.getTypes().get(0).equals("locality")) {
                        district = ac.getLongName();
                    } else if (ac.getTypes().get(0).equals("administrative_area_level_2")) {
                        province = ac.getLongName();
                    } else if (ac.getTypes().get(0).equals("administrative_area_level_1")) {
                        department = ac.getLongName();
                    }
                }
                district = district.isEmpty() ? "-" : district;
                province = province.isEmpty() ? "-" : province;
                department = department.isEmpty() ? "-" : department;
                String ubigeo = String.format("%s, %s, %s", district, province, department);
                mView.onGetAddressSuccess(ubigeo);
            }
        }
    }
}
