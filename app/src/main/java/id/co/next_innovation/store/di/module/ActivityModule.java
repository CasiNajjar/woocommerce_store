package id.co.next_innovation.store.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;


import java.util.ArrayList;

import id.co.next_innovation.store.di.ActivityContext;
import id.co.next_innovation.store.di.PerActivity;
import id.co.next_innovation.store.ui.shop.account.AccountMvpPresenter;
import id.co.next_innovation.store.ui.shop.account.AccountPresenter;
import id.co.next_innovation.store.ui.shop.account.AccountView;
import id.co.next_innovation.store.ui.shop.home.HomeMvpPresenter;
import id.co.next_innovation.store.ui.shop.home.HomePresenter;
import id.co.next_innovation.store.ui.shop.home.HomeView;
import id.co.next_innovation.store.ui.sign.in.SignInMvpPresenter;
import id.co.next_innovation.store.ui.sign.in.SignInPresenter;
import id.co.next_innovation.store.ui.sign.in.SignInView;
import id.co.next_innovation.store.ui.sign.up.SignUpMvpPresenter;
import id.co.next_innovation.store.ui.sign.up.SignUpPresenter;
import id.co.next_innovation.store.ui.sign.up.SignUpView;
import id.co.next_innovation.store.ui.splash.SplashMvpPresenter;
import id.co.next_innovation.store.ui.splash.SplashPresenter;
import id.co.next_innovation.store.ui.splash.SplashView;
import id.co.next_innovation.store.utils.rx.AppSchedulerProvider;
import id.co.next_innovation.store.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashView> provideSplashPresenter(
            SplashPresenter<SplashView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SignUpMvpPresenter<SignUpView> provideSignUpPresenter(
            SignUpPresenter<SignUpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SignInMvpPresenter<SignInView> provideSignInPresenter(
            SignInPresenter<SignInView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    HomeMvpPresenter<HomeView> provideHomePresenter(
            HomePresenter<HomeView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    AccountMvpPresenter<AccountView> provideAccountPresenter(
            AccountPresenter<AccountView> presenter) {
        return presenter;
    }

}
