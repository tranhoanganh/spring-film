package com.demo.service;

import com.demo.dto.FilmDto;
import com.demo.dto.MapperDto;
import com.demo.entity.FilmEntity;
import com.demo.repository.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmRepo filmRepo;

    @Autowired
    MapperDto mapperDto;

    @Override
    public List<FilmDto> findAllFilm() {
        List<FilmEntity> list = filmRepo.findAll();
        List<FilmDto> listDto = list.stream()
                .map(x -> mapperDto.convertToDto(x))
                .collect(Collectors.toList());
        return listDto;
    }

    @Override
    public List<FilmDto> listTrending() {
        List<FilmEntity> list = filmRepo.findAllByOrderByViewDesc();
        List<FilmDto> listDto = list.stream()
                .map(x -> mapperDto.convertToDto(x))
                .collect(Collectors.toList());
        return listDto;
    }

    @Override
    public List<FilmDto> listHot() {
        List<FilmEntity> list = filmRepo.findAllByOrderByViewAsc();
        List<FilmDto> listDto = list.stream()
                .map(x -> mapperDto.convertToDto(x))
                .collect(Collectors.toList());
        return listDto;
    }

    @Override
    public List<FilmDto> listSuggest() {
        List<FilmEntity> list = filmRepo.findAllByOrderByNameAsc();
        List<FilmDto> listDto = list.stream()
                .map(x -> mapperDto.convertToDto(x))
                .collect(Collectors.toList());
        return listDto;
    }

    @Override
    public List<FilmDto> listWatch() {
        List<FilmEntity> list = filmRepo.findAllByOrderByNameDesc();
        List<FilmDto> listDto = list.stream()
                .map(x -> mapperDto.convertToDto(x))
                .collect(Collectors.toList());
        return listDto;
    }
}
