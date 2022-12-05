package com.app.board.service.board;

import com.app.board.domain.BoardDTO;
import com.app.board.domain.BoardRegRequestDTO;
import com.app.board.domain.ReplyDTO;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Service
public class BoardRegService {

    @Autowired(required = false)
    private BoardMapper boardMapper;

    public int regBoardContent(BoardRegRequestDTO boardRegRequestDTO){

        BoardDTO boardDTO = boardRegRequestDTO.toBoardDTO();

        if (boardRegRequestDTO.getPhoto() != null && boardRegRequestDTO.getPhoto().getSize()>0){
            try {
                File saveDir = new File("C:\\upload\\board");
                String newFileName = UUID.randomUUID().toString()+boardRegRequestDTO.getPhoto().getOriginalFilename();
                boardRegRequestDTO.getPhoto().transferTo(new File(saveDir, newFileName));
                boardDTO.setPhoto(newFileName);

            } catch (IOException e) {
            }
        }

        int result = 0;

        try {
            result = boardMapper.insertBoardContent(boardDTO);
        } catch (SQLException e){
            // DB 입력 오류시 저장된 파일이 있다면 삭제해준다!
            File savedDir = new File("C:\\upload\\board", boardDTO.getPhoto());

            // 파일 존재 유무 확인
            if(savedDir.exists()){
                savedDir.delete();
            }
        }

        return result;
    }
}