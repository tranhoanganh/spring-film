package com.demo.service;

import com.demo.dto.entitydto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAllComment();
    CommentDto postComment(CommentDto commentDto);
}
