package com.demo.dto.entitydto;

import com.demo.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto extends BaseDto {
    private String token;
    private Integer userid;
    private Integer expire;
    private UserDto user;
}
