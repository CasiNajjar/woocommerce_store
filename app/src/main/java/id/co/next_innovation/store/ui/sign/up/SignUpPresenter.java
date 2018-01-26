package id.co.next_innovation.store.ui.sign.up;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import id.co.next_innovation.store.R;
import id.co.next_innovation.store.data.DataManager;
import id.co.next_innovation.store.data.network.model.SignRequest;
import id.co.next_innovation.store.data.network.model.SignResponse;
import id.co.next_innovation.store.ui.base.BasePresenter;
import id.co.next_innovation.store.utils.CommonUtils;
import id.co.next_innovation.store.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class SignUpPresenter<V extends SignUpView> extends BasePresenter<V> implements SignUpMvpPresenter<V> {

    @Inject
    public SignUpPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void register(String username, String email, String password) {
        if (username.isEmpty()) {
            getMvpView().onError(R.string.message_empty_name);
            return;
        }
        if (email.isEmpty()) {
            getMvpView().onError(R.string.message_empty_email);
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().onError(R.string.message_invalid_email);
            return;
        }
        if (password.isEmpty()) {
            getMvpView().onError(R.string.message_empty_password);
            return;
        }
        if (!getMvpView().agreeTermConds()) {
            getMvpView().onError(R.string.message_agree_term_conds);
            return;
        }

        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager().signUp(new SignRequest.Up(username, email, password))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(up -> {
                    if (up.getId()!=null) {
                        getMvpView().showMessage(R.string.message_success_registration);
                        getMvpView().gotoSignIn();
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
