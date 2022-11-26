package com.todo.todo.controller.dept;

import com.todo.todo.service.dept.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/dept/list")
public class DeptListController {

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
