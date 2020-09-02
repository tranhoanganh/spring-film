package com.demo.controller;

import com.demo.dto.MapperDto;
import com.demo.dto.UserDto;
import com.demo.entity.UserEntity;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MapperDto mapperDto;

    @GetMapping("/")
    public String index() {
        return "Hello";
    }

    @PostMapping("/api/register")
    public ResponseEntity register(@Valid @RequestBody UserEntity userEntity) {
        UserEntity user = userService.saveUser(userEntity);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/api/user")
    public ResponseEntity getAllUser() {
        List<UserEntity> list = userService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/public")
    public String demo() {
        return "public";
    }

    @PostMapping("/token")
    public ResponseEntity getToken(@RequestParam("username") String username, @RequestParam("password") String password) {
        UserEntity userEntity = userService.login(username, password);
        if (userEntity == null) {
            return ResponseEntity.ok("Username or password invalid");
        }
        return ResponseEntity.ok(userEntity);
    }

    @PostMapping("/api/login")
    public ResponseEntity login(@Valid @RequestBody UserDto userDto) {
        UserEntity userEntity = userService.login(userDto.getUsername(), userDto.getPassword());
        UserDto user = mapperDto.convertToDto(userEntity);
        if (user == null) {
            return ResponseEntity.ok("Username or password invalid");
        }
        return ResponseEntity.ok(user);
    }

}
