package com.app.board.controller;

import com.app.board.domain.ReplyDTO;
import com.app.board.service.service.ReplyDeleteService;
import com.app.board.service.service.ReplyEditService;
import com.app.board.service.service.ReplyInsertService;
import com.app.board.service.service.ReplyListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/reply")
public class ReplyRestController {

    @Autowired
    private ReplyListService replyListService;

    @Autowired
    private ReplyDeleteService replyDeleteService;

    @Autowired
    private ReplyInsertService replyInsertService;

    @Autowired
    private ReplyEditService replyEditService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReplyDTO>> selectAll(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("content-Type", "application/json");

        return new ResponseEntity<>(replyListService.selectAll(), httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping("/{rno}")
    public ResponseEntity<String> deleteReply(
            @PathVariable("rno") int rno
    ){

        log.info(replyDeleteService.deleteReply(rno) + rno);

        return new ResponseEntity<>("deleted ...", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ReplyDTO> insertReply(
            @RequestBody ReplyDTO replyDTO
    ){


        log.info(replyDTO);

        replyDTO.setReplydate(LocalDate.now().toString());
        replyDTO.setUpdatedate(LocalDate.now().toString());
        replyInsertService.insertReply(replyDTO);



        log.info(replyDTO);

        return new ResponseEntity<>(replyDTO, HttpStatus.OK);
    }

    @PutMapping("/{no}")
    public ResponseEntity<ReplyDTO> editReply(
            @PathVariable("no") int rno,
            @RequestBody ReplyDTO replyDTO
    ){

        replyDTO.setRno(rno);

        log.info(replyDTO);

        replyEditService.editReply(replyDTO);

        log.info(replyDTO);

        return new ResponseEntity<>(replyDTO, HttpStatus.OK);
    }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<Map<String, String>> except(Exception exception){

        Map<String, String> map = new HashMap<>();
        map.put("error message", exception.getMessage());
        map.put("error type", exception.getClass().getSimpleName());

        return ResponseEntity.internalServerError().body(map);

    }

}