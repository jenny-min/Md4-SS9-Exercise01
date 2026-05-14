package com.example.md4ss9exe01.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class CheckFileNotNull implements ConstraintValidator<FileNotNull, MultipartFile> {
    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
