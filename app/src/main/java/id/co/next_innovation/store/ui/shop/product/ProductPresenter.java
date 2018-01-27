package id.co.next_innovation.store.ui.shop.product;

import com.androidnetworking.error.ANError;

import java.util.List;

import javax.inject.Inject;

import id.co.next_innovation.store.data.DataManager;
import id.co.next_innovation.store.data.db.model.Product;
import id.co.next_innovation.store.data.network.model.ProductRequest;
import id.co.next_innovation.store.ui.base.BasePresenter;
import id.co.next_innovation.store.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class ProductPresenter<V extends ProductView> extends BasePresenter<V> implements ProductMvpPresenter<V> {

    @Inject
    public ProductPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void fetchProductsByCategory(int category_id) {

        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager().getProductByCategory(new ProductRequest.ProductByCategory(category_id))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(products -> {
                    if (products!=null) {
                        getMvpView().showProducts(products);
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
