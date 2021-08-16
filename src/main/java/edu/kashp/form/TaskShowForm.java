package edu.kashp.form;

import edu.kashp.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  TaskShowForm
  @version  1.0.0 
  @since 08.08.2021 - 21.13
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskShowForm {
    private String id;
    private String taskType;
    private String startDate;
    private String finishDate;
    private String employees;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TaskShowForm(Task task) {
        this.id = task.getId();
        this.taskType = task.getTaskType().getType();
        this.startDate = task.getStartDate().toString();
        this.finishDate = task.getFinishDate().toString();
        this.employees = task.getEmployees().stream()
                .map(employee -> employee.getName())
                .collect(Collectors.joining(",\n"));
        this.description = task.getDescription();
        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();
    }
}
