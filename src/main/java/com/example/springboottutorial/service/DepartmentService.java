package com.example.springboottutorial.service;

import java.util.List;
import com.example.springboottutorial.entity.Department;

public interface DepartmentService {

    public Department saveDepartment(Department department);
    public List<Department> getAllDepartments();
    public Department getDepartmentById(Long id);
    public void deleteDepartmentById(Long id);
    public Department updateDepartmentById(Long id, Department department);
    
}
