package com.libraries.garyfimo.gmaps.routes.presentation.presenters;

import com.google.android.gms.maps.model.LatLng;
import com.libraries.garyfimo.gmaps.routes.data.webservices.models.Leg;
import com.libraries.garyfimo.gmaps.routes.data.webservices.models.Route;
import com.libraries.garyfimo.gmaps.routes.data.webservices.models.Step;
import com.libraries.garyfimo.gmaps.routes.data.webservices.models.response.RouteResponse;
import com.libraries.garyfimo.gmaps.routes.domain.RouteInteractor;
import com.libraries.garyfimo.gmaps.routes.domain.RouteInteractorImpl;
import com.libraries.garyfimo.gmaps.routes.domain.listener.RouteInteractorListener;
import com.libraries.garyfimo.gmaps.routes.presentation.models.RouteModel;
import com.libraries.garyfimo.gmaps.routes.presentation.views.RouteView;
import com.libraries.garyfimo.gmaps.routes.utils.Configuration;

import java.util.ArrayList;
import java.util.List;

import static com.libraries.garyfimo.gmaps.routes.utils.RouteColorUtil.getRouteColor;
import static com.libraries.garyfimo.gmaps.routes.utils.RouteUtil.decodePoly;

/**
 * Created by gfiguerola on 6/30/17.
 */

public class RoutePresenterImpl implements RoutePresenter, RouteInteractorListener {

    RouteInteractor mInteractor;
    RouteView mView;

    public RoutePresenterImpl(RouteView view) {
        mView = view;
        mInteractor = new RouteInteractorImpl(this);
    }

    @Override
    public void getRoutes(LatLng origin, LatLng destination, Configuration configuration) {
        mInteractor.requestRoutes(origin, destination, configuration);
    }

    @Override
    public void getRoutes(LatLng origin, LatLng destination, Configuration configuration, List<LatLng> wayPoints) {
        mInteractor.requestRoutes(origin, destination, configuration, wayPoints);
    }

    @Override
    public void onRequestRouteSuccess(RouteResponse response) {
        List<RouteModel> resultList = new ArrayList<>();
        if (response.getRoutes().size() > 0) {
            Route route = response.getRoutes().get(0);
            for (Leg leg : route.getLegs()) {
                RouteModel routeModel = new RouteModel();
                routeModel.setColor(getRouteColor(route.getLegs().indexOf(leg)));
                List<LatLng> directions = new ArrayList<>();
                for (Step step : leg.getSteps()) {
                    for (LatLng latLng : decodePoly(step.getPolyLine().getPoints())) {
                        directions.add(latLng);
                    }
                }
                routeModel.setDirections(directions);
                resultList.add(routeModel);
            }
            mView.onGetRoutesSuccess(resultList);
        }
    }
}
