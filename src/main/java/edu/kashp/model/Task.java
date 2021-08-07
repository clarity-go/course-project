package edu.kashp.model;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  Task
  @version  1.0.0 
  @since 20.07.2021 - 17.19
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document

public class Task {
    @Id
    private String id;
    private TaskType taskType;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int numberOfEmployees;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(TaskType taskType, LocalDate startDate, LocalDate finishDate, int numberOfEmployees) {
        this.taskType = taskType;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getId().equals(task.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
