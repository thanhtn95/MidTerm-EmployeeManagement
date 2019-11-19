package com.test.service.Impl;

import com.test.model.Department;
import com.test.repository.DepartmentRepository;
import com.test.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Page<Department> findAll(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        departmentRepository.delete(id);
    }
}
