package com.app.board.controller.user;

import com.app.board.domain.UserDTO;
import com.app.board.domain.UserRegistRequest;
import com.app.board.service.user.UserRegisterService;
import lombok.extern.log4j.Log4j2;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@Log4j2
@RequestMapping("/user/register")
public class UserRegisterController {

    @Autowired
    private UserRegisterService userRegisterService;

    @GetMapping
    public String getRegistUser(){

        return "/user/register";
    }

    @PostMapping
    public String postRegistUser(
            UserRegistRequest userRegistRequest,
            HttpServletRequest request
    ){

        log.info("userRegistRequest => " + userRegistRequest);

        String absolutePath = new File("").getAbsolutePath();

        log.info(">>> absolutePage page: " + absolutePath);

        userRegisterService.userRegist(userRegistRequest);

        return "/user/login";
    }


}
