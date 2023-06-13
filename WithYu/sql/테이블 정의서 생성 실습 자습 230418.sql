-- 테이블 정의서 생성 실습

create table phoneInfo_basic(
idx number(6) constraint pi_basic_idx_pk primary key, -- primary key에 이미 not null이 포함되어 있다
fr_name varchar2(20) not null,
fr_phonenumber varchar2(20) not null,
fr_email varchar2(20),
fr_address varchar2(20),
fr_regdate date default sysdate -- 마지막엔 콤마 생략
)
;
drop table phoneInfo_basic;
desc phoneInfo_basic;
select * from phoneInfo_basic;

-- create(insert)
insert into phoneInfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address, fr_regdate)
values(1, 'park', '010-1111-1111', 'park@gmail.com', 'seoul', default); -- 컬럼 순서에 맞춰서 값을 입력해야 한다

insert into phoneInfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address, fr_regdate)
values(2, 'kim', '010-2222-2222', 'kim@gmail.com', 'busan', default);


-- read(select)

select * from phoneinfo_basic;
select * from phoneinfo_basic where fr_name='kim';
select idx from phoneinfo_basic where fr_address='seoul';


-- update
-- update 테이블이름 set 컬럼1=새로운값, 컬럼2=새로운값, ... where 행을 선택하는 조건
-- 주소가 서울인 행의 idx를 3으로, 이름을 'son'으로 수정하자
update phoneinfo_basic
set idx=3, fr_name='son'
where fr_address='seoul';

-- delete
-- delete from 테이블이름 where 행을 선택하는 조건
-- 주소가 서울인 행을 삭제하자
delete from phoneinfo_basic where fr_address='seoul';



-- -----------------------------------------------------------------------------
create table phoneInfo_univ(
idx number(6) primary key, 
fr_u_major varchar2(20) default 'N' not null, -- N은 문자이므로 따옴표 필수
fr_u_year number(1) default 1 check (fr_u_year between 1 and 4) not null, -- between A and B => A와 B까지 포함이므로 1,4로 입력 -- 컬럼 레벨에서 check 제약 조건 설정
fr_ref number(6),
-- constraint pi_basic_pk primary key (idx), -- 질문. 아니면 여기서 제약을 걸어뒀기 때문에 위에선 'idx unmbers(6)'만 입력하고 끝낼 수 있는 건가?
constraint pi_univ_ref_fk foreign key (fr_ref) references phoneInfo_basic (idx) -- 질문. foreign key는 primary key처럼 '띄어쓰기 primary key' 방식으로 제약에 이름 부여 없이 만들 수 없는가? 
)
;
drop table phoneInfo_univ;
desc phoneInfo_univ


-- create(insert)
-- 대학친구 정보 입력
insert into phoneinfo_basic
values(3, 'trump', '010-3333-3333', 'sam@gmail.com', 'america', default);
--univ 정보 입력
insert into phoneinfo_univ(idx, fr_u_major, fr_u_year, fr_ref) -- 전체에 값을 주려고 할 경우 소괄호 부분을 생략해도 된다. 다만 values 절에 값을 입력할 경우에는 컬럼명과 순서를 일치시켜야 한다
values(4,'computer engineering', default, 2); -- default 1이 설정되어있으므로 default를 값으로 줄 경우 1이 출력된다 
insert into phoneinfo_univ
values(5, 'english', default, 3);

-- read(select) 
select * from phoneinfo_univ; 

-- update
update phoneinfo_univ
set fr_u_major='english literature', fr_u_year=3
where fr_u_major='computer engineering';

-- delete
delete from phoneinfo_univ where idx=4;

-- -----------------------------------------------------------------------------

create table phoneInfo_com(
idx number(6) constraint pi_com_idx_pk primary key, -- 질문. univ에서와는 다르게 다시 constraint pc_com_idx_pk primary key를 입력하는 이유가 무엇? -- idx를 계속 늘리는 이유는?
fr_c_company varchar2(20) default 'N' not null,
fr_ref number(6) constraint pi_com_ref_fk references phoneinfo_basic (idx) not null
)-- constraint pi_com_ref_FK REFERENCES phoneinfo_basic (idx)
;
drop table phoneInfo_com;
desc phoneInfo_com

--create(insert)

insert into phoneinfo_basic -- 질문. 가장 먼저 오는 컬럼인 idx가 기본키가 걸려있어서 기본키가 있는 컬럼인 phoneinfo_basic가 가장 먼저 오는 것인지? -- 그냥 똑같이 idx를 써도 되는지?
values (9, 'donald', '010-5555-5555', 'donald@gmail.com', 'usa', default)
;
insert into phoneinfo_com
values(9, 'himedia', 1);  -- 질문. 08.38페이지에 있는 '부모 키로 설정된 컬럼에 존재하는 값만 추가하고 존재하지 않는 값이라면 추가하지 않습니다.'라는 말이,
                                     --부모키가 있는 테이블의 컬럼에 해당 값이 있어야만 자식키인 phoneinfo_com에서 정상적으로 출력된다는 뜻인지?
                                     --따라서 basic 테이블의 idx에 9가 있어야만 com 테이블에서 를 출력할 수 있는 것인지?
                                     -- 값이 동일하지 않을 경우 부모 키가 없다고 나오는 게 맞는지?

select * from phoneinfo_basic;


-- read(select)
select * from phoneInfo_com;

-- update
update phoneinfo_com
set fr_ref=100
where fr_c_company='himedia'; -- 부모키가 없습니다에서 또 막힘


















