package com.potato.nedonado.controller.user;

import com.potato.nedonado.model.user.LoginInfo;
import com.potato.nedonado.service.user.UserMyPageReadService;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
@RequestMapping("/user/mypage")
@Log4j2
public class UserMyPageReadController {

    private final UserMyPageReadService myPageReadService;

    public UserMyPageReadController(UserMyPageReadService myPageReadService) {
        this.myPageReadService = myPageReadService;
    }

    @GetMapping
    public void getMyPage(
            Model model,
            HttpServletRequest req
    ) throws SQLException {
        log.info("get MyPage ... ");

        LoginInfo loginInfo = (LoginInfo) req.getSession().getAttribute("loginInfo");
        log.info(loginInfo);
        model.addAttribute("user", myPageReadService.selectUserByIdx(loginInfo.getUserIdx()));
    }
}
