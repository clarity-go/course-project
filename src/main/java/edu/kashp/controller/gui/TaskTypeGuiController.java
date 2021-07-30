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
@RequestMapping("/gui/taskType")

public class TaskTypeGuiController {

    @Autowired
    TaskTypeServiceImpl service;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<TaskType> taskType = service.getAll();
        model.addAttribute("taskTypes", taskTypes);
        return "taskTypes";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id){
        service.delete(id);
        List<TaskType> taskTypes = service.getAll();
        model.addAttribute("taskTypes", taskTypes);
        return "taskTypes";
    }

    @GetMapping("/create")
    public String create(Model model){
        TaskTypeCreateForm formToCreate = new EmployeeCreateForm();
        model.addAttribute("form", formToCreate);
        return "taskType-create";
    }
    @PostMapping("/create")
    public String create( @ModelAttribute("form") TaskTypeCreateForm form){
        TaskType taskType = new Employee();
        taskType.setName(form.getName());
        taskType.setDescription(form.getDescription());
        service.create(taskType);
        return "redirect:/gui/taskType/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id){
        TaskType taskType = service.get(id);
        TaskTypeUpdateForm formToUpdate = new TaskTypeUpdateForm();
        formToUpdate.setId(taskType.getId());
        formToUpdate.setName(taskType.getName());
        formToUpdate.setDescription(taskType.getDescription());
        formToUpdate.setCreatedAt(taskType.getCreatedAt());
        formToUpdate.setUpdatedAt(taskType.getUpdatedAt());
        model.addAttribute("form", formToUpdate);
        return "taskType-update";
    }

    @PostMapping("/update/{id}")
    public String update( @ModelAttribute("form") EmployeeUpdateForm form){
        TaskType taskType = new TaskType();
        taskType.setId(form.getId());
        taskType.setName(form.getName());
        taskType.setDescription(form.getDescription());
        taskType.setCreatedAt(form.getCreatedAt());
        service.update(taskType);
        return "redirect:/gui/taskType/all";
    }
}