package com.babywolf.authorization.manager;

import com.babywolf.authorization.model.TokenModel;

/**
 * Created by babywolf on 17/5/16.
 */
public interface TokenManager {

    public TokenModel createToken(long userId);

    public boolean checkToken(TokenModel model);

    public TokenModel getToken(String authentication);

    public void deleteToken(long userId);
}
