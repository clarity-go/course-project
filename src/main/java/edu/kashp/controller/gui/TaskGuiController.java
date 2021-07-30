package edu.kashp.controller.gui;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeGuiController
  @version  1.0.0 
  @since 20.07.2021 - 19.42
*/

import edu.kashp.form.EmployeeCreateForm;
import edu.kashp.form.EmployeeUpdateForm;
import edu.kashp.model.Employee;
import edu.kashp.service.employee.impls.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gui/task")

public class TaskGuiController {

    @Autowired
    EmployeeServiceImpl service;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<Task> tasks = service.getAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

//    @RequestMapping("/delete/{id}")
//    public String delete(Model model, @PathVariable("id") String id){
//        service.delete(id);
//        List<Task> tasks = service.getAll();
//        model.addAttribute("tasks", tasks);
//        return "tasks";
//    }
//
//    @GetMapping("/create")
//    public String create(Model model){
//        TaskCreateForm formToCreate = new TaskCreateForm();
//        model.addAttribute("form", formToCreate);
//        return "task-create";
//    }
//    @PostMapping("/create")
//    public String create( @ModelAttribute("form") TaskCreateForm form){
//        Task task = new Task();
//        task.setName(form.getName());
//        task.setDescription(form.getDescription());
//        service.create(task);
//        return "redirect:/gui/task/all";
//    }
//
//    @GetMapping("/update/{id}")
//    public String update(Model model, @PathVariable("id") String id){
//        Task task = service.get(id);
//        TaskUpdateForm formToUpdate = new TaskUpdateForm();
//        formToUpdate.setId(task.getId());
//        formToUpdate.setName(task.getName());
//        formToUpdate.setDescription(task.getDescription());
//        formToUpdate.setCreatedAt(task.getCreatedAt());
//        formToUpdate.setUpdatedAt(task.getUpdatedAt());
//        model.addAttribute("form", formToUpdate);
//        return "task-update";
//    }
//
//    @PostMapping("/update/{id}")
//    public String update( @ModelAttribute("form") TaskUpdateForm form){
//        Task task = new Task();
//        task.setId(form.getId());
//        task.setName(form.getName());
//        task.setDescription(form.getDescription());
//        task.setCreatedAt(form.getCreatedAt());
//        service.update(task);
//        return "redirect:/gui/task/all";
//    }
}