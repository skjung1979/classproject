package com.jpa.board.controller.reply;

import com.jpa.board.domain.BoardWriteRequest;
import com.jpa.board.domain.ReplyWriteRequest;
import com.jpa.board.entity.member.Member;
import com.jpa.board.entity.reply.Reply;
import com.jpa.board.repository.reply.ReplyRepository;
import com.jpa.board.service.member.MemberReadService;
import com.jpa.board.service.reply.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reply")
@Log4j2
public class ReplyRestController {

    @Autowired
    private ReplyRepository replyRepository;

    // get ==> /reply ==> list로 응답 받음
    // post ==> /reply ==> reply객체 그대로(@RequestBody로 받아 ) 전송
    // put ==> /reply/{ridx} ==> reply객체 그대로(@RequestBody로 받아 ) 전송
    // delete ==> /reply/{ridx} ==> 성공 여부만 판단하므로, 0또는1 / ok또는failfh 응답 받음

    @Autowired
    private ReplyInsertService replyInsertService;

    @Autowired
    private ReplyReadService replyReadService;

    @Autowired
    private ReplyListService replyListService;

    @Autowired
    private ReplyEditService replyEditService;

    @Autowired
    private ReplyDeleteService replyDeleteService;

    @Autowired
    private MemberReadService memberReadService;

    // 댓글 등록
    // 댓글 리스트에 표시해 줘야 하므로, 저장하고 응답 해줘야 한다.
    @PostMapping
    public ResponseEntity<Reply> insertReply(
            @RequestBody ReplyWriteRequest replyWriteRequest
            ){
        log.info("PostMapping............. insert 전 replyWriteRequest ==> " + replyWriteRequest);

        Reply resultReply = replyInsertService.insertReply(replyWriteRequest);
        // --> 입력후 생성된 ridx값을 전달 받는다.

        Reply reply = replyReadService.selectByRidx(resultReply.getRidx());

        log.info("PostMapping............. insert 후 resultReply ==> " + resultReply);
        
        Member member = memberReadService.selectMember(resultReply.getReplyer().getMemcd());
        resultReply.setReplyer(member);

        log.info("PostMapping...... insert 후... member업데이트 후 resultReply ==> " + resultReply);

        return new ResponseEntity<>(resultReply, HttpStatus.OK);
    }

    @GetMapping("/{bidx}")
    public ResponseEntity<List<Reply>> getReplyList(
            @PathVariable("bidx") Long bidx
    ){

        List<Reply> list = replyListService.selectReplyList(bidx);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{ridx}")
    public ResponseEntity<Integer> deleteReply(
            @PathVariable("ridx") Long ridx
    ){

        return new ResponseEntity<>(replyDeleteService.deleteReply(ridx), HttpStatus.OK);
    }

    @PutMapping("/{ridx}")
    public ResponseEntity<Integer> updateReply(
            @PathVariable("ridx") Long ridx,
            @RequestBody ReplyWriteRequest replyWriteRequest
    ){

        replyWriteRequest.setRidx(ridx);

        log.info("replyDTO............. ==> " + replyWriteRequest);

        return new ResponseEntity<>(replyEditService.replyEdit(replyWriteRequest), HttpStatus.OK);
    }

}
