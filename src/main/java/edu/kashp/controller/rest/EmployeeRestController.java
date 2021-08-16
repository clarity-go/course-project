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
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    EmployeeServiceImpl service;

    // -------------------- GET ALL ----------------------
    @RequestMapping("/all")
    public List<Employee> getAll(){
        return service.getAll();
    }

    // ----------------------- GET -----------------------
    @RequestMapping("/{id}")
    public Employee get(@PathVariable("id") String id){
        return service.get(id);
    }

    // ---------------------- DELETE ----------------------
    @RequestMapping("/delete/{id}")
    public Employee delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    // ------------------------ CREATE --------------------
    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }

    // ------------------------ UPDATE ---------------------
    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return service.update(employee);
    }
}
