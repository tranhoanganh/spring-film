package com.demo.dto.entitydto;

import com.demo.dto.base.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto extends BaseDto {

    private String image;

//    @JsonIgnore
    private List<FilmDto> movies;

}
