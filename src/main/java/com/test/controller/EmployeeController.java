package com.test.controller;

import com.test.model.Department;
import com.test.model.Employee;
import com.test.service.DepartmentService;
import com.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @ModelAttribute("departments")
    public Page<Department> departments(Pageable pageable){
        return departmentService.findAll(pageable);
    }
    @GetMapping("")
    public ModelAndView getEmployeeList(@PageableDefault(size = 10) Pageable pageable){
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }

    @GetMapping("/newEmployee")
    public ModelAndView getNewEmployeeForm(Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("departments",departments(pageable));
        return modelAndView;
    }

    @PostMapping("/newEmployee")
    public ModelAndView doAddNewEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @GetMapping("/{id}/viewEmployee")
    public ModelAndView getEmployeeView(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/employee/view");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }

    @GetMapping("/{id}/deleteEmployee")
    public ModelAndView doDeleteEmployee(@PathVariable int id){
       employeeService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @GetMapping("/{id}/editEmployee")
    public ModelAndView getEditEmployeeView(@PathVariable int id, Pageable pageable){
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employee",employee);
        modelAndView.addObject("departments",departments(pageable));
        return modelAndView;
    }

    @PostMapping("/editEmployee")
    public ModelAndView doUpdateNewEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @GetMapping("/searchByDepartment")
    public ModelAndView getEmployeeByDepartment(@RequestParam("srch") String search, Pageable pageable){
        Department department = departmentService.findById(Integer.parseInt(search));
        Page<Employee> employees = employeeService.findAllByDepartment(pageable,department);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }

    @GetMapping("/sortBySalaryAsc")
    public ModelAndView getEmployeeSortBySalaryAsc(@PageableDefault(size = 2) Pageable pageable){
        Page<Employee> employees = employeeService.findAllByOrderBySalaryAsc(pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }

    @GetMapping("/sortBySalaryDesc")
    public ModelAndView getEmployeeSortBySalaryDesc(@PageableDefault(size = 2) Pageable pageable){
        Page<Employee> employees = employeeService.findAllByOrderBySalaryDesc(pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }
}
