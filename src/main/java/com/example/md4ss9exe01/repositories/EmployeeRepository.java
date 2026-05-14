package com.example.md4ss9exe01.repositories;

import com.example.md4ss9exe01.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Object> findByEmail(String email);
}

