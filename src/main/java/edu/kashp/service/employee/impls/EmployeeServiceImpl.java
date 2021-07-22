package edu.kashp.service.employee.impls;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeServiceImpl
  @version  1.0.0 
  @since 20.07.2021 - 19.51
*/

import edu.kashp.model.Employee;
import edu.kashp.repository.FakeEmployeeRepository;
import edu.kashp.service.employee.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    FakeEmployeeRepository repository;

    @Override
    public Employee create(Employee employee) {
        return repository.create(employee);
    }

    @Override
    public Employee get(String id) {
        return repository.get(id);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.update(employee);
    }

    @Override
    public Employee delete(String id) {
        return repository.delete(id);
    }

    @Override
    public List<Employee> getAll() {
        return repository.getAll();
    }
}
