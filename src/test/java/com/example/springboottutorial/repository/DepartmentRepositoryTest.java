package com.example.springboottutorial.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.springboottutorial.entity.Department;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class DepartmentRepositoryTest {

    private final DepartmentRepository departmentRepository;
    private final TestEntityManager entityManager;

    @Autowired
    public DepartmentRepositoryTest(DepartmentRepository departmentRepository,
        TestEntityManager entityManager) {

        this.departmentRepository = departmentRepository;
        this.entityManager = entityManager;
    }

    @BeforeEach
    void setup() {
        Department department = new Department("Mechanical Engineering", 
        "1R", "Mech");

        entityManager.persist(department);
    }

    @Test
    public void whenFindDepartmentById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals("Mechanical Engineering", department.getDepartmentName());
    }

    
}
