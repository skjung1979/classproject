package com.app.manager.controller;

import com.app.manager.domain.EmpDTO;
import com.app.manager.service.DeptListService;
import com.app.manager.service.EmpRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/emp/register")
public class EmpRegController {

    @Autowired
    private EmpRegService empRegService;

    @Autowired
    private DeptListService deptListService;

    @GetMapping
    public void getRegFrom(Model model) {
        log.info("emp regForm 진입...");

        model.addAttribute("maxEmpNo", empRegService.selectMaxEmpno());
        model.addAttribute("kindOfJob", empRegService.selectJob());
        model.addAttribute("MgrList", empRegService.selectMgr());
        model.addAttribute("deptList", deptListService.getList());

    }

    @PostMapping
    public String regEmp(
            EmpDTO empDTO
    ) {
        log.info("emp reg Post 진입...");

        empRegService.insertEmp(empDTO);

        return "redirect:/emp/list";
    }

}
