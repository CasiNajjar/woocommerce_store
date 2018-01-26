package id.co.next_innovation.store.ui.sign.in;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import id.co.next_innovation.store.R;
import id.co.next_innovation.store.data.DataManager;
import id.co.next_innovation.store.data.network.model.SignRequest;
import id.co.next_innovation.store.data.network.model.SignResponse;
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
public class SignInPresenter<V extends SignInView> extends BasePresenter<V> implements SignInMvpPresenter<V> {

    @Inject
    public SignInPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        if (getDataManager().isLoggedIn()) {
            getMvpView().gotoHome();
        }
    }

    @Override
    public void authentication(String email, String password) {

        if (email.isEmpty()) {
            getMvpView().onError(R.string.message_empty_email);
            return;
        }
        if (password.isEmpty()) {
            getMvpView().onError(R.string.message_empty_password);
        }

        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager().signIn(new SignRequest.In(email, password))
                .observeOn(getSchedulerProvider().ui())
                .subscribeOn(getSchedulerProvider().io())
                .subscribe(in -> {
                    if (!in.getStatus().equals("error")) {
                        getMvpView().hideLoading();
                        getMvpView().gotoHome();
                        getDataManager().addUser(in.getUser());
                        getDataManager().setLoggedIn(true);
                    } else {
                        getMvpView().onError(R.string.invalid_credentials);
                        getMvpView().hideLoading();
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
}
