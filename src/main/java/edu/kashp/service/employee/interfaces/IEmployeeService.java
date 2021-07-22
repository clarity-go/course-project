package edu.kashp.service.employee.interfaces;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeService
  @version  1.0.0 
  @since 20.07.2021 - 19.50
*/

import edu.kashp.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee create(Employee employee);
    Employee get(String id);
    Employee update(Employee employee);
    Employee delete(String id);
    List<Employee> getAll();
}
