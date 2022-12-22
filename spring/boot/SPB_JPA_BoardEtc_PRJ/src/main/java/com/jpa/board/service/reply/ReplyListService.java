package com.jpa.board.service.reply;

import com.jpa.board.entity.reply.Reply;
import com.jpa.board.repository.reply.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ReplyListService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<Reply> selectReplyList(Long bidx) {

        return replyRepository.findByBidx(bidx);
    }
}
