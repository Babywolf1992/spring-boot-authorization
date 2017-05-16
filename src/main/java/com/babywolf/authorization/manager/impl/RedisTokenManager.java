package com.babywolf.authorization.manager.impl;

import com.babywolf.authorization.manager.TokenManager;
import com.babywolf.authorization.model.TokenModel;
import org.springframework.stereotype.Component;

/**
 * Created by babywolf on 17/5/16.
 */
@Component
public class RedisTokenManager implements TokenManager {
    @Override
    public TokenModel createToken(long userId) {
        return null;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        return false;
    }

    @Override
    public TokenModel getToken(String authentication) {
        return null;
    }

    @Override
    public void deleteToken(long userId) {

    }
}
