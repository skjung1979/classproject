package com.app.manager.controller.emp;

import com.app.manager.domain.emp.EmpDTO;
import com.app.manager.service.dept.DeptListService;
import com.app.manager.service.emp.EmpEditService;
import com.app.manager.service.emp.EmpListService;
import com.app.manager.service.emp.EmpRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping("/emp/edit")
public class EmpEditController {

    @Autowired
    private EmpEditService empEditService;

    @Autowired
    private EmpListService empListService;

    @Autowired
    private EmpRegService empRegService;

    @Autowired
    private DeptListService deptListService;

    @GetMapping
    public void editEmp(@RequestParam("no") int empno, Model model){

        model.addAttribute("kindOfJob", empRegService.selectJob());
        model.addAttribute("MgrList", empRegService.selectMgr());
        model.addAttribute("deptList", deptListService.getList());

        model.addAttribute("empListBy", empListService.getListBy(empno));

    }

    @PostMapping
    public String postEditEmp(EmpDTO empDTO){

        log.info("emp edit post 진입, empDTO => " + empDTO);

        empEditService.editEmp(empDTO);

        return "redirect:/emp/list";
    }

}
