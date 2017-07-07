package com.libraries.garyfimo.gmaps.routes.presentation.views;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.libraries.garyfimo.gmaps.routes.presentation.models.RouteModel;
import com.libraries.garyfimo.gmaps.routes.presentation.presenters.RoutePresenter;
import com.libraries.garyfimo.gmaps.routes.presentation.presenters.RoutePresenterImpl;
import com.libraries.garyfimo.gmaps.routes.utils.Configuration;

import java.util.List;

import static com.libraries.garyfimo.gmaps.utils.BuildVersionUtil.getColor;


/**
 * Created by gfiguerola on 6/30/17.
 */

public class GRoutesMaps implements RouteView {

    private static final String NULL_PARAMETERS_ARE_NOT_ACCEPTED = "Null parameters are not accepted";
    private static final String WAYPOINTS_SIZE_NOT_ACCEPTED = "Number of waypoints must not be major to 8";

    private static GRoutesMaps sInstance;
    RoutePresenter mPresenter = new RoutePresenterImpl(this);
    private Configuration mConfiguration = null;
    private Context mContext;
    private GoogleMap mGoogleMap;

    public static GRoutesMaps getInstance(Context context) {
        sInstance = new GRoutesMaps();
        sInstance.mContext = context;
        sInstance.mConfiguration = new Configuration.Builder().build();
        return sInstance;
    }

    public static GRoutesMaps getInstance(Context context, Configuration configuration) {
        sInstance = new GRoutesMaps();
        sInstance.mContext = context;
        sInstance.mConfiguration = configuration;
        return sInstance;
    }

    public GRoutesMaps draw(LatLng origin, LatLng destination, GoogleMap map) {
        if ((origin == null) || (destination == null) || (map == null)) {
            throw new IllegalArgumentException(NULL_PARAMETERS_ARE_NOT_ACCEPTED);
        }
        mGoogleMap = map;
        mPresenter.getRoutes(origin, destination, this.mConfiguration);
        return this;
    }

    public GRoutesMaps draw(LatLng origin, LatLng destination, List<LatLng> wayPoints, GoogleMap map) {
        if ((origin == null) || (destination == null) || (wayPoints == null) || (map == null)) {
            throw new IllegalArgumentException(NULL_PARAMETERS_ARE_NOT_ACCEPTED);
        }
        if(wayPoints.size() > 8){
            throw new IllegalArgumentException(WAYPOINTS_SIZE_NOT_ACCEPTED);
        }
        mGoogleMap = map;
        mPresenter.getRoutes(origin, destination, this.mConfiguration, wayPoints);
        return this;
    }

    @Override
    public void onGetRoutesSuccess(List<RouteModel> latLngs) {
        for (RouteModel rm : latLngs) {
            int color = this.mConfiguration.color == 0 ? rm.getColor() : this.mConfiguration.color;
            PolylineOptions polylineOptions = new PolylineOptions().width(this.mConfiguration.width).color(getColor(mContext, color));
            for (LatLng latLng : rm.getDirections()) {
                polylineOptions.geodesic(true).add(latLng);
            }
            mGoogleMap.addPolyline(polylineOptions);
        }
    }
}
