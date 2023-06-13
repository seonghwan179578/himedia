package org.zerock.bj2.service;

import org.springframework.stereotype.Service;
import org.zerock.bj2.dto.PageRequestDTO;
import org.zerock.bj2.dto.PageResponseDTO;
import org.zerock.bj2.dto.TodoDTO;
import org.zerock.bj2.mappers.TimeMapper;
import org.zerock.bj2.mappers.TodoMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor // 이거 있어서 무조건 final로 고정된 생성자가 만들어짐
public class TodoServiceImple  implements TodoService{
    

    private final TimeMapper timeMapper;
    private final TodoMapper todoMapper;

    @Override
    public PageResponseDTO<TodoDTO> getList(PageResponseDTO pageResponseDTO);
    long total = todoMapper.listCount(PageRequestDTO);

    return PageResponseDTO.<TodoDTO>withAll()
    .list(list)
    .total(total)
    .build();



}
