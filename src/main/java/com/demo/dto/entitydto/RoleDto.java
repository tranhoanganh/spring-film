package com.demo.dto.entitydto;

import com.demo.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto extends BaseDto {
    private String image;
}
