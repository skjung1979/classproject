package com.potato.nedonado.controller.board;

import com.potato.nedonado.service.board.ItemWriteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@Log4j2
@RequestMapping("/board/write")
public class ItemWriteController {

    @Autowired
    private ItemWriteService itemWriteService;

    public ModelAndView writeItem(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.addObject("itemCategory", CategoryUtil.categoryNames);
        mav.setViewName("/board/itemwrite");
        return mav;
    }

}
