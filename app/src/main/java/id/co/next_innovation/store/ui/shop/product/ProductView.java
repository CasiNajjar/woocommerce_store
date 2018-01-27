package id.co.next_innovation.store.ui.shop.product;

import java.util.List;

import id.co.next_innovation.store.data.db.model.Product;
import id.co.next_innovation.store.ui.base.MvpView;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public interface ProductView extends MvpView {

    void showProducts(List<Product> products);
}
