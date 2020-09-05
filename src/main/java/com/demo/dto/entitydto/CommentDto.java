package com.demo.dto.entitydto;

import com.demo.dto.base.BaseDto;
import com.demo.entity.FilmEntity;
import com.demo.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto extends BaseDto {

    private Integer userid;
    private Integer filmid;
    private String content;
//    private FilmDto film;
    private UserDto user;

}
