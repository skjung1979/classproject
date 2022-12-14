package com.potato.nedonado.controller.user;

import com.potato.nedonado.model.user.UserDTO;
import com.potato.nedonado.service.user.UserLoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.UUID;

@Controller
@RequestMapping("/login")
@Log4j2
public class UserLoginController {

    private final UserLoginService userLoginService;

    public UserLoginController(UserLoginService userLoginService){
        this.userLoginService = userLoginService;
    }

    @GetMapping
    public String getLoginPage(HttpSession session){

        log.info("get login...");

        // 로그인 상태 체크
        if (session.getAttribute("loginInfo") != null){
            return "redirect:/app/v1/item/list";
        }
        return "/user/login";
    }

    @PostMapping
    public String postLogin(
            @ModelAttribute UserDTO userDTO,
            BindingResult bindingResult,
            HttpServletRequest req,
            HttpServletResponse res,
            RedirectAttributes rttr) throws SQLException {
        log.info("post login ...");

        if (bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            return "redirect:/login";
        }

        HttpSession session = req.getSession();

        UserDTO user = userLoginService.loginByIdPw(userDTO.getUserId(), userDTO.getUserPw());

        if (user == null){
            log.info("login fail data notmatch ...");
            String message = "아이디 혹은 비밀번호가 일치하지 않습니다.";
            rttr.addFlashAttribute("loginFailMsg", message);

            return "redirect:/login";
        }

        log.info(user);

        String rememberMe = req.getParameter("rememberMe");
        log.info("remember" + rememberMe);

        if (rememberMe != null && rememberMe.equals("on")){
            UUID uuid = UUID.randomUUID();
            log.info("uuid = " + uuid);
            Cookie c = new Cookie("uuid", uuid.toString());
            c.setMaxAge(60*60*24*3);
            c.setPath("/");
            res.addCookie(c);

            userLoginService.udpateUUID(uuid.toString(), user.getUserIdx());
        }

        session.setAttribute("loginInfo", user.loginData());

        return "redirect:/app/v1/item/list";

    }
}
