package org.zerock.bj2.service;

import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.bj2.dto.PageRequestDTO;
import org.zerock.bj2.dto.PageResponseDTO;
import org.zerock.bj2.dto.ReplyDTO;

@Transactional // 인터페이스, 클래스, 메소드 세 군데에 선언 가능
public interface ReplyService {

    Long register(ReplyDTO replyDTO);

    // 목록 테스트
    PageResponseDTO<ReplyDTO> getList(Long tno, PageRequestDTO pageRequestDTO);
    
    ReplyDTO getOne(Long tno);
    
}
