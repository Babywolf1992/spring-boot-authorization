package com.babywolf.authorization.manager.impl;

import com.babywolf.authorization.manager.TokenManager;
import com.babywolf.authorization.model.TokenModel;
import com.babywolf.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by babywolf on 17/5/16.
 */
@Component
public class RedisTokenManager implements TokenManager {
    private RedisTemplate<Long, String> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
    }

    @Override
    public TokenModel createToken(long userId) {
        String token = UUID.randomUUID().toString().replace("-","");
        TokenModel model = new TokenModel(userId, token);
        redisTemplate.boundValueOps(userId).set(token, Constants.TOKEN_EXPIRES_HOUR,TimeUnit.HOURS);
        return model;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = redisTemplate.boundValueOps(model.getUserId()).get();
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        redisTemplate.boundValueOps(model.getUserId()).expire(Constants.TOKEN_EXPIRES_HOUR,TimeUnit.HOURS);
        return true;
    }

    @Override
    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        long userid = Long.parseLong(param[0]);
        String token = param[1];
        return new TokenModel(userid, token);
    }

    @Override
    public void deleteToken(long userId) {
        redisTemplate.delete(userId);
    }
}
