package id.co.next_innovation.store.ui.sign.up;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.ui.base.BaseActivity;
import id.co.next_innovation.store.ui.sign.in.SignInActivity;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class SignUpActivity extends BaseActivity implements SignUpView {

    @Inject
    SignUpMvpPresenter<SignUpView> mPresenter;

    @BindView(R.id.username)
    EditText mUsername;
    @BindView(R.id.email)
    EditText mEmail;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.checkbox)
    CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getActivityComponent().inject(this);
        overridePendingTransition(R.anim.anim_pop_left, R.anim.anim_push_left);
        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();
    }

    @OnClick(R.id.signUp)
    void signUp() {
        mPresenter.register(mUsername.getText().toString(), mEmail.getText().toString(), mPassword.getText().toString());
    }

    @OnClick(R.id.signin)
    void backtoSignIn() {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }

    @Override
    protected void setUp() {

    }

    private void finishAction() {
        finish();
        overridePendingTransition(R.anim.anim_pop_right, R.anim.anim_push_right);
    }

    public void onBackPressed() {
        finishAction();
    }

    @Override
    public boolean agreeTermConds() {
        return mCheckBox.isChecked();
    }

    @Override
    public void gotoSignIn() {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }
}
