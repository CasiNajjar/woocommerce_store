package id.co.next_innovation.store.ui.shop.product.detail;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import id.co.next_innovation.store.data.DataManager;
import id.co.next_innovation.store.data.db.model.Product;
import id.co.next_innovation.store.data.db.model.ProductDetail;
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
public class ProductDetailPresenter<V extends ProductDetailView> extends BasePresenter<V> implements ProductDetailMvpPresenter<V> {

    @Inject
    public ProductDetailPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void fetchProductReviews(int product_id) {

        getCompositeDisposable().add(getDataManager().getProductReviews(new ProductRequest.ProductDetail(product_id))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(productReviews -> {
                    if (productReviews!=null) {
                        getMvpView().showReviews(productReviews);
                    }
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
    public void fetchProductDetail(int product_id) {

        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager().getProductDetail(new ProductRequest.ProductDetail(product_id))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(productDetail -> {
                    if (productDetail!=null) {
                        getMvpView().showProductDetail(productDetail);
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


}
