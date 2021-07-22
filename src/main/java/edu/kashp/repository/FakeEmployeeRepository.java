package edu.kashp.repository;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  FakeEmployeeRepository
  @version  1.0.0 
  @since 20.07.2021 - 19.47
*/

import edu.kashp.model.Employee;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository

public class FakeEmployeeRepository {

    private LocalDateTime time = LocalDateTime.now();
    private List<Employee> list = new ArrayList<>(
            Arrays.asList(
                    new Employee("0", "name0", "desc0", time ,time),
                    new Employee("1", "name1", "desc1", time ,time),
                    new Employee("2", "name2", "desc2", time ,time),
                    new Employee("3", "name3", "desc3", time ,time)
            )
    );

    public Employee create(Employee employee) {
        String id = UUID.randomUUID().toString();
        employee.setId(id);
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        list.add(employee);
        return employee;
    }

    public Employee get(String id) {

        Employee employee = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();

        return employee;
    }

    public Employee update(Employee employee) {
        String id = employee.getId();
        Employee employeeToUpdate = this.get(id);
        int index = list.indexOf(employeeToUpdate); // find the place from which we have deleted the item
        employee.setUpdatedAt(LocalDateTime.now());
        list.remove(employeeToUpdate);
        list.add(index, employee); // add updated items on the place from which we have deleted them
        return employee;
    }

    public Employee delete(String id) {

        Employee employee = this.get(id);
        list.remove(employee);

        return employee;
    }

    public List<Employee> getAll() {
        return list;
    }
}
