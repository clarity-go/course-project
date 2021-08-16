package edu.kashp.service.task.impls;

import edu.kashp.model.Task;
import edu.kashp.repository.FakeTaskRepository;
import edu.kashp.repository.TaskMongoRepository;
import edu.kashp.service.task.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  TaskServiceImpl
  @version  1.0.0 
  @since 30.07.2021 - 16.56
*/

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    FakeTaskRepository repository;

    @Autowired
    TaskMongoRepository mongoRepository;

    //@PostConstruct
    void init() {
        List<Task> list = repository.getAll();
        mongoRepository.saveAll(list);
    }
    @Override
    public Task create(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(task);
    }

    @Override
    public Task get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Task update(Task task) {

        Task taskToUpdate = this.get(task.getId());
        LocalDateTime creation = taskToUpdate.getCreatedAt();
        task.setCreatedAt(creation);
        task.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(task);
    }

    @Override
    public Task delete(String id) {
        Task task = this.get(id);
        mongoRepository.deleteById(id);
        return task;
    }

    @Override
    public List<Task> getAll() {
        return mongoRepository.findAll();
    }
}