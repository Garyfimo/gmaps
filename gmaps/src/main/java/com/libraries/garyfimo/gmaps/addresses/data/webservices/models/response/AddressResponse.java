package com.libraries.garyfimo.gmaps.addresses.data.webservices.models.response;

import com.google.gson.annotations.SerializedName;
import com.libraries.garyfimo.gmaps.addresses.data.webservices.models.Result;

import java.util.List;

/**
 * Created by gfiguerola on 7/6/17.
 */

public class AddressResponse {
    @SerializedName("results")
    private List<Result> mResults;

    public List<Result> getResults() {
        return mResults;
    }

    public void setResults(List<Result> results) {
        mResults = results;
    }
}
