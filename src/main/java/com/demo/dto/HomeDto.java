package com.demo.dto;

import com.demo.entity.CastEntity;
import com.demo.entity.CategoryEntity;
import com.demo.entity.CommentEntity;
import com.demo.entity.DirectorEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeDto {

    private List<FilmDto> listTrending;
    private List<FilmDto> listHot;
    private List<FilmDto> listSuggest;
    private List<FilmDto> listWatch;


}
