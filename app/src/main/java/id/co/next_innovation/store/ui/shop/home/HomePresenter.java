package id.co.next_innovation.store.ui.shop.home;

import com.androidnetworking.error.ANError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import id.co.next_innovation.store.data.DataManager;
import id.co.next_innovation.store.data.db.model.Category;
import id.co.next_innovation.store.data.db.model.Product;
import id.co.next_innovation.store.data.network.model.ProductRequest;
import id.co.next_innovation.store.ui.base.BasePresenter;
import id.co.next_innovation.store.utils.AppLogger;
import id.co.next_innovation.store.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class HomePresenter<V extends HomeView> extends BasePresenter<V> implements HomeMvpPresenter<V> {

    @Inject
    public HomePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void fetchCategories() {
        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager().getCategories(new ProductRequest.Categories())
                .observeOn(getSchedulerProvider().ui())
                .subscribeOn(getSchedulerProvider().io())
                .subscribe(categories -> {
                    if (categories != null) {
                        getMvpView().showCategories(categories);
                    }
                    getMvpView().hideLoading();
                }, throwable -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    getMvpView().hideLoading();
                    // handle the error here
                    if (throwable instanceof ANError) {
                        ANError anError = (ANError) throwable;
                        handleApiError(anError);
                    }
                }));
    }

    @Override
    public void fetchFeaturedProducts() {

        getCompositeDisposable().add(getDataManager().getFeaturedProducts(new ProductRequest.Featured())
                .observeOn(getSchedulerProvider().ui())
                .subscribeOn(getSchedulerProvider().io())
                .subscribe(productList -> {
                    if (productList!=null) {
                        AppLogger.e("success");
                        getMvpView().showFeaturedProducts(productList);
                    }
                }, throwable -> {
                    AppLogger.e("error");
                    AppLogger.e(throwable.getMessage());
                    AppLogger.e("ss"+throwable.getLocalizedMessage());

                    if (!isViewAttached()) {
                        return;
                    }
                    getMvpView().hideLoading();
                    // handle the error here
                    if (throwable instanceof ANError) {
                        ANError anError = (ANError) throwable;
                        handleApiError(anError);
                    }
                }));

    }
}
