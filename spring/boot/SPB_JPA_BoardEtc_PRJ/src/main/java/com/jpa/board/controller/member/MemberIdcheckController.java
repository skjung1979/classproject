package com.jpa.board.controller.member;

import com.jpa.board.service.member.MemberIdcheckService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/member")
public class MemberIdcheckController {

    @Autowired
    private MemberIdcheckService memberIdcheckService;

    @PostMapping("/idcheck")
    public String idcheck(@RequestParam String memid){

        String checkResult = memberIdcheckService.idcheck(memid);

        return checkResult;
    }

}
