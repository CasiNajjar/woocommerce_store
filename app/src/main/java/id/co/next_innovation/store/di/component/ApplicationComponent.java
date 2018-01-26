package id.co.next_innovation.store.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

import id.co.next_innovation.store.NextInnovation;
import id.co.next_innovation.store.data.DataManager;
import id.co.next_innovation.store.di.ApplicationContext;
import id.co.next_innovation.store.di.module.ApplicationModule;
import id.co.next_innovation.store.service.SyncService;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(NextInnovation app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();}
