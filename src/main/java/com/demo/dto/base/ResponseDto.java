package com.demo.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
    private int code = 1;
    private String message = "Success";
    private T data;
    private List<T> datas;

    public ResponseDto(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
