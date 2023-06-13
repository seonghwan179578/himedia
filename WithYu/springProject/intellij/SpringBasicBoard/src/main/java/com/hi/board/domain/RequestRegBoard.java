package com.hi.board.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class RequestRegBoard {

    private String title;
    private String content;
    // 회원제 게시판 작성자는 memidx로 변경
    // private String writer;
    private int memidx;

    // 파일 업로드를 위해서 변수 추가
    private MultipartFile file; // 사용자로부터 받는 파일 객체 // 이름 -> 주옥을 피하기 위해서 난수 + 원래이름 => 새로운 이름(하단의 filename의 이름이 됨), 저장
    private String filename; // DB에 저장할 File 이름

}
