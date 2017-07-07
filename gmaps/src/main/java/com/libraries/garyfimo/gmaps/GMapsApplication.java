package com.libraries.garyfimo.gmaps;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gfiguerola on 6/30/17.
 */

public class GMapsApplication extends Application {

    private static GMapsApplication sInstance;
    private static Retrofit sRetrofit;

    private static final int CONNECTION_TIMEOUT = 10;
    private static final int READ_TIMEOUT = 30;
    private static final int WRITE_TIMEOUT = 30;

    public static Retrofit getRetrofit() {
        if (sRetrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .build();

            sRetrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://maps.googleapis.com/maps/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

    public static GMapsApplication getInstance() {
        return sInstance;
    }
}