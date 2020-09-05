package com.demo.service;

import com.demo.dto.entitydto.CastDto;
import com.demo.dto.entitydto.FilmDto;

import java.util.List;

public interface FilmService {
    List<FilmDto> findAllFilm();
    List<FilmDto> listTrending();
    List<FilmDto> listSuggest();
    List<FilmDto> listHot();
    List<FilmDto> listWatch();
    List<FilmDto> getFilmByCategory(int id);
    List<CastDto> getAllCastById(int id);

}
