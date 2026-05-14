package com.example.md4ss9exe01.models;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private String avatarUrl ;

    public Employee() {
    }

    public Employee(Long id, String fullName, String email, String phone, double salary, Department department, String avatarUrl) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
        this.avatarUrl = avatarUrl;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public String getAvatarUrl() {return avatarUrl;}

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
