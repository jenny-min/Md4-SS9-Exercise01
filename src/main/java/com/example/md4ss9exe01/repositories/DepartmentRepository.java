package com.example.md4ss9exe01.repositories;

import com.example.md4ss9exe01.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findById(Department departementId);
}
