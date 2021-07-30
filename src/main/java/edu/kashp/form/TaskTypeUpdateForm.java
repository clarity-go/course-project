package edu.kashp.form;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeUpdateForm
  @version  1.0.0 
  @since 22.07.2021 - 19.31
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskTypeUpdateForm {
    private String id;
    private double dailyPayment;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
