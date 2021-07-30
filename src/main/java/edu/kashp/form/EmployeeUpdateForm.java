package edu.kashp.form;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeUpdateForm
  @version  1.0.0 
  @since 22.07.2021 - 19.31
*/

import edu.kashp.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateForm {
    private String id;
    private String name;
    private Task task;
    private double salary;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
