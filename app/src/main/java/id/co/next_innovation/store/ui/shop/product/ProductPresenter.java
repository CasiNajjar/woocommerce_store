package id.co.next_innovation.store.ui.shop.product;

import javax.inject.Inject;

import id.co.next_innovation.store.data.DataManager;
import id.co.next_innovation.store.ui.base.BasePresenter;
import id.co.next_innovation.store.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

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
}
