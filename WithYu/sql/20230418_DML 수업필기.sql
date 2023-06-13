-- 2023.04.18
-- DML : 입력, 수정, 삭제
-- create(insert), read(select), update(update), delete(delete) => CRUD 

-- INSERT : 데이터를 행 단위로 입력

--테스트 테이블 생성

desc dept01;
select * from dept01;
-- insert into 테이블이름 (컬럼1, 컬럼2,...) values (데이터1, 데이터2, ...)
insert into dept01 (deptno, dname,   loc)
            values (10,     'test', 'test-loc');
--추가할 때 위치만 맞으면 상관 없다
insert into dept01 (loc, dname, deptno) values ('서울', '개발팀', 20);

--오류
insert into dept01 (deptno, dname, loc) values (30, 'QA', '서울', 'memo'); -- 값의 수가 너무 많습니다 오류 발생 -- 컬럼은 3갠데 값이 4개라서 생긴 문제 

--오류
insert into dept01 (deptno, dname, loc) values (30, 'QA'); -- 값의 수가 충분하지 않습니다 오류 발생 -- 컬럼은 3갠데 값이 2개랏 생긴 문제

insert into dept01 (deptno, dname) values (30, 'QA');

--오류
insert into dept01 (deptno, dname) values (null, null); -- 두 컬럼은 not null 조건이 있기 때문에 null을 삽입할 수 없다  -- desc dept01 참조

--오류
insert into dept01 (deptno, loc) values (30, '제주'); -- not null 제약이 있는 컬럼은 반드시 데이터를 입력해주어야 한다

--오류
insert into dept01 (deptno, dnanme) values (30, 'QA'); -- 부적합한 식별자(컬럼 이름)



-- 모든 컬럼에 데이터를 입력하는 경우 -> 컬럼명을 생략하고 사용할 수 있다

insert into dept01 values (40, '기획팀', '대전');

-- null 값의 입력
-- 1. 명시적 입력
insert into dept01 values (50, 'test', null);
insert into dept01 values (70, 'Test111', ''); -- -> null 입력
-- 암묵적 입력
insert into dept01 (deptno, dname) values (60, 'test123');  -- loc가 생략 -> 기본값으로 null이 들어감 -- null이 못들어가게 하려면 default 사용



--서브쿼리를 이용한 데이터 입력
create table dept02
as
select * from dept where 1=0
;
desc dept02;

insert into dept02
select * from dept;
select * from dept02;


-- update : 행 단위 컬럼들의 데이터를 변경 -> 해당 컬럼의 값을 입력/수정/삭제
-- update 테이블이름 set 컬럼1=새로운값, 컬럼2=새로운값, ... where 행을 선택하는 조건

select * from dept01;
-- 10번 부서의 이름을 '디자인팀'으로 변경하고, 위치 정보를 '판교'로 수정하자.
update dept01
set dname='디자인', loc='판교'
where deptno=10;

drop table dept02;
create table dept02 as select * from dept;

drop table emp01;
create table emp01 as select * from emp;
select * from emp01;
-- 모든 사원의 부서번호를 30번으로 수정하자 -- '모든' 이므로 where절이 필요없다

update emp01
set deptno=30
;

--   이번엔 모든 사원의 급여를 10% 인상시키는 UPDATE 문을 보겠다
update emp01
set sal = sal*1.1
;

--  모든 사원의 입사일을 오늘로 수정하려면 다음과 같이 해보자
update emp01
set hiredate = sysdate
;
-- 원래 날짜로 되돌리는 법 질문

-- 특정행을 수정할 경우 where 절의 조건으로 행을 선택

-- 부서번호가 10번인
-- 사원의 부서번호를 30번으로 수정합시다.
update emp01
set deptno=30
where deptno=10
;
select * from emp01;

-- 급여가 3000 이상인 사원만
-- 급여를 10% 인상하자
update emp01
set sal= sal*1.1
where sal >=3000
;

-- 1987년에 입사한 사원의 입사일이 오늘로 수정합시다. 사원의 입사일을 오늘로 수정한 후에 테이블 내용을 살펴보자
update emp01
set hiredate = sysdate
where substr(hiredate, 1, 2)='87'
;


-- 테이블에서 2개 이상의 칼럼 값 변경(23p)
-- SCOTT 사원의 부서번호는 40번으로,
-- 직급은 MANAGER로 한꺼번에 수정하도록 합시다.
update emp01
set deptno=40, job='MANAGER'
where ename='SCOTT'
;
SELECT * FROM EMP01;

-- SCOTT 사원의 입사일자는 오늘로,
-- 급여를 50 으로 커미션을 4000 으로 수정합시다.
update emp01
set hiredate=sysdate, sal=50, comm=4000
where ename='SCOTT'
;


-- 서브 쿼리를 이용한 데이터 수정하기 (25p)
-- 20번 부서의 지역명을 40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해보자
select * from dept02;
select loc from dept02 where deptno=40;
update dept02
set loc = (select loc from dept02 where deptno=40)
where deptno=20
;


26p
-- 서브 쿼리를 이용해서 부서번호가 20인 부서의 부서명과 지역명을
-- 부서 번호가 30번인 부서와 동일하게 변경하도록 해보자
update dept02
set (dname, loc)=(select dname, loc from dept02 where deptno=30) -- 결과는 항상 단일행이어야 한다
where deptno=20
;
select * from dept02;


-- delete : 테이블의 행 단위 삭제
-- delete from 테이블이름 where 행을 선택하는 조건
select * from dept02;
-- dept01 테이블의 모든 행을 삭제하자(모든 부서 정보를 삭제) 
delete from dept01;

-- 부서 테이블 dept02에서 30번 부서만 삭제하자
delete from dept02 where deptno=30;


-- 서브 쿼리를 이용한 데이터 삭제하기 
select * from emp01;
select * from dept02;
-- 사원 테이블에서 부서명이 SALES인 사원을 모두 삭제해보자
select deptno from dept02 where dname='SALES';
delete from emp01 where deptno=(select deptno from dept02 where dname='SALES');





commit;

delete from emp;

select * from emp;

select * from emp01;
delete from emp01;

--마지막 커밋 시점으로 돌아감
rollback;






-- sequence : 연속된 숫자를 생성해주는 객체
-- create sequence 이름 [필요한 옵션]

create sequence seq_dept_deptno
start with 10
increment by 10
;

-- 자동 생성된 값 : 시퀀스객체이름.nextval
select seq_dept_deptno.nextval
from dual;
select * from dept01;
insert into dept01 values(seq_dept_deptno.nextval, 'test이름', 'test위치');

select seq_dept_deptno.currval -- 현재의 시퀀스값을 가져옴
from dual;


