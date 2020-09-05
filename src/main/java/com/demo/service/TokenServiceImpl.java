package com.demo.service;

import com.demo.entity.RoleEntity;
import com.demo.entity.TokenEntity;
import com.demo.entity.UserEntity;
import com.demo.repository.TokenRepo;
import com.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService{

    @Autowired
    TokenRepo tokenRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public UserEntity findUserByToken(String token) {
        TokenEntity tokenEntity = tokenRepo.findByToken(token);
        if (tokenEntity != null) {
//            List<RoleEntity> roles = userRepo.findRoles(tokenEntity.getUser().getId());
//            tokenEntity.getUser().setRoles(roles);
            return tokenEntity.getUser();
        }
        return null;
    }

    @Override
    public TokenEntity createToken(int userID) {
        TokenEntity tokenEntity = new TokenEntity();
        String token = UUID.randomUUID().toString()+System.currentTimeMillis();
        tokenEntity.setToken(token);
        tokenEntity.setUserid(userID);
        tokenEntity.setExpire(30);
        return tokenRepo.save(tokenEntity);
    }
}
