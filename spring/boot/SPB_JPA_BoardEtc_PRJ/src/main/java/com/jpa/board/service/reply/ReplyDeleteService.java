package com.jpa.board.service.reply;

import com.jpa.board.entity.board.Board;
import com.jpa.board.entity.reply.Reply;
import com.jpa.board.repository.board.BoardRepository;
import com.jpa.board.repository.reply.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ReplyDeleteService {
    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyReadService replyReadService;

    public int deleteReply(Long ridx) {

        Reply reply = replyRepository.findById(ridx).get();
        Board board = boardRepository.findById(reply.getBidx()).get();

        int result = replyRepository.deleteByRidx(ridx);
        log.info("삭제 변수 result는?...............==> " + result);

        // 댓글수 업데이트(차감) 준비 시작
        Long rpcnt = 0L;

        if (board.getRpcnt() == null) {
            rpcnt = 0L;
        } else {
            rpcnt = board.getRpcnt() - 1;
        }

        log.info("rpcnt ................................ ==> " + rpcnt);

        board.setRpcnt(rpcnt);
        // 댓글수 업데이트(차감) 준비 끝

        if (result > 0) {
            // 댓글수 업데이트 적용
            boardRepository.save(board);
        }

        return result;
    }
}
