package com.firstcoding.mvc.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
public class SearchController {

    @RequestMapping("/search/search")
    public String searchForm(

    ){

        return "searchForm";
    }

    @RequestMapping("/board/board") // 여기에도 @ModelAttribute가 공유된다.
    public String board(){

        return "board";
    }

    @ModelAttribute("keywords") // @ModellAttribute를 사용하면 같은 클래스 내부에 있는 @리퀘스트매핑이 있는 메소드로 전달된다.
    public String[] getKeywords(){ // 배열 혹은 String 타입 List도 OK

        return new String[] {"손흥민", "월드텁", "이강인", "김민재", "카타르", "독일"};
    }

    @ModelAttribute("searchType") // @ModellAttribute를 사용하면 같은 클래스 내부에 있는 @리퀘스트매핑이 있는 메소드로 전달된다.
    public List<String> getSearchType(){ // 배열 혹은 String 타입 List도 OK

        List<String> list = new ArrayList<>();
        list.add("id");
        list.add("title");
        list.add("keyword");

        return list;
    }

}
