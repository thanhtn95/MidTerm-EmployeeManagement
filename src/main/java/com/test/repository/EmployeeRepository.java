package com.test.repository;

import com.test.model.Department;
import com.test.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
    Page<Employee> findAllByDepartment(Pageable pageable, Department department);
    Page<Employee> findAllByOrderBySalaryAsc(Pageable pageable);
    Page<Employee> findAllByOrderBySalaryDesc(Pageable pageable);
}
