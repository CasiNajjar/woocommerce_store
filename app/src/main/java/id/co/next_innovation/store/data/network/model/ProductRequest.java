package id.co.next_innovation.store.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class ProductRequest {

    private ProductRequest() {

    }

    public static class Featured {

    }

    public static class Products {

    }

    public static class ProductDetail {
        @SerializedName("product_id")
        @Expose
        private int product_id;

        public ProductDetail(int product_id) {
            this.product_id = product_id;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }
    }

    public static class ProductByCategory {
        @SerializedName("category")
        @Expose
        private int category;

        public ProductByCategory(int category) {
            this.category = category;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }
    }


    public static class Categories {

    }
}
