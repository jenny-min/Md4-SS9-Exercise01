package com.example.md4ss9exe01.services;

import com.example.md4ss9exe01.dto.EmployeeCreateDTO;
import com.example.md4ss9exe01.exceptions.CustomException;
import com.example.md4ss9exe01.exceptions.ResourceNotFoundException;
import com.example.md4ss9exe01.models.Department;
import com.example.md4ss9exe01.models.Employee;
import com.example.md4ss9exe01.repositories.DepartmentRepository;
import com.example.md4ss9exe01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

    public Employee updateAvatar(Long id , MultipartFile multipartFile){
        Employee employee = er.findById(id).orElse(null);
        if(employee == null){
            throw new ResourceNotFoundException("Không tìm thấy nhân viên");
        }
        if (multipartFile == null) {
            throw new CustomException("File aảnh không để trống");
        }
        // Tính kích thước của file ảnh gửi lên (tính theo MB)
        long sizeFile = multipartFile.getSize() / (1024*1024);
        // Kiểm tra xem kích thước file có lớn hơn 2MB ko ?
        if (sizeFile > 2 ){
            throw new CustomException("Kích thước file lớn hơn 2MB");
        }
        // Kiểm tra xem file gửi lên có phải là file ảnh hay ko ?
        String[] validContentTypes = {"image/jpeg", "image/png", "image/jpg"};
        boolean isValidImage = Arrays.stream(validContentTypes)
                .anyMatch(type -> type.equals(multipartFile.getContentType()));

        if(!isValidImage){
            throw new CustomException("Yêu cầu chỉ upload file ảnh");
        }
        return employee;
    }
}
