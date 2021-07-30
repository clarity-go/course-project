package edu.kashp.form;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeCreateForm
  @version  1.0.0 
  @since 22.07.2021 - 19.32
*/

import edu.kashp.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateForm {
    private TaskType taskType;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int numberOfEmployees;
    private String description;
}
