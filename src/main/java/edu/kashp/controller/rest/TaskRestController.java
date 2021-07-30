package edu.kashp.controller.rest;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  ItemRestController
  @version  1.0.0 
  @since 20.07.2021 - 19.43
*/

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class TaskRestController {

//    @Autowired
//    EmployeeServiceImpl service;
//
//    // -------------------- GET ALL ----------------------
//    // all elements (localhost:8080/api/item/all)
//    @RequestMapping("/all")
//    public List<Employee> getAll(){
//        return service.getAll();
//    }
//
//    // ----------------------- GET -----------------------
//    // specific element depending on the ID of the item (localhost:8080/api/item/2)
//    @RequestMapping("/{id}")
//    public Employee get(@PathVariable("id") String id){
//        return service.get(id);
//    }
//
//    // ---------------------- DELETE ----------------------
//    // (localhost:8080/api/item/delete/2)
//    @RequestMapping("/delete/{id}")
//    public Employee delete(@PathVariable("id") String id){
//        return service.delete(id);
//    }
//
//    // ------------------------ CREATE --------------------
//    @PostMapping("/create")
//    public Employee create(@RequestBody Employee employee){
//        return service.create(employee);
//    }
//
//    // ------------------------ UPDATE ---------------------
//    @PostMapping("/update")
//    public Employee update(@RequestBody Employee employee){
//        return service.update(employee);
//    }
}
