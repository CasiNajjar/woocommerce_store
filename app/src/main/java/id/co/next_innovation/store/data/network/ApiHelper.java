package id.co.next_innovation.store.data.network;

import id.co.next_innovation.store.data.network.model.SignRequest;
import id.co.next_innovation.store.data.network.model.SignResponse;
import io.reactivex.Observable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public interface ApiHelper {

    ApiHeader getApiHeader();
    AppBaseUrl getBaseUrl();
    String getDecodeUrl();
    ApiUrl getApiUrl();
    Observable<SignResponse.In> signIn(SignRequest.In request);
    Observable<SignResponse.Up> signUp(SignRequest.Up request);
}
