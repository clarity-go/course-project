package edu.kashp.controller.rest;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  ItemRestController
  @version  1.0.0 
  @since 20.07.2021 - 19.43
*/

import edu.kashp.model.Employee;
import edu.kashp.service.employee.impls.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taskType")
public class TaskTypeRestController {

    @Autowired
    TaskTypeServiceImpl service;

    // -------------------- GET ALL ----------------------
    // all elements (localhost:8080/api/taskType/all)
    @RequestMapping("/all")
    public List<TaskType> getAll(){
        return service.getAll();
    }

    // ----------------------- GET -----------------------
    // specific element depending on the ID of the item (localhost:8080/api/taskType/2)
    @RequestMapping("/{id}")
    public TaskType get(@PathVariable("id") String id){
        return service.get(id);
    }

    // ---------------------- DELETE ----------------------
    // (localhost:8080/api/taskType/delete/2)
    @RequestMapping("/delete/{id}")
    public TaskType delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    // ------------------------ CREATE --------------------
    @PostMapping("/create")
    public TaskType create(@RequestBody TaskType taskType){
        return service.create(employee);
    }

    // ------------------------ UPDATE ---------------------
    @PostMapping("/update")
    public TaskType update(@RequestBody TaskType taskType){
        return service.update(employee);
    }
}
