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
    public String getDeptList(HttpServletRequest request, HttpServletResponse response){

        System.out.println("dept list get 들어옴...");

        List<Dept> list = null;

        try {
            list = deptService.getList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("list", list);

        return "views/dept/list";
    }
}
