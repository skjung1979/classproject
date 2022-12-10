package com.potato.nedonado.controller.user;

import com.potato.nedonado.model.user.UserDTO;
import com.potato.nedonado.service.user.UserRegisterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;

@Controller
@RequestMapping("/register")
@Log4j2
public class UserRegistController {

    private final UserRegisterService userRegisterService;

    public UserRegistController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    @GetMapping
    public void getInsertUser(){
        log.info("get register...");
    }

    @PostMapping
    public String postInsertUser(
            @ModelAttribute UserDTO userDTO,
            BindingResult bindingResult,
            RedirectAttributes rttr
    ) throws SQLException {
        log.info("post register ...");

        log.info(userDTO);

        userRegisterService.insertUser(userDTO);

        String message = "너도나도에 가입하신 걸 환영합니다. \n 로그인 화면으로 이동합니다.";
        rttr.addFlashAttribute("regMsg", message);

        return "redirect:/login";
    }
}
