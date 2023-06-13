

-- 2023. 04.13
--join

-- CROSS JOIN
-- 스키마를 붙이고 결과 행은 모든 경우의 수 => n * m
-- emp, dept => 14 * 4 => 56

select *
from emp, dept
;

select *
from emp cross join dept
;

select *
from emp join dept
;

--inner join은 오라클이 아니어도 가능
select *
from emp inner join dept
on emp.deptno=dept.deptno
;

--inner는 생략 가능 -- 아래는 위와 같은 결과가 출력됨
select *
from emp join dept
on emp.deptno=dept.deptno
;

select *
from emp natural join dept
;
--naturl join : 같은 컬럼이 있는 경우 자동으로 비교해줌 -- 중복되는 결과를 만들지 않는다



select *
from emp join dept
using (deptno)
;
-- using과 natural join은 같은 역할을 한다 -> 같은 결과 출력
--같은 이름의 컬럼이라는 조건이 필요함

select deptno
from emp natural join dept
;

select *
from emp, dept
where emp.deptno=dept.deptno
;
-- where emp.deptno=dept.deptno -> 각 테이블별로 deptno가 같은 경우만 출력
--위의 경우를 equi join이라고 한다

--테이블 별칭 부여
select e.deptno, empno
from emp e, dept d
where e.deptno = d.deptno
;

select e.deptno, e.empno, dname
from emp e, dept d
where e.deptno=d.deptno

--이름이 SCOTT인 사원의 부서명을 출력해보자
select deptno
from emp
where ename='SCOTT -- 20
;
-- 20

select dname
from dept
where deptno = 20;

--join으로 해결
--equi join and 연결
select ename, dname
from emp e, dept d
where e.deptno = d.deptno
        and e.ename = 'SCOTT'
;

-- 사원별 급여 등급 표현
select * from salgrade;

select e.ename, s.grade, s.losal, e.sal, s.hisal
from emp e, salgrade s
where e.sal between s.losal and hisal
;

-- self join : 자기 자신의 테이블을 조인하는 경우
-- 각 사원의이름과 각 사원의 매니저 이름을 출력하자
select e.ename, m.ename
from emp e, emp m -- 별칭을 따로 주어야 비교 가능
where e.mgr = m.empno
;


-- join : 조건에 만족하지 않는 행도 출력을 하는 join
select e.ename, nvl(m.ename, '없음')
from emp e, emp m
where e.mgr = m.empno(+)
;
-- (+) - outer join으로 null이 나오더라도 출력하겠다 하는 것 - '+'는 오라클에서만 가능


select *
from emp e join emp m
on e.mgr=m.empno
;


select *
from emp e left outer join emp m
on e.mgr=m.empno
;




-- 도서 판매 정보 출력 -- 테이블 3개 join
select * from orders;

select o.orderid, c.name, b.bookname, o.saleprice, o.orderdate
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid
;
-- 테이블 3개 조인















