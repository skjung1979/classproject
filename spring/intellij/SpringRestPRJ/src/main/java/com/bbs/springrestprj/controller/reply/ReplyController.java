package com.bbs.springrestprj.controller.reply;

import com.bbs.springrestprj.domain.reply.ReplyDTO;
import com.bbs.springrestprj.service.reply.ReplyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/replys")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @GetMapping("/all")
    public ResponseEntity<List<ReplyDTO>> listReplys(){

        log.info("listReplys 메소드 호출...");

        List<ReplyDTO> list = replyService.listReplys();

        log.info(list);

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/board/{no}")
    public ResponseEntity<List<ReplyDTO>> listReplysByBno(
            @PathVariable("no") int bno
    ){
        log.info("listReplysByBno 메소드 호출...");

        List<ReplyDTO> list = replyService.listReplysByBno(bno);

        return new ResponseEntity(list, HttpStatus.OK);
    }


    @GetMapping("/{no}")
    public ResponseEntity<ReplyDTO> listOneReplys(
            @PathVariable("no") Integer rno
    ){

        log.info("listOneReply 메소드 호출...");

        ReplyDTO replyDTO = replyService.listOneReply(rno);

        log.info(replyDTO);

        return new ResponseEntity(replyDTO, HttpStatus.OK);
    }

    @GetMapping("/Maxrno")
    public int maxRno(){

        log.info("maxRno 메소드 호출...");

        int result = replyService.maxRno();

        log.info("Maxrno => " + result);

        return result;
    }

    @GetMapping("/membernm")
    public String membernm(){

        log.info("membernm 메소드 호출...");

        String result = replyService.membernm(7);

        log.info("membernm => " + result);

        return result;
    }

    @PostMapping
    public ResponseEntity<String> addReply(
            @RequestBody ReplyDTO replyDTO
    ){

        log.info("addReply 메소드 호출...");
        log.info("replyDTO. toString() => " + replyDTO.toString());

        // Header 정의
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("some-header", "some-value");

        ResponseEntity<String> responseEntity = null;

        try{

            replyService.addReply(replyDTO);

            responseEntity = new ResponseEntity("Insert OK!", HttpStatus.OK);

        } catch (Exception e){

            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @PutMapping("/{no}")
    public HttpEntity<String> editReply(
            @PathVariable("no") Integer rno,
            @RequestBody ReplyDTO replyDTO
    ){

        log.info("editReply 메소드 진입...");
        log.info(rno);
        log.info(replyDTO.toString());

        // Header 정의
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("some-header", "some-value");

        replyService.editReply(replyDTO);

        return new HttpEntity<String>("update OK", httpHeaders);
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<String> removeReply(
            @PathVariable("no") Integer rno
    ){

        log.info("removeReply 메소드 호출....");
        log.info("bno => " + rno);

        ResponseEntity<String> responseEntity = null;

        try{

            responseEntity = new ResponseEntity(replyService.removeReply(rno), HttpStatus.OK);

        } catch (Exception e){

            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

}
