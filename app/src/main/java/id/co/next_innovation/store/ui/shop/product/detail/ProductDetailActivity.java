package id.co.next_innovation.store.ui.shop.product.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.data.db.model.ProductDetail;
import id.co.next_innovation.store.data.db.model.Review;
import id.co.next_innovation.store.ui.base.BaseActivity;
import id.co.next_innovation.store.ui.helper.ListImageAdapter;
import id.co.next_innovation.store.ui.shop.product.detail.images.DetailImageActivity;
import id.co.next_innovation.store.utils.AppLogger;
import me.relex.circleindicator.CircleIndicator;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class ProductDetailActivity extends BaseActivity implements ProductDetailView {

    @Inject
    ProductDetailMvpPresenter<ProductDetailView> mPresenter;

    @Inject
    ProductReviewAdapter mProductReviewAdapter;

    @BindView(R.id.recycler_related_products)
    RecyclerView mRecyclerRelatedProducts;

    @BindView(R.id.recycler_reviews)
    RecyclerView mRecyclerReviews;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;

    @BindView(R.id.product_name)
    TextView mProductName;

    @BindView(R.id.viewpager_image)
    ViewPager mPagerImages;

    @BindView(R.id.product_description)
    TextView mProductDescription;

    @BindView(R.id.ratingbar)
    RatingBar mRatingBar;
    @BindView(R.id.ratingcount)
    TextView mRatingCount;
    @BindView(R.id.stock)
    TextView mStock;


    @BindView(R.id.indicator)
    CircleIndicator mIndicator;

    private ArrayList<String> ImagesArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();

    }

    @Override
    protected void setUp() {
        setToolBar();
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        int product_id = bundle.getInt("product_id");

        mPresenter.fetchProductDetail(product_id);
        mPresenter.fetchProductReviews(product_id);

    }

    @Override
    public void showProductDetail(ProductDetail product) {
        mProductName.setText(product.getName());
        mProductDescription.setText(Html.fromHtml(product.getDescription()));
        mRatingBar.setRating(Float.valueOf(product.getAverageRating()));
        mRatingCount.setText(String.valueOf(product.getRatingCount()));

        if (product.getInStock()) {
            mStock.setText(getString(R.string.in_stock));
        } else {
            mStock.setText(getString(R.string.out_stock));
        }

        for (int i=0; i<product.getImages().size(); i++)
            ImagesArray.add(product.getImages().get(i).getSrc());
            mPagerImages.setAdapter(new ListImageAdapter(this, ImagesArray));
            mIndicator.setViewPager(mPagerImages);


    }

    @Override
    public void showReviews(List<Review> reviews) {
        mProductReviewAdapter.addItems(reviews);
        mRecyclerReviews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerReviews.setAdapter(mProductReviewAdapter);
    }

    private void setToolBar() {
        setSupportActionBar(mToolbar);
        mToolbarTitle.setText(getString(R.string.product_detail));
        ActionBar localActionBar = getSupportActionBar();
        if (localActionBar != null) {
            localActionBar.setDisplayHomeAsUpEnabled(true);
        }
        assert localActionBar != null;
        localActionBar.setTitle(getString(R.string.product_detail));
        mToolbar.setNavigationIcon(R.drawable.back);
        mToolbar.setNavigationOnClickListener(view -> finish());

    }
}
