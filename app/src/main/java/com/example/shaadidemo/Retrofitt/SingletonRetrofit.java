package com.example.shaadidemo.Retrofitt;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SingletonRetrofit {
    private static SingletonRetrofit mInstance;
    private Retrofit mRetrofit;

    private SingletonRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Api.PROFILE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static SingletonRetrofit getInstance() {
        if (mInstance == null) {
            mInstance = new SingletonRetrofit();
        }
        return mInstance;
    }

    public Api getJSONApi() {
        return mRetrofit.create(Api.class);
    }
}
