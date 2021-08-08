package edu.kashp.form;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeCreateForm
  @version  1.0.0 
  @since 22.07.2021 - 19.32
*/

import edu.kashp.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreateForm {
    private String name;
    private double salary;
    private String description;
}
