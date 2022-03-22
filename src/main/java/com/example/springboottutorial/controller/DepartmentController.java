package com.example.springboottutorial.controller;

import java.util.List;
import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.service.DepartmentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.GET)
    public Department getDepartmentById(@PathVariable(value = "id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.DELETE)
    public String deleteDepartmentById(@PathVariable(value = "id") Long id) {
        departmentService.deleteDepartmentById(id);
        return "Department with id: " + id + " deleted.";
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.PUT)
    public Department updateDepartmentById(
        @PathVariable(value = "id") Long id,
        @RequestBody Department department) {

        return departmentService.updateDepartmentById(id, department);
    }

    @RequestMapping(value = "/departments/names/{name}")
    public Department getDepartmentByName(@PathVariable(value = "name") String name) {
        return departmentService.getDepartmentByName(name);
    }
    
}
