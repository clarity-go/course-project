package edu.kashp.model;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  Employee
  @version  1.0.0 
  @since 20.07.2021 - 17.19
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document

public class Employee {
    @Id
    private String id;
    private String name;
    private Task task;
    private double salary;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Employee(String name, Task task, double salary, String description) {
        this.name = name;
        this.task = task;
        this.salary = salary;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
