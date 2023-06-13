package org.zerock.bj2.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.bj2.dto.PageRequestDTO;
import org.zerock.bj2.dto.ReplyDTO;
import org.zerock.bj2.service.ReplyService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2 // lombok
public class ReplyMapperTests {
    
    @Autowired(required = false)
    private ReplyMapper replyMapper;

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build(); // 1, 10
        Long tno = 100L;

        replyMapper.selectList(tno, pageRequestDTO)
        .forEach(dto -> log.info(dto));
    }

    @Test
    @Transactional
    @Commit
    public void testInsertChild() {
        ReplyDTO replyDTO = ReplyDTO.builder() 
        .tno(100L)
        .reply("댓글 테스트")
        .replyer("replyer00")
        .gno(9L)
        .build();

        replyMapper.insertChild(replyDTO);
    }

   



    @Test
    @Transactional
    @Commit // 테스트코드는 롤백이 기본 설정이기 때문에 commit 설정 필요
    public void testInsert() {
        
        // DB에 추가되는 내용
        ReplyDTO replyDTO = ReplyDTO.builder() 
        .tno(100L)
        .reply("댓글 테스트")
        .replyer("replyer00")
        .build();

        int insertCount = replyMapper.insert(replyDTO);

        Assertions.assertEquals(insertCount, 1);

        //예외 던지기. 
        if(insertCount != 1) {
            throw new RuntimeException("INSERT FAIL");
        }

        Long rno = replyDTO.getRno();

        log.info("RNO:" + rno);

        replyMapper.updateGno(rno);




        // 이 로직이 서비스로 가게 되는 것
    }

}
