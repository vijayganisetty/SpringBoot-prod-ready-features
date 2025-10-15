package com.practice.springboot.prod_ready_features.prod_ready_features.advice;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class APIError {
    private LocalDateTime localDateTime;
    private String error;
    private HttpStatus status;

    public APIError(){
        this.localDateTime = LocalDateTime.now();
    }

    public APIError(String error, HttpStatus status){
        this();
        this.error = error;
        this.status= status;
    }
}
