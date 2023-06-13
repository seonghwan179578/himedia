package org.zerock.bj2.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    
    private Long rno; // 댓글 번호
    private Long tno; // 게시글 번호
    private String reply; // 댓글
    private String replyer; // 댓글 작성자

    @Builder.Default
    private Long gno = 0L; // 댓글이 없을 수도 있으니 0이 default

    private int step;
    
    private LocalDate replyDate; // 댓글 작성 시간

}
