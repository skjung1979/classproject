package com.todo.todomybatis.controller.todo;

import com.todo.todomybatis.domain.todo.TodoDTO;
import com.todo.todomybatis.service.todo.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/todo/TodoRegister")
@Log4j2
public class TodoRegisterController {

    @Autowired(required = false)
    private TodoService service;

    @GetMapping
    public String getReg(
            HttpServletRequest request,
            HttpServletResponse response,
            Model model
    ) {
        log.info("register get 들어옴");

        return "views/todo/register";

    }

    @PostMapping
    public String postReg(
            @Valid TodoDTO todoDTO, // @Valid처리한 DTO 표시
            BindingResult bindingResult, // validation 결과 담는 객체
            Model model
    ) throws Exception {

        if (bindingResult.hasErrors()) {

           /* for (ObjectError objectError : bindingResult.getAllErrors()){
                log.info(objectError.getCodes()[1] + " => " + objectError.getDefaultMessage());
            }*/
            model.addAttribute("todo", todoDTO);

            return "views/todo/register";
        }

        log.info("register post 들어옴");
        log.info("todoDTO => " + todoDTO);

        service.insertTodo(todoDTO);

        return "redirect:/todo/TodoList";

    }
}
