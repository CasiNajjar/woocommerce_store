package id.co.next_innovation.store.ui.shop.category;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.next_innovation.store.R;
import id.co.next_innovation.store.data.db.model.Category;
import id.co.next_innovation.store.ui.base.BaseViewHolder;
import id.co.next_innovation.store.utils.AppLogger;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class CategoryAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<Category> categories;
    private int lastPosition = -1;

    public CategoryAdapter(List<Category> mCat) {
        //mAnimator = new RecyclerViewAnimator(mRecyclerView);
        categories = mCat;
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
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home_category, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home_category, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (categories != null && categories.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        AppLogger.e("LOG = "+categories.size());
        if (categories != null && categories.size() > 0) {
            return categories.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<Category> categoryList) {
        categories.addAll(categoryList);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onMenuEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.category_image)
        ImageView mImageView;
        @BindView(R.id.category_name)
        TextView mName;


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

            final Category category = categories.get(position);

            if (category.getImage()!=null) {
                Picasso.with(itemView.getContext())
                        .load(category.getImage().getSrc())
                        .error(R.drawable.category_placeholder)
                        .placeholder(R.drawable.anim_image_placeholder )
                        .into(mImageView);
            }

            if (category.getName()!=null) {
                mName.setText(category.getName());
            }

            itemView.setOnClickListener(view -> {
                if (category.getId()!=null) {
//                    Intent intent = new Intent(itemView.getContext(), DetailActivty.class);
//                    intent.putExtra("name", category.getName());
//                    intent.putExtra("description", category.getDescription());
//                    intent.putExtra("image", category.getImage());
//                    itemView.getContext().startActivity(intent);
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
