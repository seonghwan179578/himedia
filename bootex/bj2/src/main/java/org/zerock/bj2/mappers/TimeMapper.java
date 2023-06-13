package org.zerock.bj2.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

   //  @Select("select now()") // @Select 할때 ibatis
    String getTime(); // 시간 확인 용도

}

