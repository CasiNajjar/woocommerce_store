package id.co.next_innovation.store.ui.shop.product.detail.images;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.ui.base.BaseActivity;
import id.co.next_innovation.store.ui.helper.ListImageAdapter;
import me.relex.circleindicator.CircleIndicator;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class DetailImageActivity extends BaseActivity implements DetailImageView {

    @Inject
    DetailImageMvpPresenter<DetailImageView> mPresenter;

    @BindView(R.id.viewpager_detail_images)
    ViewPager mViewPager;
    @BindView(R.id.indicator)
    CircleIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_images);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();

    }

    @Override
    protected void setUp() {

        ArrayList<String> images = getIntent().getStringArrayListExtra("images");

        mViewPager.setAdapter(new ListImageAdapter(this, images));
        mIndicator.setViewPager(mViewPager);
    }


}
