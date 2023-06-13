desc emp;
desc dept;

--16. SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오.
SELECT SUBSTR(HIREDATE, 1, 4)
FROM EMP;

--17. SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력하시오. 망함 질문

​SELECT ENAME
FROM EMP
WHERE SUBSTR(HIREDATE, 6,2)=4;

--18. MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오. 망함
SELECT *
FROM EMP
WHERE EMPTOMOD EMPTO,2;







20. 올해 몇 칠이 지났는지 출력하시오. 현재날짜에서 올해 1월 1일을 뺀 결과를 출력하고 TO_DATE 함수를 사용하여 데이터 형을 일치 시키시오.
SELECT 

