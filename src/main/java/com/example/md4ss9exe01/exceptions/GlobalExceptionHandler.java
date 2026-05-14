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
    public ResponseEntity<ApiResponse<Map<String,String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String,String> map = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(e -> {
            String fieldName = ((FieldError) e).getField();
            String value = e.getDefaultMessage();
            map.put(fieldName, value );
        });
        ApiResponse<Map<String,String>> apiResponse = new ApiResponse<>();
        apiResponse.setData(map);
        apiResponse.setStatus("FAIL");
        apiResponse.setMessage("Dữ liệu không hợp lệ");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class )
    public ResponseEntity<ApiResponse<Map<String,String>>> handleResourceNotFoundException(ResourceNotFoundException exception){
        Map<String,String> map = new HashMap<>();
        map.put("message", exception.getMessage());
        ApiResponse<Map<String,String>> apiResponse = new ApiResponse<>();
        apiResponse.setData(map);
        apiResponse.setStatus("FAIL");
        apiResponse.setMessage("Dữ liệu không hợp lệ");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @ExceptionHandler(DuplicateException.class )
    public ResponseEntity<ApiResponse<Map<String,String>>> handleDuplicateException(DuplicateException exception){
        Map<String,String> map = new HashMap<>();
        map.put("message", exception.getMessage());
        ApiResponse<Map<String,String>> apiResponse = new ApiResponse<>();
        apiResponse.setData(map);
        apiResponse.setStatus("FAIL");
        apiResponse.setMessage("Dữ liệu trùng lặp");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleCustomException(CustomException exception){
        Map<String,String> map = new HashMap<>();
        map.put("message", exception.getMessage());
        ApiResponse<Map<String,String>> apiResponse = new ApiResponse<>();
        apiResponse.setData(map);
        apiResponse.setStatus("FAIL");
        apiResponse.setMessage("Lỗi hệ thống");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }
}
