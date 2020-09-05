package com.demo.dto.entitydto;

import com.demo.config.Constant;
import com.demo.dto.base.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto extends BaseDto {
    private String thumbnail;
    private Integer categoryid;
    private Integer directorid;
    private String description;
    private Integer duration;
    private Integer view;
    private String url;
    private CategoryDto category;
    private DirectorDto director;
    private List<CastDto> casts;

//    @JsonIgnore
//    private List<CommentDto> comments;

    public String getThumbnail() {
        return Constant.LINK_MOVIES_IMAGE + thumbnail;
    }
}
