package com.app.board.controller.user;

import com.app.board.domain.UserDTO;
import com.app.board.service.user.UserMypageReadServie;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
@RequestMapping("/user/mypage")
@Log4j2
public class UserMypageController {

    @Autowired
    private UserMypageReadServie userMypageReadServie;


    @GetMapping
    public String getMypage(
            Model model,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws SQLException {

        HttpSession session = request.getSession();

        UserDTO userDTO = (UserDTO) session.getAttribute("loginInfo");

        log.info("UserMypageController.java 진입............");
        log.info("session의 loginInfo => " + userDTO);

        model.addAttribute("loginInfo", userMypageReadServie.getUserMypage(userDTO.getUserId()));

        return "/user/mypage";
    }

}
