package com.jpa.board.service.reply;

import com.jpa.board.domain.ReplyWriteRequest;
import com.jpa.board.entity.board.Board;
import com.jpa.board.entity.reply.Reply;
import com.jpa.board.repository.board.BoardRepository;
import com.jpa.board.repository.reply.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class ReplyInsertService {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private BoardRepository boardRepository;

    public Reply insertReply(ReplyWriteRequest replyWriteRequest) {

        Reply reply = replyWriteRequest.toReply();

        reply.setRegdate(LocalDateTime.now());
        reply.setUpdatedate(LocalDateTime.now());

        // 댓글수 업데이트(증가) 준비 시작
        Long rpcnt = 0L;

        Board board = boardRepository.findById(replyWriteRequest.getBidx()).get();

        if (board.getRpcnt() == null){
            rpcnt = 1L;
        } else {
            rpcnt = board.getRpcnt() + 1;
        }

        log.info("rpcnt ................................ ==> " + rpcnt);

        board.setRpcnt(rpcnt);
        // 댓글수 업데이트 준비 끝

        Reply resultReply = replyRepository.save(reply);

        if (resultReply != null){
            // 댓글수 업데이트 적용
            boardRepository.save(board);
        }

        return resultReply;
    }
}
