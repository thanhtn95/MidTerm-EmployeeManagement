package com.test.controller;

import com.test.model.Department;
import com.test.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/listDepartment")
    public ModelAndView getDepartmentList(@PageableDefault(size = 10)Pageable pageable){
        Page<Department> departments = departmentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/department/list");
        modelAndView.addObject("departments",departments);
        return modelAndView;
    }

    @GetMapping("/{id}/viewDepartment")
    public ModelAndView getDepartmentView(@PathVariable int id){
        Department department = departmentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/department/view");
        modelAndView.addObject("department",department);
        return modelAndView;
    }

    @GetMapping("/{id}/deleteDepartment")
    public ModelAndView doDeleteDepartment(@PathVariable int id){
        departmentService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/listDepartment");
        return modelAndView;
    }

    @GetMapping("/newDepartment")
    public ModelAndView getNewDepartmentForm(){
        ModelAndView modelAndView = new ModelAndView("/department/create","department",new Department());
        return modelAndView;
    }

    @PostMapping("/newDepartment")
    public ModelAndView AddNewDepartment(@ModelAttribute("department") Department department){
        departmentService.save(department);
        ModelAndView modelAndView = new ModelAndView("redirect:/listDepartment");
        return modelAndView;
    }

    @GetMapping("/{id}/editDepartment")
    public ModelAndView getEditDepartmentForm(@PathVariable int id){
        Department department = departmentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/department/edit");
        modelAndView.addObject("department",department);
        return modelAndView;
    }

    @PostMapping("/updateDepartment")
    public ModelAndView doUpdateDepartment(@ModelAttribute("department") Department department){
        departmentService.save(department);
        return new ModelAndView("redirect:/listDepartment");
    }
}
