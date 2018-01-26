package id.co.next_innovation.store.data.network.model;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.co.next_innovation.store.data.db.model.Category;
import id.co.next_innovation.store.data.db.model.Links;

public class CategoryResponse {
//
//    @SerializedName("")
//    @Expose
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
