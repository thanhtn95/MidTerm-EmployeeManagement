package com.test.service.Impl;

import com.test.model.Department;
import com.test.model.Employee;
import com.test.repository.EmployeeRepository;
import com.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Page<Employee> findAllByDepartment(Pageable pageable, Department department) {
        return employeeRepository.findAllByDepartment(pageable,department);
    }

    @Override
    public Page<Employee> findAllByOrderBySalaryAsc(Pageable pageable) {
        return employeeRepository.findAllByOrderBySalaryAsc(pageable);
    }

    @Override
    public Page<Employee> findAllByOrderBySalaryDesc(Pageable pageable) {
        return employeeRepository.findAllByOrderBySalaryDesc(pageable);
    }


}
