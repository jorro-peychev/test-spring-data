package com.example.demo.embeddedTable.employeeAddress;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
  List<Employee> findAll();
}
