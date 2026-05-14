package com.example.md4ss9exe01.services;

import com.example.md4ss9exe01.dto.EmployeeCreateDTO;
import com.example.md4ss9exe01.models.Department;
import com.example.md4ss9exe01.models.Employee;
import com.example.md4ss9exe01.repositories.DepartmentRepository;
import com.example.md4ss9exe01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository er;

    @Autowired
    private DepartmentRepository dr;

    public List<Employee> findAll() {
        return er.findAll();
    }

    public Employee addEmployee(EmployeeCreateDTO employeeCreateDTO) {
        //B1: Kiểm tra phòng ban có tồn tại hay không
        Optional<Department> department = dr.findById(employeeCreateDTO.getDepartmentId());
        if (department.isEmpty()) {
            throw new RuntimeException("Phòng ban không tồn tại");
        }

        //B2: kiểm tra email nhân viên có tồn tại không
        Object isEmailExist = er.findByEmail(employeeCreateDTO.getEmail());
        if (isEmailExist == null) {
            throw new RuntimeException("Email này đã tồn tại");
        }

        //B3: Tạo và lưu nhân viên mới
        Employee emp = new Employee();
        emp.setFullName(employeeCreateDTO.getFullName());
        emp.setEmail(employeeCreateDTO.getEmail());
        emp.setPhone(employeeCreateDTO.getPhone());
        emp.setSalary(employeeCreateDTO.getSalary());
        emp.setDepartment(department.get());

        return er.save(emp);
    }
}
