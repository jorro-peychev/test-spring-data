package com.example.demo.embeddedTable.employeeAddress;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmbeddedEmployeeAddress {

  private EmployeeRepository employeeRepository;

  public EmbeddedEmployeeAddress(EmployeeRepository employeeRepository) {

    this.employeeRepository = employeeRepository;
  }

  public void loadData() {

    Employee emp = new Employee();
    emp.setName("name");
    emp.setSalary(12345);

    Address p = new Address();
    p.setCity("New York");
    p.setStreet("Str");

    emp.setAddress(p);

    employeeRepository.save(emp);
  }

  public List<Employee> findAllEmployees() {

    return employeeRepository.findAll();
  }
}
