package com.test.service;

import com.test.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {
    Page<Department> findAll(Pageable pageable);
    void save(Department department);
    Department findById(int id);
    void delete(int id);
}
