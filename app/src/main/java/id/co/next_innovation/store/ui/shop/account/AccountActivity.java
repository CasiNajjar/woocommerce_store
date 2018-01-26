package id.co.next_innovation.store.ui.shop.account;

import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.ui.base.BaseActivity;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class AccountActivity extends BaseActivity implements AccountView {

    @Inject
    AccountMvpPresenter<AccountView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        overridePendingTransition(R.anim.anim_pop_up, R.anim.anim_push_up);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();

    }

    @Override
    protected void setUp() {

    }

    public void onBackPressed() {
        finishAction();
    }

    private void finishAction() {
        finish();
        overridePendingTransition(R.anim.anim_pop_down, R.anim.anim_push_down);
    }
}
