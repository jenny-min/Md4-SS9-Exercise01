package com.example.md4ss9exe01.dto;

import com.example.md4ss9exe01.models.Department;
import jakarta.validation.constraints.*;

public class EmployeeCreateDTO {
    @NotBlank(message = "Tên nhân viên không được để trống")
    private String fullName;

    @Email(message = "Email phải đúng định dạng")
    private String email;

    @Pattern(regexp = "^(03|05|07|08|09)\\d{8}$", message = "Số điện thoại không hợp lệ")
    private String phone;

    @Min(5000000)
    private double salary;

    @NotNull(message = "Phòng ban không được để trống")
    private Long departmentId;

    public EmployeeCreateDTO() {
    }

    public EmployeeCreateDTO(String fullName, String email, String phone, double salary, Long departmentId) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.departmentId = departmentId;
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

    public Long getDepartmentId() {
        return departmentId;
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

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
