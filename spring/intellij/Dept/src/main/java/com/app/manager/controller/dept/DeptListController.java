package com.app.manager.controller.dept;

import com.app.manager.domain.DeptSearchOption;
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
            DeptSearchOption searchOption,
            Model model
    ){

        //model.addAttribute("deptList", deptListService.getList());
        model.addAttribute("deptList", deptListService.getSearchList(searchOption)); // 처음에는 서치 옵션이 없으므로 모든 정보가 조회된다.

        log.info("dept list 진입...");

    }
}
