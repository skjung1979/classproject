package com.app.manager.controller.dept;

import com.app.manager.service.dept.DeptDeleteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class DeptDeleteController {

    @Autowired
    private DeptDeleteService deptDeleteService;

    @GetMapping("/dept/delete")
    public String deleteDept(@RequestParam("deptno") int deptno){

        log.info("delete 진입..." + deptno);

        deptDeleteService.deleteDept(deptno);

        return "redirect:/dept/list";
    }

}
