package com.kha.mapper.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleUserAlreadyExistsException(UserAlreadyExistsException exception,
                                                                         WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_ALREADY_EXISTS");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException exception,
                                                                    WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGeneralException(Exception exception,
                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL_SERVER_ERROR"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers,
                                                               HttpStatusCode status,
                                                               WebRequest request) {
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        Map<String, List<String>> errors = new HashMap<>();
        errorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            if (errors.containsKey(fieldName)){
                errors.get(fieldName).add(message);
            }else {
                errors.put(fieldName, new ArrayList<>());
                errors.get(fieldName).add(message);
            }
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
