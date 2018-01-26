package id.co.next_innovation.store.di.component;

import dagger.Component;
import id.co.next_innovation.store.di.PerActivity;
import id.co.next_innovation.store.di.module.ActivityModule;
import id.co.next_innovation.store.ui.shop.account.AccountActivity;
import id.co.next_innovation.store.ui.shop.home.HomeActivity;
import id.co.next_innovation.store.ui.sign.in.SignInActivity;
import id.co.next_innovation.store.ui.sign.up.SignUpActivity;
import id.co.next_innovation.store.ui.splash.SplashActivity;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity activity);
    void inject(SignUpActivity activity);
    void inject(SignInActivity activity);
    void inject(HomeActivity activity);
    void inject(AccountActivity activity);
}
