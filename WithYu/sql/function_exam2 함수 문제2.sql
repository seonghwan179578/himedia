select * from orders;
select * from customer;
select * from book;

-- fucntion exam2 함수 문제2

--1 마당서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
--(3) 박지성의 총구매액(박지성의 고객번호는 1번으로 놓고작성)

select sum(saleprice)
from orders
where custid=1 -- 박지성의 고객번호가 1이므로 고객번호1만을 제한
;

--(4) 박지성이 구매한 도서의수(박지성의 고객번호는 1번으로 놓고작성)
select count(*)
from orders
where custid=1
;

--2 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
--(1) 마당서점 도서의 총개수
select count(*)
from book
;

--(2) 마당서점에 도서를 출고하는 출판사의 총개수
select count(distinct publisher) 
from book 
order by publisher
;
​-- distinct로 중복을 제외한 후 count로 개수를 샌다)