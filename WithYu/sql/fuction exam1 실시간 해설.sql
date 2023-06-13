

-- function exam 함수 문제1

-- 16. SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오.
-- '81/11/12' -> '81/11'. 81 11
-- 12345678 -- 인덱스
select hiredate, substr(hiredate, 1, 5), substr(hiredate,1,2), substr(hiredate, 4,2)
from emp
where substr(hiredate,1,2)=81;
-- 81년도 입사자만 출력

-- 17. SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력하시오.
​select *
from emp
where substr(hiredate,4,2)='04';

-- 18. MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오.
select*
from emp
where mod(empno, 2)=0 
;​

--  19. 입사일을
--  년도는 2자리(YY), 월은 숫자(MM)로 표시하고
--  요일은 약어 (DY)로 지정하여 출력하시오.
select ename,
        to_char(hiredate, 'yy') as "입사년도",
        to_char(hiredate, 'mm') as "입사 월",
        to_char(hiredate, 'dy') as "입사 요일",
        to_char(hiredate, 'yy.mm.dy') as "입사 년/월/월/요일"
from emp
;
​
-- 20. 올해 몇 칠이 지났는지 출력하시오.
-- 현재 날짜에서 올해 1월 1일을 뺀 결과를 출력하고
-- TO_DATE 함수를 사용하여 데이터 형을 일치 시키시오.
select sysdate,
       to_date('2023_01_01', 'yyyy-mm-dd'),
       sysdate - to_date('2023-01-01', 'yyyy-mm-dd'),
       trunc(sysdate - to_date('2023-01-01', 'yyyy-mm-dd'))
from dual;
-- -- 'yyyy'mm-dd' 생략 가능 by 자동 형 변환

-- 21. 사원들의 상관 사번을 출력하되 상관이 없는 사원에 대해서는 NULL 값 대신 0으로 출력하시오.
select mgr, nvl(mgr, 0)
from emp
;

-- 22. DECODE 함수로 직급에 따라 급여를 인상하도록 하시오.
-- 직급이 ‘ANALIST”인 사원은 200,
-- ‘SALESMAN’인 사원은 180,
-- ‘MANAGER’인 사원은 150,
-- ‘CLERK”인 사원은 100을 인상하시오.
select ename, job, sal,
        nvl(decode(job, 'ANALYST', sal+200,
                    'SALESMAN', sal+180,
                    'MANAGER', sal+150,
                    'CLERK', sal+100
                    ),sal) as up_sal
                    -- 별칭에 한글이나 띄어쓰기가 들어가면 큰 따옴표 필수 -- 알파벳은 자동 변환
from emp
;
-- null값 제거를 위해 nvl 함수 사용

-- 23. 모든 사원의 급여 최고액, 최저액, 총액 및 평균 급여를 출력하시오.
-- 평균에 대해서는 정수로 반올림하시오.
​SELECT MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL))
FROM EMP;

-- 24. 각 담당 업무 유형별로 급여 최고액, 최저액, 총액 및 평균 액을 출력하시오.
-- 평균에 대해서는 정수로 반올림 하시오.
select job, max(sal), min(sal), sum(Sal), round(avg(sal))
from emp
group by job;

-- 25. COUNT(*) 함수를 이용하여 담당업무가 동일한 사원 수를 출력하시오.
select deptno, job, count(*)
from emp
group by deptno, job
order by deptno, job desc
;

-- 26. 관리자 수를 출력하시오. mgr => empno
select ename, empno, mgr
from emp
order by mgr;
----------------------------------------
select count(distinct mgr) 
from emp;
-- 중복제외를 위해 distinct 사용

-- 27. 급여 최고액, 급여 최저액의 차액을 출력하시오.
select max(sal), min(sal), max(sal)-min(sal)
from emp;

-- 28. 직급별 사원의 최저 급여를 출력하시오.
-- 관리자를 알 수 없는 사원과 최저 급여가 2000 미만인 그룹은 제외시키고 -> 관리자가 null인 사원
-- 결과를 급여에 대한 내림차순으로 정렬하여 출력하시오.
select job, min(sal) 
from emp
where mgr is not null -- mgr이 null인 값 제외
group by job
having min(sal) > 2000 -- 최저 급여가 2000 미만 제외
order by min(sal) desc -- 급여 내림차순 정렬
;

-- 29. 각 부서에 대해 부서번호, 사원 수, 부서 내의 모든 사원의 평균 급여를 출력하시오.
-- 평균 급여는 소수점 둘째 자리로 반올림 하시오.
​select deptno, count(*), round(avg(sal),2) 
from emp
group by deptno
order by deptno
;

-- 30. 각 부서에 대해 부서번호 이름, 지역 명, 사원 수,
-- 부서내의 모든 사원의 평균 급여를 출력하시오.
-- 평균 급여는 정수로 반올림 하시오.
-- DECODE 사용.
select * from dept;
​select deptno,
        decode(deptno, 10, 'ACCOUONTING',
                        20, 'RESEARCH',
                        30, 'SALES',
                        40, 'OPERATIONS'
                        )as dname,
                        decode(deptno, 10, 'NEW YORK',
                                        20, 'DALLS',
                                        30, 'CHICAGO',
                                        40, 'BOSTON'
                        ) loc,
count(*), round(avg(sal))
from emp
group by deptno
;