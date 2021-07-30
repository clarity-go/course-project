package edu.kashp.service.task_type.interfaces;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  ITaskTypeService
  @version  1.0.0 
  @since 30.07.2021 - 16.59
*/

import edu.kashp.model.TaskType;

import java.util.List;

public interface ITaskTypeService {

    TaskType create(TaskType taskType);
    TaskType get(String id);
    TaskType update(TaskType taskType);
    TaskType delete(String id);
    List<TaskType> getAll();
}
