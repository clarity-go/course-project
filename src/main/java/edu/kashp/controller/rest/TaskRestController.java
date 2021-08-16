package edu.kashp.controller.rest;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  ItemRestController
  @version  1.0.0 
  @since 20.07.2021 - 19.43
*/

import edu.kashp.model.Task;
import edu.kashp.service.task.impls.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskRestController {

    @Autowired
    TaskServiceImpl service;

    // -------------------- GET ALL ----------------------
    @RequestMapping("/all")
    public List<Task> getAll(){
        return service.getAll();
    }

    // ----------------------- GET -----------------------
    @RequestMapping("/{id}")
    public Task get(@PathVariable("id") String id){
        return service.get(id);
    }

    // ---------------------- DELETE ----------------------
    @RequestMapping("/delete/{id}")
    public Task delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    // ------------------------ CREATE --------------------
    @PostMapping("/create")
    public Task create(@RequestBody Task task){
        return service.create(task);
    }

    // ------------------------ UPDATE ---------------------
    @PostMapping("/update")
    public Task update(@RequestBody Task task){
        return service.update(task);
    }
}
