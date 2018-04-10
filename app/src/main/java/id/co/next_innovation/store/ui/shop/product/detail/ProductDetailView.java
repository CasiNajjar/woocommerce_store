package id.co.next_innovation.store.ui.shop.product.detail;

import java.util.List;

import id.co.next_innovation.store.data.db.model.Product;
import id.co.next_innovation.store.data.db.model.ProductDetail;
import id.co.next_innovation.store.data.db.model.Review;
import id.co.next_innovation.store.ui.base.MvpView;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public interface ProductDetailView extends MvpView {
    void showProductDetail(ProductDetail product);

    void showReviews(List<Review> reviews);
}
