package com.libraries.garyfimo.gmaps.routes.utils;

import com.libraries.garyfimo.gmaps.R;

/**
 * Created by gfiguerola on 6/19/17.
 */

public class RouteColorUtil {

    public static int getRouteColor(int position) {
        switch (position) {
            case 1:
                return R.color.emerald;
            case 2:
                return R.color.belize_hole;
            case 3:
                return R.color.pumpkin;
            case 4:
                return R.color.wisteria;
            case 5:
                return R.color.green_sea;
            case 6:
                return R.color.nephritis;
            case 7:
                return R.color.orange;
            case 8:
                return R.color.alizarin;
            case 9:
                return R.color.sun_flower;
            case 10:
                return R.color.asbestos;
            default:
                return R.color.alizarin;
        }
    }
}
