package com.app.board.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

@RestController
@Log4j2
public class RestTemplateTestController {


    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessage(HttpServletResponse response){

        RestTemplate restTemplate = new RestTemplate();

        // 요청시 필요한 Header 설정
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("test", "testValue");
        //httpHeaders.add("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>("", httpHeaders);

        String result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", String.class, httpHeaders);

        log.info(result);

        return result;
    }

}