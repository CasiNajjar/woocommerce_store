package id.co.next_innovation.store.ui.shop.product;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.data.db.model.Product;
import id.co.next_innovation.store.ui.base.BaseViewHolder;
import id.co.next_innovation.store.utils.CommonUtils;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class ProductAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<Product> products;
    private int lastPosition = -1;

    public ProductAdapter(List<Product> mProd) {
        //mAnimator = new RecyclerViewAnimator(mRecyclerView);
        products = mProd;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (products != null && products.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (products != null && products.size() > 0) {
            return products.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<Product> productList) {
        products.addAll(productList);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onProductSelected(int product_id);
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.product_image)
        ImageView mImageView;
        @BindView(R.id.product_name)
        TextView mName;
        @BindView(R.id.product_price)
        TextView mRegulerPrice;
        @BindView(R.id.product_cut_price)
        TextView mSalePrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            mImageView.setImageDrawable(null);
            mName.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final Product product = products.get(position);

            if (product.getImages()!=null) {
                Picasso.with(itemView.getContext())
                        .load(product.getImages().get(0).getSrc())
                        .error(R.drawable.category_placeholder)
                        .placeholder(R.drawable.anim_image_placeholder )
                        .into(mImageView);
            }

            if (product.getName()!=null) {
                mName.setText(product.getName());
            }

            if (product.getRegularPrice()!=null || !product.getRegularPrice().isEmpty()) {
                mRegulerPrice.setText(product.getRegularPrice());
            }
            if (product.getSalePrice()!=null || !product.getSalePrice().isEmpty()) {
                mSalePrice.setText(product.getSalePrice());
            }

            itemView.setOnClickListener(view -> {
                if (product.getId()!=null) {
                    mCallback.onProductSelected(product.getId());
                }
            });
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }
    }


}
