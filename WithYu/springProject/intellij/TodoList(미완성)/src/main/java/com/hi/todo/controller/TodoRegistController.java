package com.hi.todo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/*메소드로 구분해서 처리하겠다*/
@RequestMapping("/todo/regist")
@Log4j2
public class TodoRegistController {


    // get : form이 보이는 페이지로 응답 처리
    @RequestMapping(method = RequestMethod.GET)
    public String getRegistForm() {
        log.info("GET /todo/regist ");
        return "todo/registForm";
        // /WEB-INF/views/todo/registForm.jsp
    }

    // post : redirect 한다 -> /todo/list 로 redirect => view가 필요 없다!!
    @RequestMapping(method = RequestMethod.POST)
    public String regist() {
        log.info("post /todo/regist");
        return "redirect:/todo/list";
        // 일반 view와 구분은 redirect: 문자열로 구분
        // http://localhost:8080/todo/list
    }





    }






