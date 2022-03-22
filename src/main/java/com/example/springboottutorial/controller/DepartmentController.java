package com.example.springboottutorial.controller;

import java.util.List;
import javax.validation.Valid;
import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.error.DepartmentNotFoundException;
import com.example.springboottutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment function in DepartmentController class");
        return departmentService.saveDepartment(department);
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.GET)
    public Department getDepartmentById(@PathVariable(value = "id") Long id) throws DepartmentNotFoundException {
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
