package com.demo.service;

import com.demo.dto.base.MapperDto;
import com.demo.dto.entitydto.RoleDto;
import com.demo.dto.entitydto.UserDto;
import com.demo.entity.RoleEntity;
import com.demo.entity.TokenEntity;
import com.demo.entity.UserEntity;
import com.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    TokenService tokenService;

    @Autowired
    MapperDto mapperDto;

    @Override
    public UserEntity login(String username, String password) {
        UserEntity user = userRepo.findByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(password, user.getPassword())) {
            TokenEntity s = tokenService.createToken(user.getId());
            user.setToken(s.getToken());
            return user;
        }
        return null;


    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passEncode = encoder.encode(userEntity.getPassword());
        userEntity.setPassword(passEncode);
        UserEntity user = userRepo.save(userEntity);
        TokenEntity s = tokenService.createToken(user.getId());
        user.setToken(s.getToken());
        return user;
    }

    @Override
    public List<UserDto> getAll() {
        List<UserEntity> list = userRepo.findAll();
        List<UserDto> listDto = list.stream()
                .map(x -> mapperDto.convertToDto(x))
                .collect(Collectors.toList());
        return listDto;
    }

    @Override
    public List<UserEntity> getAllUserEntity() {
        return userRepo.findAll();
    }

    @Override
    public List<RoleDto> findRoles(int id) {
        List<RoleEntity> list = userRepo.findRoles(id);
        List<RoleDto> listDto = list.stream()
                .map(x -> mapperDto.convertToDto(x))
                .collect(Collectors.toList());
        return listDto;
    }


}
