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
@RequestMapping("/gui/employee")

public class EmployeeGuiController {

    @Autowired
    EmployeeServiceImpl service;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<Employee> employees = service.getAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id){
        service.delete(id);
        return "redirect:/gui/employee/all";
    }

    @GetMapping("/create")
    public String create(Model model){
        EmployeeCreateForm formToCreate = new EmployeeCreateForm();
        model.addAttribute("form", formToCreate);
        return "employee-create";
    }
    @PostMapping("/create")
    public String create( @ModelAttribute("form") EmployeeCreateForm form){
        Employee employee = new Employee();
        employee.setSalary(form.getSalary());
        employee.setName(form.getName());
        employee.setDescription(form.getDescription());
        service.create(employee);
        return "redirect:/gui/employee/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id){
        Employee employee = service.get(id);
        EmployeeUpdateForm formToUpdate = new EmployeeUpdateForm();
        formToUpdate.setId(employee.getId());
        formToUpdate.setName(employee.getName());
        formToUpdate.setSalary(employee.getSalary());
        formToUpdate.setDescription(employee.getDescription());
        formToUpdate.setCreatedAt(employee.getCreatedAt());
        formToUpdate.setUpdatedAt(employee.getUpdatedAt());
        model.addAttribute("form", formToUpdate);
        return "employee-update";
    }

    @PostMapping("/update/{id}")
    public String update( @ModelAttribute("form") EmployeeUpdateForm form){
        Employee employee = new Employee();
        employee.setId(form.getId());
        employee.setName(form.getName());
        employee.setSalary(form.getSalary());
        employee.setDescription(form.getDescription());
        employee.setCreatedAt(form.getCreatedAt());
        service.update(employee);
        return "redirect:/gui/employee/all";
    }
}