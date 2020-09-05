package com.demo.controller;

import com.demo.dto.entitydto.CastDto;
import com.demo.dto.entitydto.CategoryDto;
import com.demo.dto.entitydto.FilmDto;
import com.demo.dto.response.HomeDto;
import com.demo.dto.base.ResponseDto;
import com.demo.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
        HomeDto homeDto = new HomeDto();
        homeDto.setListTrending(filmService.listTrending());
        homeDto.setListHot(filmService.listHot());
        homeDto.setListSuggest(filmService.listSuggest());
        homeDto.setListWatch(filmService.listWatch());
        res.setData(homeDto);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/category")
    public ResponseEntity getFilmByCategoryId(@Param("id") int id) {
        ResponseDto<FilmDto> res = new ResponseDto<>();
        res.setDatas(filmService.getFilmByCategory(id));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/cast")
    public ResponseEntity getCastById(@Param("filmid") int filmid) {
        ResponseDto<CastDto> res = new ResponseDto<>();
        res.setDatas(filmService.getAllCastById(filmid));
        return ResponseEntity.ok(res);
    }
}
