package com.libraries.garyfimo.gmaps.routes.data.webservices;

import com.google.android.gms.maps.model.LatLng;
import com.libraries.garyfimo.gmaps.GMapsApplication;
import com.libraries.garyfimo.gmaps.routes.data.webservices.models.response.RouteResponse;
import com.libraries.garyfimo.gmaps.routes.utils.Configuration;

import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.libraries.garyfimo.gmaps.utils.FetchURL.getRouteMapParams;

/**
 * Created by gfiguerola on 6/28/17.
 */

public class RouteWebService implements Callback<RouteResponse> {

    Retrofit retrofit = GMapsApplication.getRetrofit();
    WSRouteListener mListener;

    public RouteWebService(WSRouteListener listener) {
        mListener = listener;
    }

    public void doRequest(LatLng origin, LatLng destination, Configuration configuration) {
        Map<String, String> params = getRouteMapParams(origin, destination, configuration.travelMode.toString());
//        String url = getURL(origin, destination, configuration.travelMode.toString());
        RouteService service = retrofit.create(RouteService.class);
        Call<RouteResponse> responseCall = service.requestRoutes(params);
        responseCall.enqueue(this);
    }

    public void doRequest(LatLng origin, LatLng destination, Configuration configuration, List<LatLng> wayPoints) {
        Map<String, String> params = getRouteMapParams(origin, destination, configuration.travelMode.toString(), wayPoints, configuration.optimize);
//        String url = getURL(origin, destination, configuration.travelMode.toString(), wayPoints, configuration.optimize);
        RouteService service = retrofit.create(RouteService.class);
        Call<RouteResponse> responseCall = service.requestRoutes(params);
        responseCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<RouteResponse> call, Response<RouteResponse> response) {
        if (response.isSuccessful()) {
            mListener.onRequestSuccess(response.body());
        }
    }

    @Override
    public void onFailure(Call<RouteResponse> call, Throwable t) {
        if (t instanceof SocketTimeoutException) {
//            mListener.onRequestError(R.string.timeout_error);
        } else {
//            mListener.onRequestError(R.string.server_error);
        }
    }
}
