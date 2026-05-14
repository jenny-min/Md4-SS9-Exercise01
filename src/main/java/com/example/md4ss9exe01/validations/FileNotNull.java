package com.example.md4ss9exe01.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {CheckFileNotNull.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FileNotNull {
    String message() default "Yêu cầu file là pdf và không đc để trống";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
