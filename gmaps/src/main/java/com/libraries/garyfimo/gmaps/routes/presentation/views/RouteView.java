package com.libraries.garyfimo.gmaps.routes.presentation.views;


import com.libraries.garyfimo.gmaps.routes.presentation.models.RouteModel;

import java.util.List;

/**
 * Created by gfiguerola on 6/30/17.
 */

public interface RouteView {

    void onGetRoutesSuccess(List<RouteModel> latLngs);
}
