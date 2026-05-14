package com.example.md4ss9exe01.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DepartmentDTO {
    @NotNull
    @Size(min = 5, max = 50)
    private String name;

    @Size(max = 100)
    private String description;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
