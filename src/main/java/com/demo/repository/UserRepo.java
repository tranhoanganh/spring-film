package com.demo.repository;

import com.demo.entity.RoleEntity;
import com.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username, String password);
    UserEntity findByToken(String token);

    @Query("select c.roles from UserEntity c where c.id = :id")
    List<RoleEntity> findRoles(int id);
}
