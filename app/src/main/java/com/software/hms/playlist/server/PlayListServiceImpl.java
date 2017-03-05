package com.software.hms.playlist.server;

import com.software.hms.playlist.enums.GoogleApiEnum;
import com.software.hms.playlist.interfaces.GoogleApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hms on 05/03/17.
 */

public class PlayListServiceImpl implements PlayListService {

    @Override
    public GoogleApi create() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(3000, TimeUnit.MILLISECONDS).build();

        final Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(GoogleApiEnum.SERVER.getValue())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient);

        final Retrofit retrofit = builder.build();

        return retrofit.create(GoogleApi.class);
    }
}
