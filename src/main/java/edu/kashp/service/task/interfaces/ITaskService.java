package edu.kashp.service.task.interfaces;

import edu.kashp.model.Task;

import java.util.List;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  ITaskService
  @version  1.0.0 
  @since 30.07.2021 - 16.55
*/
public interface ITaskService {
    Task create(Task task);
    Task get(String id);
    Task update(Task task);
    Task delete(String id);
    List<Task> getAll();
}
