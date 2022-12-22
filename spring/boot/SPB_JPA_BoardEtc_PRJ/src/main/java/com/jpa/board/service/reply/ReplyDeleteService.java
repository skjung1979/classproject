package com.jpa.board.service.reply;

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
    private ReplyReadService replyReadService;

    public int deleteReply(Long ridx) {

        return replyRepository.deleteByRidx(ridx);
    }
}
