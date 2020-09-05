package com.demo.controller;

import com.demo.dto.base.ResponseDto;
import com.demo.dto.entitydto.CommentDto;
import com.demo.dto.entitydto.FilmDto;
import com.demo.entity.CommentEntity;
import com.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public ResponseEntity getAllComment() {
        ResponseDto<CommentDto> res = new ResponseDto<>();
        res.setDatas(commentService.getAllComment());
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity postComment(@RequestBody CommentDto commentDto) {
        ResponseDto<CommentDto> res = new ResponseDto<>();
        res.setData(commentService.postComment(commentDto));
        return ResponseEntity.ok(res);
    }
}
