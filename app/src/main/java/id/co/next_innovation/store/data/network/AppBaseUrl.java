package id.co.next_innovation.store.data.network;

import javax.inject.Singleton;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */

@Singleton
public class AppBaseUrl {

    static {
        System.loadLibrary("native-lib");
    }

    public native String invokeBaseUrl();

}
