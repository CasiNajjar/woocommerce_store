package id.co.next_innovation.store.ui.shop.product.detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.data.db.model.Product;
import id.co.next_innovation.store.data.db.model.ProductDetail;
import id.co.next_innovation.store.ui.base.BaseActivity;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class ProductDetailActivity extends BaseActivity implements ProductDetailView {

    @Inject
    ProductDetailMvpPresenter<ProductDetailView> mPresenter;

    @BindView(R.id.toolbar_title)
    TextView mTitle;

    @BindView(R.id.product_image)
    ImageView mImageView;

    @BindView(R.id.product_name)
    TextView mProductName;

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
        mTitle.setText(getString(R.string.product_detail));

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        int product_id = bundle.getInt("product_id");

        mPresenter.fetchProductDetail(product_id);
    }

    @Override
    public void showProductDetail(ProductDetail product) {
        mProductName.setText(product.getName());
        Picasso.with(this)
                .load(product.getImages().get(0).getSrc())
                .error(R.drawable.category_placeholder)
                .placeholder(R.drawable.anim_image_placeholder )
                .into(mImageView);
    }
}
