package com.app.manager.controller.emp;

import com.app.manager.service.emp.EmpDeleteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/emp/delete")
@Log4j2
public class EmpDeleteController {

    @Autowired
    private EmpDeleteService empDeleteService;

    @GetMapping
    public String deleteEmp(@RequestParam("empno") int empno){

        empDeleteService.deleteEmp(empno);

        return "redirect:/emp/list";
    }


}
