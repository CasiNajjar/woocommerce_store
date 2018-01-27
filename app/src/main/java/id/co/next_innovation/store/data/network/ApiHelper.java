package id.co.next_innovation.store.data.network;

import org.json.JSONArray;

import java.util.List;

import id.co.next_innovation.store.data.db.model.Category;
import id.co.next_innovation.store.data.db.model.Product;
import id.co.next_innovation.store.data.network.model.CategoryResponse;
import id.co.next_innovation.store.data.network.model.ProductRequest;
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
    Observable<List<Category>> getCategories(ProductRequest.Categories request);
    Observable<List<Product>> getFeaturedProducts(ProductRequest.Featured request);
}
