package edu.kashp.repository;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  FakeEmployeeRepository
  @version  1.0.0 
  @since 20.07.2021 - 19.47
*/

import edu.kashp.model.Employee;
import edu.kashp.model.Task;
import edu.kashp.model.TaskType;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository

public class FakeEmployeeRepository {

    private LocalDateTime time = LocalDateTime.now();

    LocalDate startDate = LocalDate.of(2021, Month.OCTOBER, 14);
    LocalDate finishDate = LocalDate.of(2021, Month.NOVEMBER, 20);

    private List<TaskType> taskType = new ArrayList<>(
            Arrays.asList(
                    new TaskType("0", 2000, "desc0", time ,time),
                    new TaskType("1", 2500, "desc0", time ,time),
                    new TaskType("2", 2700, "desc0", time ,time),
                    new TaskType("3", 3900, "desc0", time ,time)
            )
    );

    private List<Task> task = new ArrayList<>(
            Arrays.asList(
                    new Task("0", taskType.get(0), startDate, finishDate, 2, "desc0", time, time),
                    new Task("1", taskType.get(1), startDate, finishDate, 1, "desc0", time, time),
                    new Task("2", taskType.get(2), startDate, finishDate, 3, "desc0", time, time),
                    new Task("3", taskType.get(3), startDate, finishDate, 5, "desc0", time, time)
            )
    );

    private List<Employee> list = new ArrayList<>(
            Arrays.asList(
                    new Employee("0", "name0", task.get(0), 20000, "desc0", time ,time),
                    new Employee("1", "name1", task.get(1), 25000, "desc0", time ,time),
                    new Employee("2", "name2", task.get(2), 27000, "desc0", time ,time),
                    new Employee("3", "name3", task.get(3), 39000, "desc0", time ,time)
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
        employee.setCreatedAt(employeeToUpdate.getCreatedAt());
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
