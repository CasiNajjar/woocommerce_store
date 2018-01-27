package id.co.next_innovation.store.ui.shop.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.data.db.model.Category;
import id.co.next_innovation.store.data.db.model.Product;
import id.co.next_innovation.store.ui.base.BaseActivity;
import id.co.next_innovation.store.ui.shop.account.AccountActivity;
import id.co.next_innovation.store.ui.shop.category.CategoryAdapter;
import id.co.next_innovation.store.ui.shop.product.FeaturedProductAdapter;
import id.co.next_innovation.store.ui.shop.product.ProductActivity;
import id.co.next_innovation.store.utils.AppLogger;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class HomeActivity extends BaseActivity implements HomeView, CategoryAdapter.Callback {

    @Inject
    HomeMvpPresenter<HomeView> mPresenter;

    @Inject
    CategoryAdapter mCategoryAdapter;

    @Inject
    FeaturedProductAdapter mFeaturedProductAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.recycler_category)
    RecyclerView mRecyclerCategory;

    @BindView(R.id.recycler_featured_products)
    RecyclerView mRecyclerFeaturedProduct;

    @OnClick(R.id.f_btn_account)
    void gotoAccount() {
        startActivity(new Intent(this, AccountActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));
        mCategoryAdapter.setCallback(this);

        mPresenter.onAttach(this);
        setUp();

    }

    @Override
    protected void setUp() {
        mRecyclerCategory.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4, GridLayout.VERTICAL, false));
        mRecyclerCategory.setAdapter(mCategoryAdapter);

        mRecyclerFeaturedProduct.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        mRecyclerFeaturedProduct.setAdapter(mFeaturedProductAdapter);

        mPresenter.fetchCategories();
        mPresenter.fetchFeaturedProducts();

    }

    @Override
    public void showCategories(List<Category> categories) {
        mCategoryAdapter.addItems(categories);
    }

    @Override
    public void showFeaturedProducts(List<Product> products) {
        mFeaturedProductAdapter.addItems(products);
    }

    @Override
    public void onCategorySelected(int category_id) {
        Intent i = new Intent(this, ProductActivity.class);
        i.putExtra("category_id", category_id);
        startActivity(i);
    }
}
