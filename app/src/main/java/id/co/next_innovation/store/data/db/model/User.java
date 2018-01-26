package id.co.next_innovation.store.data.db.model;

import org.greenrobot.greendao.annotation.Entity;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "user")
public class User {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("nicename")
    @Expose
    private String nicename;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("registered")
    @Expose
    private String registered;
    @SerializedName("displayname")
    @Expose
    private String displayname;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("capabilities")
    @Expose
    private String capabilities;
    @SerializedName("avatar")
    @Expose
    private String avatar;

    @Generated(hash = 2019123343)
    public User(Integer id, String username, String nicename, String email,
            String url, String registered, String displayname, String firstname,
            String lastname, String nickname, String description,
            String capabilities, String avatar) {
        this.id = id;
        this.username = username;
        this.nicename = nicename;
        this.email = email;
        this.url = url;
        this.registered = registered;
        this.displayname = displayname;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.description = description;
        this.capabilities = capabilities;
        this.avatar = avatar;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNicename() {
        return nicename;
    }

    public void setNicename(String nicename) {
        this.nicename = nicename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
