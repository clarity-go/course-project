package edu.kashp.service.task_type.impls;

import edu.kashp.model.TaskType;
import edu.kashp.repository.FakeTaskTypeRepository;
import edu.kashp.repository.TaskTypeMongoRepository;
import edu.kashp.service.task_type.interfaces.ITaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  TaskTypeServiceImpl
  @version  1.0.0 
  @since 30.07.2021 - 17.00
*/
@Service
public class TaskTypeServiceImpl implements ITaskTypeService {
    @Autowired
    FakeTaskTypeRepository repository;

    @Autowired
    TaskTypeMongoRepository mongoRepository;

    @PostConstruct
    void init(){
        List<TaskType> list = repository.getAll();
        mongoRepository.saveAll(list);
    }

    @Override
    public TaskType create(TaskType taskType) {
//        System.out.println("item has been accepted" + item.toString());
//        list.add(item);
//        return item;
        taskType.setCreatedAt(LocalDateTime.now());
        taskType.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(taskType);
//        return repository.create(taskType);
    }

    @Override
    public TaskType get(String id) {

//        Item item = list.stream().filter(el -> el.getId().equals(id))
//                .findAny().get();
//        return item;

//        return repository.get(id);
        return mongoRepository.findById(id).get();
    }

    @Override
    public TaskType update(TaskType taskType) {

        TaskType taskTypeToUpdate = this.get(taskType.getId());
        LocalDateTime creation = taskTypeToUpdate.getCreatedAt();
        taskType.setCreatedAt(creation);
//        return null;
//        return repository.update(item);

        taskType.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(taskType);
    }

    @Override
    public TaskType delete(String id) {
        TaskType taskType = this.get(id);
        mongoRepository.deleteById(id);
        return taskType;

//        Item item = this.get(id);
//        list.remove(item);
//        return repository.delete(id);
    }

    @Override
    public List<TaskType> getAll() {

//        return list;
//        return repository.getAll();
        return mongoRepository.findAll();
    }
}
