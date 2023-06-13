-- 서브 쿼리 수업 2023.04.14 

-- 스칼라 부속질의: select 절에 쓸 수 있는 서브쿼리, 단일값(질의의 결과가 단일행 단일열)
select deptno, (select dname from dept where dept.deptno=emp.deptno) as dname 
from emp
where ename = 'SCOTT'
;

-- 고객번호, 고객 이름, 고객별 총 판매금액
select o.custid, c.name, sum(saleprice)
from orders o, customer c
where o.custid=c.custid
group by o.custid, c.name
;

--  마당서점의 고객별 판매액을 보이시오(결과는 고객이름과 고객별 판매액을 출력)(6p)
select custid,
        (select name from customer c where c.custid=o.custid) as name,
        (select sysdate from dual),
        sum(saleprice)
from orders o
group by o.custid
;


-- 인라인 뷰 : from 절 뒤에 오는 서브쿼리, 가상의 테이블 --  테이블처럼 사용

select empno, ename, job, hiredate from emp where deptno=30
;
select *
from (select empno, ename, job, hiredate from emp where deptno=30)
where ename='SCOTT'
;
--from 뒤에 인라인뷰를 통해서 범위를 제한시켜놓음

-- 고객번호가 2 이하인 고객들의 총 판매액(9p)
-- 별칭 만들 때 "as" 생략 가능
select o.custid, sum(saleprice) total
from (select custid, name from customer where custid <=2) c, orders o
where c.custid=o.custid
group by o.custid
;


select rownum, ename, hiredate
from emp
order by hiredate
;
select ename, hiredate from emp order by hiredate
;


select ename, hiredate
from (select ename, hiredate from emp order by hiredate)
where rownum <= 3
;

-- emp 테이블에서 최고급여를 받는 5명을 뽑아서
-- 사원의 이름 급여 정보를 출력해보자
-- 질문 요망
select rownum, sal from emp order by sal desc;

select rownum, sal, ename
from (select rownum, sal, ename from emp order by sal asc)
where rownum<=5
;

-- mysqul : limit index, count



-- 중첩 질의 : where절 뒤에 오는 비교연산과 연산자를 통해 처리할 때

-- 비교 : 단일값이 나오는 서브 쿼리를 사용해야 한다

-- 평균급여보다 더 많은 급여를 받는 사원

select avg(Sal) from emp; -- 평균급여를 2074 한 걸로 가정

select *
from emp
where sal > (select avg(sal) from emp)
;

-- 평균 주문금액 이하의
-- 주문에 대해서 주문번호와 금액을 보이시오.(14p)
select orderid, saleprice
from orders
where saleprice <= (select avg(saleprice) from orders) -- 평균 주문금액
;
select avg(saleprice) from orders;


-- 각 고객의 평균 주문금액보다 큰 금액의
-- 주문 내역에 대해서
-- 주문번호, 고객번호, 금액을 보이시오.
select o1.orderid, o1.custid, o1.saleprice
from orders o1
where saleprice > (select avg(saleprice) from orders o2 where o2. custid=o1.custid) -- 고객의 평균 구매액
;
-- 1번 고객의 평균 구매액
select avg(saleprice) from orders where custid=1;


-- 주어진 문제가 3000 이상 받는 사원이 소속된 부서(10번, 20번)와
-- 동일한 부서에서 근무하는 사원
-- in
select * from emp where sal>=3000;
select deptno from emp where sal>=3000;

select * from emp where deptno in(10, 20);

select * from emp where deptno in(10, 20);
-- 다중행 단일 열 : 10, 20, 20
select * from emp where deptno in(select distinct deptno from emp where sal>=3000);


17p
address -> 중복 가능 컬럼

-- 대한민국에 거주하는 고객에게
-- 판매한 도서의 총 판매액을 구하시오.
-- 두 코드는 같은 결과
-- 1.
select sum(saleprice) -- sum(saleprice)
from orders
where custid in(select custid  from customer where address like '%대한민국%')
;

-- 2.
select sum(o.saleprice)
from orders o, customer c
where  o.custid = c.custid
and c.address like '%대한민국%'
;



-- 대한민국에 거주하는 고객 번호
select custid
from customer
where address like '%대한민국%'
;



-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한
-- 주문의 주문번호와 금액을 보이시오.
select*
from orders
where saleprice > (select max(saleprice)from orders where custid=3)
;
-- 3번이 고객이 주문한 최고 금액
-- select * from orders where custid=3;
select max(saleprice)from orders where custid=3;


-- all : 서브쿼리의 결과 데이터 모두와 비교해서 참일 때 => 참
select*
from orders
where saleprice > all (select saleprice from orders where custid=3)
;
-- saleprice > 6000 and saleprice > 12000 saleprice > 13000


-- any : 하나라도 만족하면 참(=or)
-- 다음은 부서번호가 30번인 사원들의 급여 중 가장 작은 값(950)보다
-- 많은 급여를 받는 사원의 이름, 급여를 출력하는 예제를 작성 
select sal from emp where deptno=30;
select min(sal) from emp where deptno=30;

select ename, sal
from emp
where sal > any (select sal from emp where deptno=30)
;
-- 부서번호가 30번인 사원들의 급여 중 가장 작은 값(950)보다
-- 많은 급여를 받는 사원의 이름, 급여를 출력하는 예제를 작성 
-- sal > 2850 or sal > 1600 or sal > 1250 or sal > 1500 or sal > 500



-- exists, not exists(21p)
-- 상관관계가 반드시 필요한 서브쿼리가 조건의 결과로 사용 : select의 결과가 존재하는지 여부에 따라 결과를 처리한다. 존재하면true, 존재하지 않으면 false

-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
select sum(saleprice) 
from orders o
where exists
(select * from customer c where c.custid = o.custid and c.address like '%대한민국%')
;
select * from customer c where c.custid = 5 and address like'%대한민국%';


-- 마당서점의 고객별 판매액을 보이시오(결과는 고객이름과 고객별 판매액을 출력).
SELECT ( SELECT name 
FROM Customer cs
WHERE cs.custid=od.custid ) "name", 
SUM(saleprice) "total" 
FROM Orders od 
GROUP BY od.custid;





