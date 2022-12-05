package com.bbs.springrestprj.controller.login;

import com.bbs.springrestprj.domain.login.LoginInfo;
import com.bbs.springrestprj.domain.member.Member;
import com.bbs.springrestprj.service.login.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@Log4j2
@RequestMapping("/logins")
public class LoginController {

    @Autowired(required = false)
    private LoginService loginService;

    @GetMapping
    public ResponseEntity<LoginInfo> getLogin(){

        log.info("LoginController GetMapping 진입..");

        //return new ResponseEntity(boardListDTO, HttpStatus.OK);
        return null;
    }

    @PostMapping
    public ResponseEntity<String> login(
             @RequestBody LoginInfo loginInfo,
            HttpServletRequest request,
            HttpServletResponse response,
            RedirectAttributes redirectAttributes
    ){

        log.info("login 메소드 호출...");
        log.info("loginInfo. toString() => " + loginInfo.toString());

        // Header 정의
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("some-header", "some-value");

        ResponseEntity<String> responseEntity = null;

        try{

            ///////////////////////////

            // 아이디 저장에 대한 처리: 체크하면 reId 쿠키 생성 아니면 소멸
            if (loginInfo.getIdremember() != null || loginInfo.getIdremember().equals("on")){
                Cookie c = new Cookie("reId", loginInfo.getMemberid());
                c.setMaxAge(60*60*24*180);
                c.setPath("/");
                response.addCookie(c);
            } else {
                Cookie c = new Cookie("reId", loginInfo.getMemberid());
                c.setMaxAge(0);
                c.setPath("/");
                response.addCookie(c);
            }

            log.info("reID 쿠키 생성 통과!");

            // 로그인 처리를 위한 기본 작업 => 현재 세션으로 객체를 생성한다.
            HttpSession session = request.getSession(); // 로그인 처리를 위해 현재 세션 객체 생성

            // 입력받은 아이디와, 패스워드를 DTO에 저장한다.
            try {

                log.info("loginService.login() 진입 직전!!!");
                log.info("loginInfo.getmemberid() => " + loginInfo.getMemberid());
                log.info("loginInfo.getmemberpw() => " + loginInfo.getMemberpw());

                Member member = loginService.login(loginInfo.getMemberid(), loginInfo.getMemberpw());

                log.info("loginService.login() 처리후 member => " + member);

                if (member == null){

                    redirectAttributes.addAttribute("type", "nf");

                    //return "redirect:/member/loginMember?error=nf";
                    //return "redirect:/logins/login";
                }

                if (loginInfo.getKeeplogin() != null || loginInfo.getKeeplogin().equals("on")){

                    UUID uuid = UUID.randomUUID();
                    Cookie c1 = new Cookie("uuid", uuid.toString());
                    c1.setMaxAge(60*60*24*30);
                    c1.setPath("/");
                    response.addCookie(c1);

                    log.info("uuid 생성되었나? => " + uuid);

                    loginService.updateUUID(member.getSeq(), uuid.toString());
                    member.setUuid(uuid.toString());
                }

                session.setAttribute("loginInfo", member);
                log.info("로그인 처리 후 member => " + member);

         /*   if (session.getAttribute("preUri") != null){
                String str = "redirect:" + session.getAttribute("preUri");
                return str;
            } else {
                return "redirect:/";
            }
*/
            } catch (Exception e) {
                //throw new RuntimeException(e);

                redirectAttributes.addAttribute("type", "e");

            }
          ////////////////////////////////////

            responseEntity = new ResponseEntity("Insert OK!", HttpStatus.OK);

        } catch (Exception e){

            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

}
