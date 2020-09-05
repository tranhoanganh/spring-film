package com.demo.repository;

import com.demo.entity.RoleEntity;
import com.demo.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepo extends JpaRepository<TokenEntity, Integer> {
    TokenEntity findByToken(String token);
}
