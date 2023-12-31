package com.hi.board.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class BoardDTO { // sql에서의 column 이름

    private int bno;
    private String title;
    private String content;
    private String writer;
    // 업로드한 파일의 이름
    private String file;
    private String regdate;
    private String updatedate;

    // 작성자의 idx
    private int memidx;
}
