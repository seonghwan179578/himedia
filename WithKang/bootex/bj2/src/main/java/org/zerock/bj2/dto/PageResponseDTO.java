package org.zerock.bj2.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageResponseDTO<E> {

    
    private List<E> list;

    private long total;// 화면에 출력하기 위함

    @Builder(builderMethodName = "withAll")
    public void PageRequestDTO(List<E> list, long total) {
        this.list = list;
        this.total = total;
    }
    
}
