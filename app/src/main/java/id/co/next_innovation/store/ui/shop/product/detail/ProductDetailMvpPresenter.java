package id.co.next_innovation.store.ui.shop.product.detail;

import id.co.next_innovation.store.ui.base.MvpPresenter;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public interface ProductDetailMvpPresenter<V extends ProductDetailView> extends MvpPresenter<V> {

    void fetchProductDetail(int product_id);
}
