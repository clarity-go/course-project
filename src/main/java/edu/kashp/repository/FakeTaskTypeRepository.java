package edu.kashp.repository;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  FakeEmployeeRepository
  @version  1.0.0 
  @since 20.07.2021 - 19.47
*/

import edu.kashp.model.Employee;
import edu.kashp.model.Task;
import edu.kashp.model.TaskType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository

public class FakeTaskTypeRepository {

    private LocalDateTime time = LocalDateTime.now();

    private List<TaskType> list = new ArrayList<>(
            Arrays.asList(
                    new TaskType("0","Marketing", 1500, "Creating Marketing Content", time ,time),
                    new TaskType("1", "Marketing", 1560, "Writing Additional Articles", time ,time),
                    new TaskType("2", "Management", 2700, "Creating Development Plan", time ,time),
                    new TaskType("3", "Advertising", 3900, "Help with Advertisement", time ,time),
                    new TaskType("4", "Management",2100, "Creating Sales Plan", time ,time),
                    new TaskType("5","Management", 1700, "Working on Presentations", time ,time),
                    new TaskType("6", "Management", 2500, "Arranging Meetings", time ,time),
                    new TaskType("7",  "Support",800, "Reporting Bugs", time ,time),
                    new TaskType("8", "Support", 1100, "Editing News Articles", time ,time)
            )
    );

    public TaskType create(TaskType taskType) {
        String id = UUID.randomUUID().toString();
        taskType.setId(id);
        taskType.setCreatedAt(LocalDateTime.now());
        taskType.setUpdatedAt(LocalDateTime.now());
        list.add(taskType);
        return taskType;
    }

    public TaskType get(String id) {

        TaskType taskType = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();
        return taskType;
    }

    public TaskType update(TaskType taskType) {
        String id = taskType.getId();
        TaskType taskTypeToUpdate = this.get(id);
        taskType.setCreatedAt(taskTypeToUpdate.getCreatedAt());
        int index = list.indexOf(taskTypeToUpdate); // find the place from which we have deleted the item
        taskType.setUpdatedAt(LocalDateTime.now());
        list.remove(taskTypeToUpdate);
        list.add(index, taskType); // add updated items on the place from which we have deleted them
        return taskType;
    }

    public TaskType delete(String id) {

        TaskType taskType = this.get(id);
        list.remove(taskType);

        return taskType;
    }

    public List<TaskType> getAll() {
        return list;
    }
}
