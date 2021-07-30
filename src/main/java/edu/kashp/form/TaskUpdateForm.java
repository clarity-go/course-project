package edu.kashp.form;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeUpdateForm
  @version  1.0.0 
  @since 22.07.2021 - 19.31
*/

import edu.kashp.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateForm {
    private String id;
    private TaskType taskType;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int numberOfEmployees;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
