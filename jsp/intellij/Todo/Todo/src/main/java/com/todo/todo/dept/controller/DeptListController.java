package com.todo.todo.dept.controller;

import com.todo.todo.dept.domain.Dept;
import com.todo.todo.dept.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.*;
import java.util.List;

@Controller
@RequestMapping("/dept/list")
public class DeptListController  {

    private final DeptService deptService;

    public DeptListController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping
    public String getDeptList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("dept list get 들어옴...");

        request.setAttribute("list", deptService.getList());

        return "views/dept/list";
    }
}
