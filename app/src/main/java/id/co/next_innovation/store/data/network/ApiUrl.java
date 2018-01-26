package id.co.next_innovation.store.data.network;

import android.util.Base64;

import javax.inject.Singleton;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, November 2017
 */

@Singleton
public class ApiUrl {

    static {
        System.loadLibrary("native-lib");
    }

    public native String invokeAuthUrl();
    public native String invokeRegistUrl();

    public String signIn = new String(Base64.decode(invokeAuthUrl(), Base64.DEFAULT));
    public String signUp = new String(Base64.decode(invokeRegistUrl(), Base64.DEFAULT));
    public String insecureCool = "?&insecure=cool";

}
