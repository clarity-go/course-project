package edu.kashp.controller.gui;

/*
  @author   Alona Kashpruk
  @project   course-project
  @class  EmployeeGuiController
  @version  1.0.0 
  @since 20.07.2021 - 19.42
*/

import edu.kashp.form.TaskCreateForm;
import edu.kashp.form.TaskShowForm;
import edu.kashp.form.TaskUpdateForm;
import edu.kashp.model.Employee;
import edu.kashp.model.Task;
import edu.kashp.model.TaskType;
import edu.kashp.repository.EmployeeMongoRepository;
import edu.kashp.repository.TaskTypeMongoRepository;
import edu.kashp.service.employee.interfaces.IEmployeeService;
import edu.kashp.service.task.impls.TaskServiceImpl;
import edu.kashp.service.task_type.interfaces.ITaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/gui/task")

public class TaskGuiController {

    @Autowired
    private TaskServiceImpl service;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ITaskTypeService taskTypesEmployees;

    @Autowired
    private EmployeeMongoRepository employeeRepository;

    @Autowired
    private TaskTypeMongoRepository taskTypeRepository;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<TaskShowForm> tasks = service.getAll().stream()
                .map(TaskShowForm::new)
                .collect(Collectors.toList());
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id){
        service.delete(id);
        return "redirect:/gui/task/all";
    }

    @GetMapping("/create")
    public String create(Model model){
        TaskCreateForm formToCreate = new TaskCreateForm();
        Map<String, String> employeesMap = getEmployeesMap();
        Map<String, String> taskTypes = getTasksTypesMap();
        model.addAttribute("allEmployees", employeesMap);
        model.addAttribute("allTaskTypes", taskTypes);
        model.addAttribute("form", formToCreate);
        return "task-create";
    }

    @PostMapping("/create")
    public String create( @ModelAttribute("form") TaskCreateForm form){
        List<Employee> employeesSelected = form.getEmployees().stream()
                .map(employeeString -> employeeRepository.findByName(employeeString).get(0))
                .collect(Collectors.toList());
        TaskType taskTypeSelected = taskTypeRepository.findByType(form.getTaskType()).get(0);
        Task task = new Task();
        task.setEmployees(employeesSelected);
        task.setTaskType(taskTypeSelected);
        task.setStartDate(LocalDate.parse(form.getStartDate()));
        task.setFinishDate(LocalDate.parse(form.getFinishDate()));
        task.setDescription(form.getDescription());
        service.create(task);
        return "redirect:/gui/task/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id){
        Task task = service.get(id);
        TaskUpdateForm formToUpdate = new TaskUpdateForm(task);
        /*formToUpdate.setId(task.getId());
        formToUpdate.setDescription(task.getDescription());
        formToUpdate.setCreatedAt(task.getCreatedAt());
        formToUpdate.setUpdatedAt(task.getUpdatedAt());
        formToUpdate.setStartDate(task.getStartDate().toString());
        formToUpdate.setFinishDate(task.getFinishDate().toString());*/
        Map<String, String> employeesMap = getEmployeesMap();
        Map<String, String> taskTypes = getTasksTypesMap();
        model.addAttribute("allEmployees", employeesMap);
        model.addAttribute("allTaskTypes", taskTypes);
        model.addAttribute("form", formToUpdate);
        return "task-update";
    }

    @PostMapping("/update/{id}")
    public String update( @ModelAttribute("form") TaskUpdateForm form){
        List<Employee> employeesSelected = form.getEmployees().stream()
                .map(employeeString -> employeeRepository.findByName(employeeString).get(0))
                .collect(Collectors.toList());
        TaskType taskTypeSelected = taskTypeRepository.findByType(form.getTaskType()).get(0);
        Task task = new Task();
        task.setEmployees(employeesSelected);
        task.setTaskType(taskTypeSelected);
        task.setStartDate(LocalDate.parse(form.getStartDate()));
        task.setFinishDate(LocalDate.parse(form.getFinishDate()));
        task.setDescription(form.getDescription());
        task.setId(form.getId());
        task.setDescription(form.getDescription());
        task.setCreatedAt(form.getCreatedAt());
        service.update(task);
        return "redirect:/gui/task/all";
    }

    private Map<String, String> getEmployeesMap() {
        Map<String, String> employeesMap = new LinkedHashMap<>();
        List<Employee> employees = employeeService.getAll();
        employees.stream()
                .map(Employee::getName)
                .forEach(stringName -> employeesMap.put(stringName, stringName));
        return employeesMap;
    }

    private Map<String, String> getTasksTypesMap() {
        Map<String, String> taskTypesMap = new LinkedHashMap<>();
        List<TaskType> taskTypes = taskTypesEmployees.getAll();
        taskTypes.stream()
                .map(TaskType::getType)
                .forEach(stringName -> taskTypesMap.put(stringName, stringName));
        return taskTypesMap;
    }
}