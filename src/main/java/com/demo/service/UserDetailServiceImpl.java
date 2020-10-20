package com.demo.service;

import com.demo.entity.RoleEntity;
import com.demo.entity.UserEntity;
import com.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        if (userEntity.getRoles() != null && userEntity.getRoles().size() > 0) {
            for (RoleEntity role : userEntity.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }

        return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
    }
}
