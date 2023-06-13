package org.zerock.bj2.mappers;

import org.apache.ibatis.annotations.Param;
import org.zerock.bj2.dto.PageRequestDTO;
import org.zerock.bj2.dto.ReplyDTO;
import java.util.*;

public interface ReplyMapper {
    
    int insert(ReplyDTO replyDTO);
    
    int updateGno (Long rno);

    int insertChild(ReplyDTO replyDTO);

    List<ReplyDTO> selectList(@Param("tno") Long tno, @Param("pr") PageRequestDTO pageRequestDTO);

    ReplyDTO selectOne(Long rno);

    int getTnoCount(Long tno);
    

}
