package com.demo.dto;

import com.demo.config.Constant;
import com.demo.entity.CastEntity;
import com.demo.entity.CategoryEntity;
import com.demo.entity.CommentEntity;
import com.demo.entity.DirectorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
    private Integer id;
    private String name;
    private String thumbnail;
    private String description;
    private Integer categoryid;
    private Integer directorid;
    private Integer duration;
    private Integer view;
    private String url;
    private java.sql.Timestamp createAt;
    private java.sql.Timestamp updateAt;
    private List<CastEntity> casts;
    private CategoryEntity category;
    private DirectorEntity director;
    private List<CommentEntity> comments;

    public String getThumbnail() {
        return Constant.LINK_MOVIES_IMAGE + thumbnail;
    }
}
