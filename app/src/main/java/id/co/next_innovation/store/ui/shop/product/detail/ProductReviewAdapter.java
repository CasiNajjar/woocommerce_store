package id.co.next_innovation.store.ui.shop.product.detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.data.db.model.Review;
import id.co.next_innovation.store.ui.base.BaseViewHolder;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class ProductReviewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<Review> reviews;
    private int lastPosition = -1;

    public ProductReviewAdapter(List<Review> mReviews) {
        //mAnimator = new RecyclerViewAnimator(mRecyclerView);
        reviews = mReviews;
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
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_review, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_review, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (reviews != null && reviews.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (reviews != null && reviews.size() > 0) {
            return reviews.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<Review> reviewList) {
        reviews.addAll(reviewList);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onReviewSelected(int review_id);
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.reviewer_name)
        TextView mReviewerName;
        @BindView(R.id.review_date)
        TextView mReviewDate;
        @BindView(R.id.review_text)
        TextView mReview;
        @BindView(R.id.ratingbar)
        RatingBar mRatingBar;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            mReviewerName.setText("");
            mReview.setText("");
            mReviewDate.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final Review review = reviews.get(position);

            if (review.getName()!=null) {
                mReviewerName.setText(review.getName());
            }
            if (!review.getDateCreated().isEmpty() || review.getDateCreated()!=null) {
                mReviewDate.setText(review.getDateCreated());
            }
            if (!review.getReview().isEmpty() || review.getReview()!=null) {
                mReview.setText(review.getReview());
                mRatingBar.setRating(review.getRating());
            }
            itemView.setOnClickListener(view -> {
                if (review.getId()!=null) {

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
