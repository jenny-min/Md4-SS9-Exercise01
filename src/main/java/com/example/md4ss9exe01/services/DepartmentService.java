package com.example.md4ss9exe01.services;

import com.example.md4ss9exe01.dto.DepartmentDTO;
import com.example.md4ss9exe01.models.Department;
import com.example.md4ss9exe01.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository dr;

    public List<Department> findAll() {
        return dr.findAll();
    }

    public Department addDepartment(DepartmentDTO dto) {
        Department d = new Department();
        d.setName(dto.getName());
        d.setDescription(dto.getDescription());
        return dr.save(d);
    }
}
