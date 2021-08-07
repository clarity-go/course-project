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
                    new TaskType("0","Marketing", 1500, "Creating Marketing Content", time ,time),
                    new TaskType("1", "Marketing", 1560, "Writing Additional Articles", time ,time),
                    new TaskType("2", "Management", 2700, "Creating Development Plan", time ,time),
                    new TaskType("3", "Advertising", 3900, "Help with Advertisement", time ,time),
                    new TaskType("4", "Management",2100, "Creating Sales Plan", time ,time),
                    new TaskType("5","Management", 1700, "Working on Presentations", time ,time),
                    new TaskType("6", "Management", 2500, "Arranging Meetings", time ,time),
                    new TaskType("7",  "Support",800, "Reporting Bugs", time ,time),
                    new TaskType("8", "Support", 1100, "Editing News Articles", time ,time)
            )
    );

    private List<Task> task = new ArrayList<>(
            Arrays.asList(
                    new Task("0", taskType.get(0), startDate, finishDate, 2, "Creating Marketing Content", time, time),
                    new Task("1", taskType.get(1), startDate, finishDate, 1, "Writing Additional Articles", time, time),
                    new Task("2", taskType.get(2), startDate, finishDate, 3, "Creating Development Plan", time, time),
                    new Task("3", taskType.get(3), startDate, finishDate, 1, "Help with Advertisement", time, time),
                    new Task("4", taskType.get(4), startDate, finishDate, 2, "Creating Sales Plan", time, time),
                    new Task("5", taskType.get(5), startDate, finishDate, 1, "Working on Presentations", time, time),
                    new Task("6", taskType.get(6), startDate, finishDate, 3, "Arranging Meetings", time, time),
                    new Task("7", taskType.get(7), startDate, finishDate, 1, "Reporting Bugs", time, time),
                    new Task("8", taskType.get(8), startDate, finishDate, 1, "Editing News Articles", time, time)
            )
    );

    private List<Employee> list = new ArrayList<>(
            Arrays.asList(
                    new Employee("0", "Peter Flame", task.get(0), 20000, "Partner marketing manager", time ,time),
                    new Employee("1", "Stephane Turbide", task.get(1), 25000, "Digital marketing specialist", time ,time),
                    new Employee("2", "Peter Chung", task.get(2), 27000, "Partner marketing manager", time ,time),
                    new Employee("3", "Daniel Cohen", task.get(3), 39000, "Brand manager", time ,time),
                    new Employee("4", "Brian Miller", task.get(4), 20000, "Brand manager", time ,time),
                    new Employee("5", "Paul Franks", task.get(5), 25000, "Public relations specialist", time ,time),
                    new Employee("6", "Wei Hopeman", task.get(6), 27000, "Communications manager", time ,time),
                    new Employee("7", "Aidan Larkin", task.get(7), 39000, "Digital marketing specialist", time ,time),
                    new Employee("8", "Erik Graber", task.get(8), 39000, "Digital marketing specialist", time ,time)
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
