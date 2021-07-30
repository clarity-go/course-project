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

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    FakeEmployeeRepository repository;

    @Autowired
    EmployeeMongoRepository mongoRepository;

    //    @PostConstruct
    void init() {
        List<Employee> list = repository.getAll();
        mongoRepository.saveAll(list);
    }

    @Override
    public Employee create(Employee employee) {
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(employee);
//        return repository.create(employee);
    }

    @Override
    public Employee get(String id) {

//        Item item = list.stream().filter(el -> el.getId().equals(id))
//                .findAny().get();
//        return item;

//        return repository.get(id);
        return mongoRepository.findById(id).get();
    }

    @Override
    public Employee update(Employee employee) {

        Employee employeeToUpdate = this.get(employee.getId());
        LocalDateTime creation = employeeToUpdate.getCreatedAt();
        employee.setCreatedAt(creation);
//        return null;
//        return repository.update(item);

        employee.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(employee);
    }

    @Override
    public Employee delete(String id) {
        Employee employee = this.get(id);
        mongoRepository.deleteById(id);
        return employee;

//        Item item = this.get(id);
//        list.remove(item);
//        return repository.delete(id);
    }

    @Override
    public List<Employee> getAll() {

//        return list;
//        return repository.getAll();
        return mongoRepository.findAll();
    }
}