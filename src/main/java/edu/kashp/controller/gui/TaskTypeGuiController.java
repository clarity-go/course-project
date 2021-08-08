package edu.kashp.controller.gui;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeGuiController
  @version  1.0.0 
  @since 20.07.2021 - 19.42
*/

import edu.kashp.form.TaskTypeCreateForm;
import edu.kashp.form.TaskTypeUpdateForm;
import edu.kashp.model.TaskType;
import edu.kashp.service.task_type.impls.TaskTypeServiceImpl;
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
        List<TaskType> taskTypes = service.getAll();
        model.addAttribute("taskTypes", taskTypes);
        return "taskTypes";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id){
        service.delete(id);
        return "redirect:/gui/taskType/all";
    }

    @GetMapping("/create")
    public String create(Model model){
        TaskTypeCreateForm formToCreate = new TaskTypeCreateForm();
        model.addAttribute("form", formToCreate);
        return "taskType-create";
    }

    @PostMapping("/create")
    public String create( @ModelAttribute("form") TaskTypeCreateForm form){
        TaskType taskType = new TaskType();
        taskType.setType(form.getType());
        taskType.setDailyPayment(form.getDailyPayment());
        taskType.setDescription(form.getDescription());
        service.create(taskType);
        return "redirect:/gui/taskType/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id){
        TaskType taskType = service.get(id);
        TaskTypeUpdateForm formToUpdate = new TaskTypeUpdateForm();
        formToUpdate.setId(taskType.getId());
        formToUpdate.setType(taskType.getType());
        formToUpdate.setDailyPayment(taskType.getDailyPayment());
        formToUpdate.setDescription(taskType.getDescription());
        formToUpdate.setCreatedAt(taskType.getCreatedAt());
        formToUpdate.setUpdatedAt(taskType.getUpdatedAt());
        model.addAttribute("form", formToUpdate);
        return "taskType-update";
    }

    @PostMapping("/update/{id}")
    public String update( @ModelAttribute("form") TaskTypeUpdateForm form){
        TaskType taskType = new TaskType();
        taskType.setType(form.getType());
        taskType.setId(form.getId());
        taskType.setDailyPayment(form.getDailyPayment());
        taskType.setDescription(form.getDescription());
        taskType.setCreatedAt(form.getCreatedAt());
        service.update(taskType);
        return "redirect:/gui/taskType/all";
    }
}