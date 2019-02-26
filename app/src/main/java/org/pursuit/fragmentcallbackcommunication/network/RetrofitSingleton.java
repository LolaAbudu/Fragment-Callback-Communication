package org.pursuit.fragmentcallbackcommunication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static Retrofit myOneInstance;

    public static Retrofit getOneInstance() {
        if (myOneInstance != null) {
            return myOneInstance;
        }
        myOneInstance = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://raw.githubusercontent.com/")
                .build();
        return myOneInstance;
    }

    private RetrofitSingleton() {
    }

}
