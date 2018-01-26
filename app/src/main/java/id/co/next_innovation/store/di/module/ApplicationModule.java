package id.co.next_innovation.store.di.module;

import android.app.Application;
import android.content.Context;



import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import id.co.next_innovation.store.data.AppDataManager;
import id.co.next_innovation.store.data.DataManager;
import id.co.next_innovation.store.data.db.AppDbHelper;
import id.co.next_innovation.store.data.db.DbHelper;
import id.co.next_innovation.store.data.network.ApiHeader;
import id.co.next_innovation.store.data.network.ApiHelper;
import id.co.next_innovation.store.data.network.ApiUrl;
import id.co.next_innovation.store.data.network.AppApiHelper;
import id.co.next_innovation.store.data.network.AppBaseUrl;
import id.co.next_innovation.store.data.prefs.AppPreferencesHelper;
import id.co.next_innovation.store.data.prefs.PreferencesHelper;
import id.co.next_innovation.store.di.ApplicationContext;
import id.co.next_innovation.store.di.DatabaseInfo;
import id.co.next_innovation.store.di.PreferenceInfo;
import id.co.next_innovation.store.utils.AppConstants;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader provideApiHeader(DbHelper header) {
        if (header==null) {
            return new ApiHeader("");
        }
        return new ApiHeader("");
    }

    @Provides
    @Singleton
    AppBaseUrl provideAppKey() {
        return new AppBaseUrl();
    }

    @Provides
    @Singleton
    ApiUrl provideAppParams() {
        return new ApiUrl();
    }

}
