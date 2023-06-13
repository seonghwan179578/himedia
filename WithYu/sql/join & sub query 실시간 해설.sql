-- join & sub query 해설

-- 1 마당서점의 고객이 요구하는 다음 질문에 대해SQL 문을 작성하시오.
-- (5) 박지성이 구매한 도서의 출판사수

select count( distinct b.publisher)
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
and c.name='박지성'
;

-- (6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
select c.name, b.bookname, b.price, o.saleprice, b.price - o.saleprice as gap
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
;


-- (7) 박지성이 구매하지 않은 도서의 이름

-- 구매한 도서를 찾고 해당 범위를 반전
-- 박지성이 구매한 도서의 bookid
-- 변수로 중복이 발생할 수도 있기 때문에 distinct 적용

-- 박지성이 구매한 도서 번호
select distinct bookid
from orders o, customer c
where o.custid=c.custid and c.name='박지성'
;

-- 최종
-- 범위 반전을 위해 not in을 사용
select bookname
from book
where bookid not in(select distinct bookid
                from orders o, customer c
                where o.custid=c.custid and c.name='박지성')
;


-- 2 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
-- (8) 주문하지 않은 고객의 이름(부속질의 사용)

-- 구매를 한 고객의 번호
select distinct custid from orders;

-- 최종
select name
from customer
where custid not in(select distinct custid from orders)
;

-- 구매 이력이 있는 고객
select*
from customer c
where exists (select * from orders o where c.custid=o.custid) -- select의 결과가 1행이라도 있으면 참 -- 상관관계 필수
;


-- (9) 주문 금액의 총액과 주문의 평균 금액
select sum(saleprice), avg(saleprice) from orders;


-- (10) 고객의 이름과 고객별 구매액

-- group by, c.custid, c.name
--orders, customer 조인 필요

-- join, group by 사용 -- group by => 컬럼 2개 사용,name, custid => 중복
-- 최종
select c.custid, c.name, sum(o.saleprice) as total
from orders o, customer c
where o.custid=c.custid
group by c.custid, c.name
order by c.custid
;


-- (11) 고객의 이름과 고객이 구매한 도서목록
select c.name, b.bookname
from orders o, book b, customer c
where o.bookid=b.bookid and c.custid=c.custid
;


-- (12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문(질문, 타이핑 덜함)

-- 정가 - 판매가 => 최대 차이
select max(price - saleprice) 
from orders o, book b
where o.bookid=b.bookid
;

select *
from orders o, book b
where o.bookid=b.bookid
and price-saleprice = (select max(price - saleprice) 
                        from orders o, book b
                        where o.bookid=b.bookid)                      
;
select o.orderid, b.price, o.saleprice, price-saleprice as gap
from orders, book b
where o.bookied=b.bookid
and b.price-o.salprice


-- (13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름(질문, 망함)

-- 고객별 총 판매액 출력 조건 -> 총 평균보다 더 높은 값을 가지는 고객만 

 

-- 3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
-- (1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름(질문, 망함)

-- orders, book => publisher in ()
-- 박지성이 구매한 도서의 출판사 이름
select distinct b.publisher
from orders o, book b,customer c
and 0.bookid=b.bookid and o.custidc=c.custid
and c.name='박지성'
;
select c.name
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
and b.publisher in(select distinct b.publisher
    from 

-- (2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름

-- group by custid, name
-- 고객별 구매한 도서의 출판사의 수

-- 최종
select c.custid, c.name, count(distinct b.publisher)
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
group by c.custid, c.name
having count(distinct b.publisher) > 1
;

-- 2개 이상의 출판사의 책을 구매한 회원 id
select *
from customer
where custid in (select o.custid, count(distinct b.publisher)
    from orders o, book b
    where o.bookid=b.bookid
    group by o.custid
    having count(distinct b.publisher) > 1
)
;

select o.custid, count(distinct b.publisher)
    from orders o, book b
    where o.bookid=b.bookid
    group by o.custid
    having count(distinct b.publisher) > 1
;

