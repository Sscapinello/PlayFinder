package com.playfinder.playfinder;

import retrofit2.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by itsadmin on 15/03/2018.
 */

public class Client {


    private static final String BASE_URL = "";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
