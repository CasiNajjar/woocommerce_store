package id.co.next_innovation.store.ui.shop.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.data.db.model.Product;
import id.co.next_innovation.store.ui.base.BaseActivity;
import id.co.next_innovation.store.ui.shop.product.detail.ProductDetailActivity;
import id.co.next_innovation.store.utils.AppLogger;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class ProductActivity extends BaseActivity implements ProductView, ProductAdapter.Callback {

    @Inject
    ProductMvpPresenter<ProductView> mPresenter;

    @Inject
    ProductAdapter mProductAdapter;

    @BindView(R.id.recycler_products)
    RecyclerView mRecyclerProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));
        mProductAdapter.setCallback(this);

        mPresenter.onAttach(this);
        setUp();

    }

    @Override
    protected void setUp() {

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        int category_id = bundle.getInt("category_id");

        mPresenter.fetchProductsByCategory(category_id);

        mRecyclerProducts.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2, GridLayout.VERTICAL, false));
        mRecyclerProducts.setAdapter(mProductAdapter);

    }

    @Override
    public void showProducts(List<Product> products) {
        mProductAdapter.addItems(products);
    }

    @Override
    public void onProductSelected(int product_id) {
        Intent i = new Intent(this, ProductDetailActivity.class);
        i.putExtra("product_id", product_id);
        startActivity(i);
    }
}
