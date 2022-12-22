package com.jpa.board.service.reply;

import com.jpa.board.domain.ReplyWriteRequest;
import com.jpa.board.entity.reply.Reply;
import com.jpa.board.repository.reply.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReplyInsertService {

    @Autowired
    private ReplyRepository replyRepository;

    public Reply insertReply(ReplyWriteRequest replyWriteRequest) {

        Reply reply = replyWriteRequest.toReply();

        reply.setRegdate(LocalDateTime.now());
        reply.setUpdatedate(LocalDateTime.now());

        return replyRepository.save(reply);
    }
}
