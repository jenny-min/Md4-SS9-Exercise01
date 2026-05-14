package com.example.md4ss9exe01.controllers;

import com.example.md4ss9exe01.dto.DepartmentDTO;
import com.example.md4ss9exe01.models.Department;
import com.example.md4ss9exe01.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService ds;

    @GetMapping
    @ResponseBody
    public List<Department> getAllDepartments() {
        return ds.findAll();
    }

    @PostMapping
    @ResponseBody
    public Department createDerpartement(@Valid @RequestBody DepartmentDTO dto) {
        return ds.addDepartment(dto);
    }
}
