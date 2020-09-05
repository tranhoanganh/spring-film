package com.demo.dto.response;

import com.demo.dto.entitydto.FilmDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
