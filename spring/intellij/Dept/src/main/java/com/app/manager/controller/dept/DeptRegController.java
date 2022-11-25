package com.app.manager.controller.dept;

import com.app.manager.domain.DeptDTO;
import com.app.manager.service.dept.DeptRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Log4j2
@Controller
@RequestMapping("/dept/register")
public class DeptRegController {

    @Autowired
    private DeptRegService deptRegService;

    @GetMapping
    public void getRegForm(){
        log.info("regForm 진입");
    }

    @PostMapping
    public String reg(
            @Valid DeptDTO deptDTO,
            BindingResult bindingResult
    ){

        log.info("reg Post 진입");
        log.info(deptDTO);

        if (bindingResult.hasErrors()){ // 정상이라면 이 값은 false로 들어옴 => true이면 에러가 발생한 것!!!
            log.info(bindingResult.getAllErrors());
            for (ObjectError objectError : bindingResult.getAllErrors()){

                log.info(objectError.getCodes()[1]+ " ==> " + objectError.getDefaultMessage()); // => 에러 메세지 표시
                // 문제가 발생하는 상황이므로 리다이렉션 시켜서 다시 입력을 받든지 내부에서 전처리 하든지 결정한다.

            }
        };

        deptRegService.insertDept(deptDTO);
        //deptRegService.insertDepts(deptDTO);

        return "redirect:/dept/list";
    }

}
