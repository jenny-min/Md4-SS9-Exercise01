package com.example.md4ss9exe01.dto;

import org.springframework.web.multipart.MultipartFile;

public class EmployeeUploadImageDTO {
    private MultipartFile image;

    public EmployeeUploadImageDTO() {
    }

    public EmployeeUploadImageDTO(MultipartFile image) {this.image = image;}

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
