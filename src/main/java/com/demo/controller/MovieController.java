package com.demo.controller;

import com.demo.dto.FilmDto;
import com.demo.dto.HomeDto;
import com.demo.dto.ResponseDto;
import com.demo.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    FilmService filmService;

    @GetMapping("/home")
    public ResponseEntity getHome() {
        ResponseDto<HomeDto> res = new ResponseDto<>();
        List<FilmDto> list = filmService.findAllFilm();
        HomeDto homeDto = new HomeDto();
        homeDto.setListTrending(filmService.listTrending());
        homeDto.setListHot(filmService.listHot());
        homeDto.setListSuggest(filmService.listSuggest());
        homeDto.setListWatch(filmService.listWatch());
        res.setData(homeDto);
        return ResponseEntity.ok(res);
    }
}
