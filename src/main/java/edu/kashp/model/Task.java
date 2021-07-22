package edu.kashp.model;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  Task
  @version  1.0.0 
  @since 20.07.2021 - 17.19
*/

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    private Employee employee;
    private TaskType taskType;
    private LocalDate startTime;
    private LocalDate finishTime;
    private int numberOfEmployees;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
