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

    @PostConstruct
    void init() {
        List<Task> list = repository.getAll();
        mongoRepository.saveAll(list);
    }
    @Override
    public Task create(Task task) {
//        System.out.println("item has been accepted" + item.toString());
//        list.add(item);
//        return item;
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(task);
//        return repository.create(task);
    }

    @Override
    public Task get(String id) {

//        Item item = list.stream().filter(el -> el.getId().equals(id))
//                .findAny().get();
//        return item;

//        return repository.get(id);
        return mongoRepository.findById(id).get();
    }

    @Override
    public Task update(Task task) {

        Task taskToUpdate = this.get(task.getId());
        LocalDateTime creation = taskToUpdate.getCreatedAt();
        task.setCreatedAt(creation);
//        return null;
//        return repository.update(item);

        task.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(task);
    }

    @Override
    public Task delete(String id) {
        Task task = this.get(id);
        mongoRepository.deleteById(id);
        return task;

//        Item item = this.get(id);
//        list.remove(item);
//        return repository.delete(id);
    }

    @Override
    public List<Task> getAll() {

//        return list;
//        return repository.getAll();
        return mongoRepository.findAll();
    }
}