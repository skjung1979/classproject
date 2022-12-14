package com.potato.nedonado.service.board;

import com.potato.nedonado.mapper.BoardMapper;
import com.potato.nedonado.model.board.ItemEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ItemViewService {

    @Autowired(required = false)
    private BoardMapper boardMapper;

    public ItemEntity selectItemByIdx(long idx){
        return boardMapper.selectItemByIdx(idx);
    }

    public ItemEntity selectItemByIdxAndUserIdx(long idx, long userIdx){
        return boardMapper.selectItemByIdxAndUserIdx(idx, userIdx);
    }
}
