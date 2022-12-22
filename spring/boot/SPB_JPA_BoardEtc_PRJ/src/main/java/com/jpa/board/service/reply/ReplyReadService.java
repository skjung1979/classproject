package com.jpa.board.service.reply;

import com.jpa.board.entity.reply.Reply;
import com.jpa.board.repository.reply.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyReadService {

    @Autowired
    private ReplyRepository replyRepository;

    public Reply selectByRidx(Long ridx) {

        return replyRepository.findById(ridx).get();
    }
}
