package org.zerock.bj2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 화면에서 모든 리스트

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PageRequestDTO {
    
    @Builder.Default // => 빌더를 만들 때 값은 안 줘도 기본값을 부여. 기본 생성자 역할
    private int page = 1; // 페이지 번호
    @Builder.Default
    private int size = 10; // 10페이지씩 보기

    public void setPage(int page) { // 페이지 번호로 음수를 입력하면 무조건 1페이지로 이동
        if(page <= 0) {
            this.page = 1;
        }
    }

    public void setSize(int size) { // 
        if(size > 100 || size < 0) {
            this.size = 10;
        }
    }

    public int getSkip() {
        return (this.page -1) * this.size;
    }

    public int getEnd() {
        return this.page * this.size;

    }

    public int getCountEnd() { // get 쓰는 이유 => #을 쓰기 위함

        int temp = (int) (Math.ceil(this.page/10.0)) * 100;

        return temp + 1;

    } 

}
