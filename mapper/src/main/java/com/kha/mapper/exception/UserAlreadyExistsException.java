package com.kha.mapper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String fieldName, String fieldValue) {
        super(String.format("User Already Exists with %s : %s", fieldName, fieldValue));
    }
}
