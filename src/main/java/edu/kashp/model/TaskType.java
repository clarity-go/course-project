package edu.kashp.model;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  TaskType
  @version  1.0.0 
  @since 20.07.2021 - 17.21
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document

public class TaskType {
//    @Id
    private String id;
    private double dailyPayment;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TaskType(double dailyPayment, String description) {
        this.dailyPayment = dailyPayment;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskType)) return false;
        TaskType taskType = (TaskType) o;
        return getId().equals(taskType.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
