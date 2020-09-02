package com.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {

    @NotBlank(message = "Username is not blank!")
    private String username;

    @NotBlank(message = "Password is not blank!")
    @Size(min = 6, message = "Password must be greater than 6 characters")
    @Column(name = "password")
    private String password;

    private String token;

    private List<RoleDto> roles;

}
