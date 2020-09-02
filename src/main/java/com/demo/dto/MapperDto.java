package com.demo.dto;

import com.demo.entity.FilmEntity;
import com.demo.entity.RoleEntity;
import com.demo.entity.TokenEntity;
import com.demo.entity.UserEntity;
import org.mapstruct.*;

@Mapper(componentModel="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MapperDto {
//    MapperUtil INSTANCE = Mappers.getMapper(MapperUtil.class);

    //        List<UserDto> listDto = list.stream()
//                .map(x -> mapperDto.convertToDto(x))
//                .collect(Collectors.toList());

    UserDto convertToDto(UserEntity entity);
    UserEntity convertToEntity(UserDto dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity updateWithNullAsNoChange(UserDto dto, @MappingTarget UserEntity entityInDB);

    TokenDto convertToDto(TokenEntity entity);
    TokenEntity convertToEntity(TokenDto dto);

    RoleDto convertToDto(RoleEntity entity);
    RoleEntity convertToEntity(RoleDto dto);

    FilmDto convertToDto(FilmEntity entity);
    FilmEntity convertToEntity(FilmDto dto);

}
