package com.app.manager.controller.dept;

import com.app.manager.service.dept.DeptListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class DeptListController {

    @Autowired
    private DeptListService deptListService;

    @RequestMapping("/dept/list")
    public void getDeptList(
            Model model
    ){

        model.addAttribute("deptList", deptListService.getList());

        log.info("dept list 진입...");

    }
}
