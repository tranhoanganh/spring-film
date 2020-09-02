package com.demo.repository;

import com.demo.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepo extends JpaRepository<FilmEntity, Integer> {
    List<FilmEntity> findAllByOrderByViewDesc();
    List<FilmEntity> findAllByOrderByViewAsc();
    List<FilmEntity> findAllByOrderByNameDesc();
    List<FilmEntity> findAllByOrderByNameAsc();
}
