package com.example.springboottutorial.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.contains;

import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.repository.DepartmentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class DepartmentServiceTest {

    private final DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    public DepartmentServiceTest(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @BeforeEach
    void setup() {
        Department department = new Department();
        department.setDepartmentId(1L);
        department.setDepartmentName("Information Technology");
        department.setDepartmentAddress("3L");
        department.setDepartmentCode("IT");

        Mockito.when(departmentRepository.findByDepartmentName("Information Technology"))
            .thenReturn(department);
    }

    @Test
    @DisplayName(value = "Get department info when provided only departmentName")
    public void whenValidDepartmentName_ThenDepartmentShouldFound() {
        String departmentName = "Information Technology";
        Department fetchedDepartment = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, fetchedDepartment.getDepartmentName());
    }

}
