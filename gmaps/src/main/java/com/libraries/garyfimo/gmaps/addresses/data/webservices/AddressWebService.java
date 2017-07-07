package com.libraries.garyfimo.gmaps.addresses.data.webservices;

import com.google.android.gms.maps.model.LatLng;
import com.libraries.garyfimo.gmaps.GMapsApplication;
import com.libraries.garyfimo.gmaps.addresses.data.webservices.models.response.AddressResponse;

import java.net.SocketTimeoutException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.libraries.garyfimo.gmaps.addresses.utils.FetchURL.getAddressMapParams;


/**
 * Created by gfiguerola on 7/6/17.
 */

public class AddressWebService implements Callback<AddressResponse> {

    Retrofit retrofit = GMapsApplication.getRetrofit();
    WSAddressListener mListener;

    public AddressWebService(WSAddressListener listener) {
        mListener = listener;
    }

    public void doRequest(LatLng latLng) {
        Map<String, String> params = getAddressMapParams(latLng);
        AddressService service = retrofit.create(AddressService.class);
        Call<AddressResponse> responseCall = service.requestAddress(params);
        responseCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<AddressResponse> call, Response<AddressResponse> response) {
        if (response.isSuccessful()) {
            mListener.onRequestSuccess(response.body());
        }
    }

    @Override
    public void onFailure(Call<AddressResponse> call, Throwable t) {
        if (t instanceof SocketTimeoutException) {
//            mListener.onRequestError(R.string.timeout_error);
        } else {
//            mListener.onRequestError(R.string.server_error);
        }
    }
}
