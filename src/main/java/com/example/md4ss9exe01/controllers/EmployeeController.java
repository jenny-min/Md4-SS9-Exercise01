package com.example.md4ss9exe01.controllers;

import com.example.md4ss9exe01.dto.EmployeeCreateDTO;
import com.example.md4ss9exe01.models.Employee;
import com.example.md4ss9exe01.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService es;

    @GetMapping
    @ResponseBody
    public List<Employee> findAll() {
        return es.findAll();
    }

    @PostMapping
    @ResponseBody
    public Employee createEmployee(@Valid @RequestBody EmployeeCreateDTO dto) {
        return es.addEmployee(dto);
    }
}
