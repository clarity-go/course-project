package edu.kashp.form;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeCreateForm
  @version  1.0.0 
  @since 22.07.2021 - 19.32
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskTypeCreateForm {
    private double dailyPayment;
    private String description;
    private String type;
}
