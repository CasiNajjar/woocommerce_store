package id.co.next_innovation.store.data;

import android.content.Context;

import org.json.JSONArray;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.co.next_innovation.store.data.db.DbHelper;
import id.co.next_innovation.store.data.db.model.Category;
import id.co.next_innovation.store.data.db.model.User;
import id.co.next_innovation.store.data.network.ApiHeader;
import id.co.next_innovation.store.data.network.ApiHelper;
import id.co.next_innovation.store.data.network.AppBaseUrl;
import id.co.next_innovation.store.data.network.ApiUrl;
import id.co.next_innovation.store.data.network.model.CategoryResponse;
import id.co.next_innovation.store.data.network.model.ProductRequest;
import id.co.next_innovation.store.data.network.model.SignRequest;
import id.co.next_innovation.store.data.network.model.SignResponse;
import id.co.next_innovation.store.data.prefs.PreferencesHelper;
import id.co.next_innovation.store.di.ApplicationContext;
import io.reactivex.Observable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Singleton
public
class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public AppBaseUrl getBaseUrl() {
        return mApiHelper.getBaseUrl();
    }

    @Override
    public ApiUrl getApiUrl() {
        return mApiHelper.getApiUrl();
    }


    @Override
    public Observable<SignResponse.In> signIn(SignRequest.In request) {
        return mApiHelper.signIn(request);
    }

    @Override
    public Observable<SignResponse.Up> signUp(SignRequest.Up request) {
        return mApiHelper.signUp(request);
    }

    @Override
    public String getDecodeUrl() {
        return mApiHelper.getDecodeUrl();
    }


    @Override
    public boolean isLoggedIn() {
        return mPreferencesHelper.isLoggedIn();
    }

    @Override
    public void setLoggedIn(boolean loggedIn) {
        mPreferencesHelper.setLoggedIn(loggedIn);
    }

    @Override
    public void addUser(User user) {
        mDbHelper.addUser(user);
    }

    @Override
    public void removeUser() {
        mDbHelper.removeUser();
    }

    @Override
    public User getUser() {
        return mDbHelper.getUser();
    }

    @Override
    public Observable<CategoryResponse> getCategories(ProductRequest.Categories request) {
        return mApiHelper.getCategories(request);
    }

    @Override
    public Observable<JSONArray> categories(ProductRequest.Categories request) {
        return mApiHelper.categories(request);
    }

    @Override
    public Observable<List<Category>> tes(ProductRequest.Categories request) {
        return mApiHelper.tes(request);
    }
}
