package org.zerock.bj2.controller.advice;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.zerock.bj2.controller.ReplyController.DataNotFoundException;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2 // lombok
public class CumstomRestControllerAdvice {
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class) // 어떤 종류가 오류가 발생하면 이걸로 먹어라(?)

    @ResponseStatus(HttpStatus.BAD_REQUEST) // bad_request => 400 에러
    public Map<String,String>  mistype(MethodArgumentTypeMismatchException ex) {

        log.info("MethodArgumentTypeMismatchException");

        return Map.of("Error", "전달한 데이터 타입 문제"); // 데이터 타입이 일치하지 않으면 해당 리턴 반환
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus()
    public Map<String, String> dataNotFound(DataNotFoundException ex) {
return Map.of("Error", "전달한 데이터 타입 문제");
    }

}


// commit test