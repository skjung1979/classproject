package com.app.manager.controller;

import com.app.manager.service.EmpListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class EmpListController {

    @Autowired
    private EmpListService empListService;

    @RequestMapping("/emp/list")
    public void getEmpList(Model model){

        log.info("emp list 진입...");

        model.addAttribute("empList", empListService.getList());

        log.info(empListService.getList());

    }

}
