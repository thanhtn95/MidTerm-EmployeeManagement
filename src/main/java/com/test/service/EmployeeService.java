package com.test.service;

import com.test.model.Department;
import com.test.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void save(Employee employee);
    void delete(int id);
    Employee findById(int id);
    Page<Employee>findAllByDepartment(Pageable pageable, Department department);
    Page<Employee> findAllByOrderBySalaryAsc(Pageable pageable);
    Page<Employee> findAllByOrderBySalaryDesc(Pageable pageable);
}
