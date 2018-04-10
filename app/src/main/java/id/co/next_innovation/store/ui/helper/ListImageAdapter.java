package id.co.next_innovation.store.ui.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import id.co.next_innovation.store.R;
import id.co.next_innovation.store.ui.shop.product.detail.images.DetailImageActivity;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class ListImageAdapter extends PagerAdapter {

    private ArrayList<String> images;
    private LayoutInflater inflater;
    private Context context;

    public ListImageAdapter(Context mContext, ArrayList<String> mImages) {
        context = mContext;
        images = mImages;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.sliding_images, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.product_images);

        Picasso.with(context)
                .load(images.get(position))
                .error(R.drawable.category_placeholder)
                .placeholder(R.drawable.anim_image_placeholder )
                .into(imageView);

        view.addView(imageLayout, 0);

        imageView.setOnClickListener(view1 -> {
            Intent i = new Intent(context, DetailImageActivity.class);
            i.putStringArrayListExtra("images", images);
            context.startActivity(i);
        });
        return imageLayout;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}
