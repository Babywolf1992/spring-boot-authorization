package com.babywolf.authorization.model;

/**
 * Created by babywolf on 17/5/16.
 */
public class TokenModel {
    private long userId;

    private String token;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenModel(long userId, String token) {
        this.userId = userId;
        this.token = token;
    }
}
