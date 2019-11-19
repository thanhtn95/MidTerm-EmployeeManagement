package com.test.repository;

import com.test.model.Department;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartmentRepository extends PagingAndSortingRepository<Department,Integer> {
}
