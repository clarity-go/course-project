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
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateForm {
    private String taskType;
    private String startDate;
    private String finishDate;
    private List<String> employees;
    private String description;
}
