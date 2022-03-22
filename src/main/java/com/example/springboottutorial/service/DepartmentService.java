package com.example.springboottutorial.service;

import java.util.List;
import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.error.DepartmentNotFoundException;

public interface DepartmentService {

    public Department saveDepartment(Department department);
    public List<Department> getAllDepartments();
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException;
    public void deleteDepartmentById(Long id);
    public Department updateDepartmentById(Long id, Department department);
    public Department getDepartmentByName(String name);
    
}
