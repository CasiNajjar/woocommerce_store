package id.co.next_innovation.store.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.co.next_innovation.store.data.db.model.Billing;
import id.co.next_innovation.store.data.db.model.Links;
import id.co.next_innovation.store.data.db.model.Shipping;
import id.co.next_innovation.store.data.db.model.User;


/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class SignResponse {

    private SignResponse() {

    }

    public static class In {
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("cookie")
        @Expose
        private String cookie;
        @SerializedName("cookie_name")
        @Expose
        private String cookieName;
        @SerializedName("user")
        @Expose
        private User user;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCookie() {
            return cookie;
        }

        public void setCookie(String cookie) {
            this.cookie = cookie;
        }

        public String getCookieName() {
            return cookieName;
        }

        public void setCookieName(String cookieName) {
            this.cookieName = cookieName;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

    }

    public static class Up {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("date_created")
        @Expose
        private String dateCreated;
        @SerializedName("date_created_gmt")
        @Expose
        private String dateCreatedGmt;
        @SerializedName("date_modified")
        @Expose
        private String dateModified;
        @SerializedName("date_modified_gmt")
        @Expose
        private String dateModifiedGmt;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("role")
        @Expose
        private String role;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("billing")
        @Expose
        private Billing billing;
        @SerializedName("shipping")
        @Expose
        private Shipping shipping;
        @SerializedName("is_paying_customer")
        @Expose
        private Boolean isPayingCustomer;
        @SerializedName("orders_count")
        @Expose
        private Integer ordersCount;
        @SerializedName("total_spent")
        @Expose
        private String totalSpent;
        @SerializedName("avatar_url")
        @Expose
        private String avatarUrl;
        @SerializedName("meta_data")
        @Expose
        private List<Object> metaData = null;
        @SerializedName("_links")
        @Expose
        private Links links;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
        }

        public String getDateCreatedGmt() {
            return dateCreatedGmt;
        }

        public void setDateCreatedGmt(String dateCreatedGmt) {
            this.dateCreatedGmt = dateCreatedGmt;
        }

        public String getDateModified() {
            return dateModified;
        }

        public void setDateModified(String dateModified) {
            this.dateModified = dateModified;
        }

        public String getDateModifiedGmt() {
            return dateModifiedGmt;
        }

        public void setDateModifiedGmt(String dateModifiedGmt) {
            this.dateModifiedGmt = dateModifiedGmt;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Billing getBilling() {
            return billing;
        }

        public void setBilling(Billing billing) {
            this.billing = billing;
        }

        public Shipping getShipping() {
            return shipping;
        }

        public void setShipping(Shipping shipping) {
            this.shipping = shipping;
        }

        public Boolean getIsPayingCustomer() {
            return isPayingCustomer;
        }

        public void setIsPayingCustomer(Boolean isPayingCustomer) {
            this.isPayingCustomer = isPayingCustomer;
        }

        public Integer getOrdersCount() {
            return ordersCount;
        }

        public void setOrdersCount(Integer ordersCount) {
            this.ordersCount = ordersCount;
        }

        public String getTotalSpent() {
            return totalSpent;
        }

        public void setTotalSpent(String totalSpent) {
            this.totalSpent = totalSpent;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public List<Object> getMetaData() {
            return metaData;
        }

        public void setMetaData(List<Object> metaData) {
            this.metaData = metaData;
        }

        public Links getLinks() {
            return links;
        }

        public void setLinks(Links links) {
            this.links = links;
        }
    }
}
