package edu.kashp.form;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeUpdateForm
  @version  1.0.0 
  @since 22.07.2021 - 19.31
*/

import edu.kashp.model.Task;
import edu.kashp.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateForm {
    private String id;
    private String taskType;
    private String startDate;
    private String finishDate;
    private List<String> employees;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TaskUpdateForm(Task task) {
        this.id = task.getId();
        this.taskType = task.getTaskType().getType();
        this.startDate = task.getStartDate().toString();
        this.finishDate = task.getFinishDate().toString();
        this.employees = task.getEmployees().stream()
                .map(employee -> employee.getName())
                .collect(Collectors.toList());
        this.description = task.getDescription();
        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();
    }
}
