package com.example.md4ss9exe01.exceptions;

import com.example.md4ss9exe01.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>>
    handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        for (FieldError error :
                ex.getBindingResult().getFieldErrors()) {

            errors.put(
                    error.getField(),
                    error.getDefaultMessage()
            );
        }

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "FAIL",
                        "Dữ liệu không hợp lệ",
                        errors
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>>
    handleException(Exception ex) {

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "FAIL",
                        "Internal Server Error",
                        null
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
