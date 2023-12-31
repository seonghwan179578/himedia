-- join exam 조인문제 해설

desc emp;
desc dept;

-- 32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
-- SCOTT -> emp, 부서이름 -> dept ==> join
select e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno=d.deptno
    and e.ename='SCOTT'
;

-- 33. INNER JOIN과 ON 연산자를 사용하여
-- 사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.
-- inner는 생략 가능(inner 없이 join 으로 가능)
-- 아래 세 가지 코드는 모두 같은 결과가 출력된다
select e.ename, d.dname, d.loc 
from emp e inner join dept d
on e.deptno=d.deptno
;

select e.ename, d.dname, d.loc 
from emp e inner join dept d
using (deptno)
;

select ename, dname, loc 
from emp natural join dept
;

-- 36. 조인과
-- WildCARD를 사용하여 이름에 ‘A’가 포함된
-- 모든 사원의
-- 이름과 부서명을 출력하시오.
select e.ename, d.dname
from emp e, dept d
where e.deptno=d.deptno
    and e.ename like '%A%'
;

-- 37. JOIN을 이용하여
-- NEW YORK에 근무하는 -> where 조건
-- 모든 사원의 이름, 업무, -> emp
-- 부서번호 및 부서명을 출력하시오. -> dept
select e.ename, d.job, d.deptno, d.dname
from emp e join dept d
where e.deptno = d.deptno
    and d.loc='NEW YORK'
;

-- 38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.
-- 개인연습 필요(m.ename)
select e.ename, e.deptno, m.ename
from emp e, emp m
where e.mgr=m.empno 
;

-- 39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로
-- 내림차순 정렬하여 출력하시오.
select e.ename, e.deptno, nvl(m.ename, '관리자 없음')
from emp e, emp m
where e.mgr=m.empno(+) 
;

-- 왼쪽에 있는 emp 테이블을 다 출력하겠다
-- outer join 사용시에는 left, right 방향 지정 필수
select e.ename, e.empno, m.ename
from emp e left outer join emp m
on e.mgr=m.empno
;


​-- 40. SELF JOIN을 사용하여
--     지정한 사원의 이름, 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오.( SCOTT )
select e2.ename, e2.deptno
from emp e1, emp e2
where e1.deptno=e2.deptno
and e1.ename='SCOTT' and e2.ename!='SCOTT'
-- order by e1.ename
;
-- and e2.ename!='SCOTT] -> SCOTT을 출력에서 제외하기 위함
-- 해당 부분을 지울 경우, SCOTT 행이 같이 출력됨

-- 41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
select *
from emp e, emp w
where w.ename='WARD'
and e.hiredate> w.hiredate
;

-- 번외 문제) self join을 사용하여 WARD 사원보다 급여가 적은 사원의 이름과 입사일
select *
from emp e, emp w
where w.ename='WARD'
and e.sal < w.sal
;



-- 42. SELF JOIN 을 사용하여
-- 관리자보다 먼저 입사한 모든
-- 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.
select e.ename, e.hiredate, m.ename, m.hiredate
from emp e, emp m
where e.mgr=m.empno
and e.hiredate < m.hiredate
;



























































​