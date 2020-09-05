package com.demo.dto.entitydto;

import com.demo.dto.base.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {

    @NotBlank(message = "Username is not blank!")
    private String username;

    @JsonIgnore
    private String password;

    private String token;

    private List<RoleDto> roles;

}
