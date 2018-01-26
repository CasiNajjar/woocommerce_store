package id.co.next_innovation.store.ui.shop.account;

import javax.inject.Inject;

import id.co.next_innovation.store.data.DataManager;
import id.co.next_innovation.store.ui.base.BasePresenter;
import id.co.next_innovation.store.ui.base.MvpPresenter;
import id.co.next_innovation.store.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class AccountPresenter<V extends AccountView> extends BasePresenter<V> implements AccountMvpPresenter<V> {

    @Inject
    public AccountPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
