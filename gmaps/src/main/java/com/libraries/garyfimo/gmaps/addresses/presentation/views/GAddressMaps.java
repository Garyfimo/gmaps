package com.libraries.garyfimo.gmaps.addresses.presentation.views;

import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.libraries.garyfimo.gmaps.addresses.presentation.presenters.AddressPresenter;
import com.libraries.garyfimo.gmaps.addresses.presentation.presenters.AddressPresenterImpl;

/**
 * Created by gfiguerola on 7/7/17.
 */

public class GAddressMaps implements AddressView {

    private static final String NULL_PARAMETERS_ARE_NOT_ACCEPTED = "Null parameters are not accepted";

    private static GAddressMaps sInstance;
    private AddressPresenter mPresenter = new AddressPresenterImpl(this);

    private TextView mTextView;
    private EditText mEditText;

    public static GAddressMaps getInstance() {
        sInstance = new GAddressMaps();
        return sInstance;
    }


    public GAddressMaps setAddress(LatLng latLng, TextView textView) {
        if ((latLng == null) || (textView == null)) {
            throw new IllegalArgumentException(NULL_PARAMETERS_ARE_NOT_ACCEPTED);
        }
        mTextView = textView;
        mPresenter.getAddress(latLng);
        return this;
    }

    public GAddressMaps setAddress(LatLng latLng, EditText editText) {
        if ((latLng == null) || (editText == null)) {
            throw new IllegalArgumentException(NULL_PARAMETERS_ARE_NOT_ACCEPTED);
        }
        mEditText = editText;
        mPresenter.getAddress(latLng);
        return this;
    }

    @Override
    public void onGetAddressSuccess(String address) {
        if (mEditText != null) {
            mEditText.setText(address);
        }
        if (mTextView != null) {
            mTextView.setText(address);
        }
    }
}
