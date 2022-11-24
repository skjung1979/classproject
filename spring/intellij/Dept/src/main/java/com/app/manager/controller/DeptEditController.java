package com.app.manager.controller;

import com.app.manager.domain.DeptDTO;
import com.app.manager.service.DeptEditService;
import com.app.manager.service.DeptReadService;
import com.app.manager.service.DeptRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/dept/edit")
public class DeptEditController {

    @Autowired
    private DeptEditService deptEditService;

    @Autowired
    private DeptReadService deptReadService;

    @GetMapping
    public void getEditForm(
            @RequestParam("no") int deptno,
            Model model
    ){

        model.addAttribute("dept", deptReadService.getDept(deptno));

    }

    @PostMapping
    public String edit(DeptDTO deptDTO){

        log.info("edit post 진입");
        log.info(deptDTO);

        deptEditService.editDept(deptDTO);

        return "redirect:/dept/list";
    }

}
