package id.co.next_innovation.store.data.network;

import android.util.Base64;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.co.next_innovation.store.data.network.model.SignRequest;
import id.co.next_innovation.store.data.network.model.SignResponse;
import io.reactivex.Observable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;
    private AppBaseUrl mBaseUrl;
    private ApiUrl mApiUrl;

    @Inject
    public AppApiHelper(ApiHeader apiHeader, AppBaseUrl baseUrl, ApiUrl apiUrl) {
        mApiHeader = apiHeader;
        mBaseUrl = baseUrl;
        mApiUrl = apiUrl;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public AppBaseUrl getBaseUrl() {
        return mBaseUrl;
    }

    @Override
    public ApiUrl getApiUrl() {
        return mApiUrl;
    }

    @Override
    public String getDecodeUrl() {
        return new String(Base64.decode(getBaseUrl().invokeBaseUrl(), Base64.DEFAULT));
    }

    @Override
    public Observable<SignResponse.Up> signUp(SignRequest.Up request) {
        return Rx2AndroidNetworking.post(getDecodeUrl() + getApiUrl().signUp)
                .addBodyParameter(request)
                .build()
                .getObjectObservable(SignResponse.Up.class);
    }

    @Override
    public Observable<SignResponse.In> signIn(SignRequest.In request) {
        return Rx2AndroidNetworking.post(getDecodeUrl() + getApiUrl().signIn + getApiUrl().insecureCool)
                .addBodyParameter(request)
                .build()
                .getObjectObservable(SignResponse.In.class);
    }

}
