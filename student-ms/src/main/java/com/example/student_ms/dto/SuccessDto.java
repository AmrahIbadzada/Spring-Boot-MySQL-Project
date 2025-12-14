package com.example.student_ms.dto;

import lombok.Data;

@Data
public class SuccessDto<T> {

    private String status;
    private T data;

    public SuccessDto(String status, T data) {
        this.status = status;
        this.data = data;
    }
}
