package com.bbs.springrestprj.controller.member;

import com.bbs.springrestprj.domain.member.Member;
import com.bbs.springrestprj.domain.member.MemberRegRequest;
import com.bbs.springrestprj.service.member.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/members")
@Log4j2
public class MemberController {

    @Autowired(required = false)
    private MemberService memberService;

    @GetMapping("/all")
    public String regMember(
            HttpServletRequest request,
            HttpServletResponse response,
            Model model
    ) {
        return "member/regform";


//        RestTemplate restTemplate = new RestTemplate();
//        // 요청시 필요한 Header 설정
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("test", "testValue");
//        //httpHeaders.add("Content-Type", "application/json");
//        HttpEntity<String> entity = new HttpEntity<>("", httpHeaders);
//
//        String result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", String.class, httpHeaders);
//
//        log.info(result);
//
//        return result;



    }

 /*   @PostMapping
    public String reMember(
            MemberRegRequest memberRegRequest,
            //@Valid MemberRegRequest memberRegRequest, // @valid 기능을 제대로 못함
            HttpServletRequest request, // 파일의 실제 저장 경로를 찾기 위한 것
            //BindingResult bindingResult,
            Model model
    ) throws Exception {

//        log.info("회원 가입 post 진입 >>>>>>>>>>>>  "+bindingResult.hasErrors());
//        if (bindingResult.hasErrors()){
//
//            model.addAttribute("regmem", memberRegRequest);
//
//            log.info("bindingResult.hasErrors() 진입");
//
//            return "views/member/regform";
//        }

        if (memberRegRequest.getUsername().equals("") || memberRegRequest.getUserid().equals("") || memberRegRequest.getUserpw().equals("")) {
            model.addAttribute("regmem", memberRegRequest);
            model.addAttribute("msg2", "회원명, ID, PW는 빈칸이 허용 안됩니다.");

            log.info("memberRegRequest => " + memberRegRequest);

//            return "redirect:/member/regMember";
            return "member/regform";
        }


        log.info(memberRegRequest);

        memberRegService.insertMember(memberRegRequest, request);

        return "redirect:/login/loginMember";
    }*/

    @GetMapping("/loginMember")
    public ResponseEntity<Member> oneMember(
            HttpServletRequest request
    ){
        HttpSession session;
        session = request.getSession();

        log.info("oneMember 메소드 호출...");
        log.info("session loginInfo 정보 => " + session.getAttribute("loginInfo"));

        Member member = (Member) session.getAttribute("loginInfo");

        log.info("member => " + member);

        //return new ResponseEntity(boardListDTO, HttpStatus.OK);
        return new ResponseEntity(member, HttpStatus.OK);
    }

    @PostMapping (consumes = MediaType.MULTIPART_FORM_DATA_VALUE)// JSON 데이터를 받아서 처리함,
    public ResponseEntity<String> regMember(
            HttpServletRequest request,
            @RequestBody MemberRegRequest memberRegRequest
    ) throws Exception {
        // ResponseEntity<String> => 응답 데이터를 제네릭으로 정의하는 것이다.
        // ResponseEntity를 사용함으로써 객체 생성 시 응답 데이터를 정의, http header, http status code를 정의해서 응답 처리 가능하다.

        log.info("member => " + memberRegRequest);

        memberService.insertMember(memberRegRequest, request);

        //return new ResponseEntity<>("insert OK", HttpStatus.OK);
        return new ResponseEntity<>("redirect:/", HttpStatus.OK);
    }



}
