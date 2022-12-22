package com.jpa.board.service.reply;

import com.jpa.board.domain.ReplyWriteRequest;
import com.jpa.board.entity.reply.Reply;
import com.jpa.board.repository.reply.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Log4j2
public class ReplyEditService {

    @Autowired
    private ReplyRepository replyRepository;

    public int replyEdit(ReplyWriteRequest replyWriteRequest) {

        Reply reply = replyWriteRequest.toReply();
        reply.setUpdatedate(LocalDateTime.now());
        reply.setRegdate(LocalDateTime.now());
        //reply.setRegdate(LocalDateTime.parse(replyWriteRequest.getRegdate()));

        return replyRepository.save(reply) != null ? 1 : 0;
    }
}
