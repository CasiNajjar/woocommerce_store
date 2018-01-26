package id.co.next_innovation.store;

import android.app.Application;
import android.util.Base64;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import id.co.next_innovation.store.data.DataManager;
import id.co.next_innovation.store.di.component.ApplicationComponent;
import id.co.next_innovation.store.di.component.DaggerApplicationComponent;
import id.co.next_innovation.store.di.module.ApplicationModule;
import id.co.next_innovation.store.utils.AppLogger;
import okhttp3.OkHttpClient;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;


import javax.inject.Inject;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class NextInnovation extends Application {

    static {
        System.loadLibrary("native-lib");
    }

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;
    private native String invokeConsumerKey();
    private native String invokeConsumerSecret();

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
        AppLogger.init();

        String CONSUMER_KEY = new String(Base64.decode(invokeConsumerKey(), Base64.DEFAULT));
        String CONSUMER_SECRET = new String(Base64.decode(invokeConsumerSecret(), Base64.DEFAULT));

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret("", "");

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        AndroidNetworking.initialize(getApplicationContext(), client);

        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }


}
