package edu.kashp.controller.rest;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  ItemRestController
  @version  1.0.0 
  @since 20.07.2021 - 19.43
*/

import edu.kashp.model.Employee;
import edu.kashp.model.TaskType;
import edu.kashp.service.employee.impls.EmployeeServiceImpl;
import edu.kashp.service.task_type.impls.TaskTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taskType")
public class TaskTypeRestController {

    @Autowired
    TaskTypeServiceImpl service;

    // -------------------- GET ALL ----------------------
    @RequestMapping("/all")
    public List<TaskType> getAll(){
        return service.getAll();
    }

    // ----------------------- GET -----------------------
    @RequestMapping("/{id}")
    public TaskType get(@PathVariable("id") String id){
        return service.get(id);
    }

    // ---------------------- DELETE ----------------------
    @RequestMapping("/delete/{id}")
    public TaskType delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    // ------------------------ CREATE --------------------
    @PostMapping("/create")
    public TaskType create(@RequestBody TaskType taskType){
        return service.create(taskType);
    }

    // ------------------------ UPDATE ---------------------
    @PostMapping("/update")
    public TaskType update(@RequestBody TaskType taskType){
        return service.update(taskType);
    }
}
