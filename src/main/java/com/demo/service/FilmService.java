package com.demo.service;

import com.demo.dto.FilmDto;

import java.util.List;

public interface FilmService {
    public List<FilmDto> findAllFilm();
    public List<FilmDto> listTrending();
    public List<FilmDto> listSuggest();
    public List<FilmDto> listHot();
    public List<FilmDto> listWatch();

}
