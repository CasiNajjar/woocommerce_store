package id.co.next_innovation.store.ui.sign.in;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.ui.base.BaseActivity;
import id.co.next_innovation.store.ui.helper.LatoEditText;
import id.co.next_innovation.store.ui.shop.home.HomeActivity;
import id.co.next_innovation.store.ui.sign.up.SignUpActivity;
import id.co.next_innovation.store.utils.AppLogger;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class SignInActivity extends BaseActivity implements SignInView {

    @Inject
    SignInMvpPresenter<SignInView> mPresenter;

    @BindView(R.id.email)
    EditText mEmail;
    @BindView(R.id.password)
    EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();

    }

    @OnClick(R.id.signin)
    void signIn() {
        mPresenter.authentication(mEmail.getText().toString(), mPassword.getText().toString());
    }

    @OnClick(R.id.signup)
    void gotoSignUp() {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void gotoHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
