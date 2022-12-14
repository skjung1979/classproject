package com.app.board.controller.reply;

import com.app.board.domain.ReplyDTO;
import com.app.board.service.reply.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/reply")
public class ReplyRestController {

    // get "/reply" => list로 응답
    // post "/reply" => reply객체 그대로(@RequestBody로 받아-JSON형식) 전송
    // put "/reply/{rno}" => reply객체 그대로(@RequestBody로 받아-JSON형식) 전송
    // delete "/reply/{rno}" => 성공여부만 판단하므로, 0 또는 1 , ok 또는 fail로 응답

    @Autowired
    private ReplyListService replyListService;

    @Autowired
    private ReplyInsertService replyInsertService;

    @Autowired
    private ReplyReadService replyReadService;

    @Autowired
    private ReplyDeleteService replyDeleteService;

    @Autowired
    private ReplyEditService replyEditService;

    @GetMapping(value = "/{bno}", produces = MediaType.APPLICATION_JSON_VALUE) // produces 이 메소드의 반환 형식?타입 정의
    public ResponseEntity<List<ReplyDTO>> selectList(
            @PathVariable("bno") int bno
    ) {

        List<ReplyDTO> list = replyListService.selectAll(bno);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping // 저장하고 응답 해줘야 한다. => 댓글 리스트에 표시해 줘야 하므로!!
    public ResponseEntity<ReplyDTO> insertReply(
            // client로 부터 JSON 데이터를 받아서 DB insert
            @RequestBody ReplyDTO replyDTO
    ) {
        log.info("PostMapping .... insert 전 replyDTO => " + replyDTO);

        replyInsertService.insertReply(replyDTO);

        log.info("PostMapping .... insert 후 replyDTO => " + replyDTO); // rno값이 갱신된 데이터에 들어가 있는지 확인!!!

        return new ResponseEntity<>(replyReadService.selectByRno(replyDTO.getRno()), HttpStatus.OK); // 갱신받은 rno로 다시 ReplyDTO를 담아온다.(DB의 등록일자 정보 가져옴)
    }

    @PutMapping("/{rno}")
    public ResponseEntity<Integer> editReply(
            @PathVariable("rno") int rno,
            @RequestBody ReplyDTO replyDTO
    ){
        replyDTO.setRno(rno);

        return new ResponseEntity<>(replyEditService.updateReply(replyDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{rno}")
    public ResponseEntity<Integer> delete(
            @PathVariable("rno") int rno
    ){
        return new ResponseEntity<>(replyDeleteService.deleteByRno(rno), HttpStatus.OK);
    }
}
