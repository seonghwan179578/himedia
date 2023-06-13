package com.hi.todo.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class TodoDeleteController {

    // 삭제번호 받고 -> 삭제 하고 -> /todo/list로 이동
    @RequestMapping("/todo/delete") // - > 바로 밑의 deleteTodo 메소드를 실행히켜주는 역할
    public String deleteTodo() { // 리디렉션할 경로를 지정해야 하기 때문에 String 처리
        log.info(" /todo/delete");
        return "redirect:/todo/list";
    }
    
    
}
