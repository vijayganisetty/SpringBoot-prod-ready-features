package com.practice.springboot.prod_ready_features.prod_ready_features.advice;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
