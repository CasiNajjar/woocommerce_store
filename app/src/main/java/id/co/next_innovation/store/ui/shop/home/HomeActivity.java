package id.co.next_innovation.store.ui.shop.home;

import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.ui.base.BaseActivity;
import id.co.next_innovation.store.ui.shop.account.AccountActivity;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class HomeActivity extends BaseActivity implements HomeView {

    @Inject
    HomeMvpPresenter<HomeView> mPresenter;

    @Override
    protected void setUp() {

    }

    @OnClick(R.id.f_btn_account)
    void gotoAccount() {
        startActivity(new Intent(this, AccountActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();

    }
}
