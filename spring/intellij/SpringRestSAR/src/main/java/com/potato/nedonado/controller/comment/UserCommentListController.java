package com.potato.nedonado.controller.comment;

import com.potato.nedonado.model.user.LoginInfo;
import com.potato.nedonado.service.comment.UserCommentListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j2
@RequestMapping("/user/mycomment")
public class UserCommentListController {

    @Autowired
    private UserCommentListService userCommentListService;

    public void getMyComment(
            Model model,
            HttpServletRequest request
    ) {
        log.info(" >>> get myComment Page >>> ");

        LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute("loginInfo");
        log.info("loginInfo = " + loginInfo);
        model.addAttribute("myCommentList", userCommentListService.selectCommentByUserIdx(loginInfo.getUserIdx()));

    }
}
