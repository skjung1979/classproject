package com.app.board.controller.user;

import com.app.board.service.user.UserLoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
@RequestMapping("/user/login")
@Log4j2
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping
    public void getLogin(){

    }

    @PostMapping
    public String postLogin(
            @RequestParam("uId") String userId,
            @RequestParam("uPw") String userPw,
            HttpServletRequest request
    ) throws SQLException {

        log.info("@RequestParam uId , uPw => " + userId + "/" + userPw);

        HttpSession session = request.getSession();

        session.setAttribute("loginInfo", userLoginService.selectByIdPw(userId, userPw));

        log.info("session의 loginInfo => " + session.getAttribute("loginInfo"));

        return "redirect:/user/mypage";
    }
}
