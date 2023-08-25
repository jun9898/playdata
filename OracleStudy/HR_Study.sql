SELECT d.DEPARTMENT_ID 부서번호
, d.DEPARTMENT_NAME  부서명
, COUNT(e.EMPLOYEE_ID) 인원수
, MAX(e.SALARY) 최고급여
, MIN(e.SALARY) 최저급여
, FLOOR(AVG(e.SALARY)) 평균급여
, (SUM(e.SALARY)) 급여총액
FROM EMPLOYEES e , DEPARTMENTS d , JOBS j 
WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID 
AND e.JOB_ID = j.JOB_ID 
GROUP BY d.DEPARTMENT_NAME , d.DEPARTMENT_ID 
HAVING COUNT(e.EMPLOYEE_ID) >= 3 
ORDER BY COUNT(e.EMPLOYEE_ID) DESC 

--1. FIRST_NAME의 두 번째 문자열에 "t"(소문자)가 포함된 사원의 
--사원번호, 이름(FIRST_NAME),관리자 이름(FIRST_NAME)을 출력하고 
--관리자가 없는 경우에는 "관리자 없음"이라고 출력되도록 작성하세요.
--[출처] 조인연습 - hr계정(outer조인과 self조인)|작성자 heaves1
SELECT e.EMPLOYEE_ID , e.FIRST_NAME , NVL(m.FIRST_NAME, '관리자 없음') 관리자명
FROM EMPLOYEES e , EMPLOYEES m
WHERE e.MANAGER_ID = m.EMPLOYEE_ID (+) 
AND e.FIRST_NAME LIKE '_t%'

--2. 각 부서별로 평균급여(salary)을 급여가 높은 순서대로 출력하세요.
--단, 급여는 소수이하 자리수는 반올림하여 나타내며 급여가 5000이상인 데이터만 조회합니다.
--[출처] 조인연습 - hr계정(outer조인과 self조인)|작성자 heaves1
SELECT d.DEPARTMENT_NAME , ROUND( AVG( e.SALARY  ) ) 
FROM DEPARTMENTS d , EMPLOYEES e 
WHERE d.DEPARTMENT_ID = e.DEPARTMENT_ID 
GROUP BY d.DEPARTMENT_NAME 
HAVING AVG(e.SALARY) > 5000 
ORDER BY AVG(e.SALARY) DESC  

--3. 직원중 현재시간 기준으로 근무 개월수가 20년(12*20개월) 보다 많은(초과) 사람의 
--first_name, salary, hire_date, department_name 을 출력하시요.
--[출처] 조인연습 - hr계정(outer조인과 self조인)|작성자 heaves1
SELECT e.FIRST_NAME , e.SALARY , e.HIRE_DATE , d.DEPARTMENT_NAME 
FROM EMPLOYEES e , DEPARTMENTS d 
WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID 
AND ADD_MONTHS(e.HIRE_DATE, (20*12)) < SYSDATE 

--4. 각 직책별로 직원수를 출력하세요. 
--단, 해당 직원이 없는 job_title에 대해서도 모두 출력합니다.
--(해당 job_title이 없다고 하더라도 추후에 발생시 적용될 수 있도록 작성하세요.)
--[출처] 조인연습 - hr계정(outer조인과 self조인)|작성자 heaves1
SELECT j.JOB_TITLE , COUNT(e.EMPLOYEE_ID) 
FROM JOBS j , EMPLOYEES e 
WHERE e.JOB_ID (+) = j.JOB_ID 
GROUP BY j.JOB_TITLE 

--1. Employees 테이블에서 입사일자(hire_date)에 따라 2005년 입사한 직원들 가운데 
--first_name이 'Lisa'인 직원보다 빨리 입사한 직원의 
--사번(employee_id), 이름(first_name), 성(last_name), 입사일자(hire_date)를 조회하는
--SQL 문장을 작성하시오. 
--단, <실행 결과>처럼 first_name과 하나의 공백(space bar), last_name 은
--name 이라는 컬럼명으로 출력되도록 합니다. 
--[출처] 단일행서브쿼리(hr계정)|작성자 heaves1
SELECT 
e.EMPLOYEE_ID 
, e.FIRST_NAME || ' ' || e.LAST_NAME AS NAME
, e.HIRE_DATE 
FROM EMPLOYEES e 
WHERE TO_CHAR(e.HIRE_DATE, 'yyyy') = 2005
AND e.HIRE_DATE < (SELECT HIRE_DATE
					 FROM EMPLOYEES
					 WHERE FIRST_NAME like 'Lisa')
					 
--2.Sales’부서에 속한 직원의 이름(first_name), 급여(salary), 부서이름(department_name)을
--조회하시오. 단, 급여는 100번 부서의 평균보다 적게 받는 직원 정보만 출력되어야 합니다. 
--[출처] 단일행서브쿼리(hr계정)|작성자 heaves1
SELECT e.FIRST_NAME , e.SALARY , d.DEPARTMENT_NAME  
FROM EMPLOYEES e , DEPARTMENTS d 
WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID 
AND d.DEPARTMENT_NAME = 'Sales'
AND e.SALARY < (SELECT AVG( SALARY )
				FROM EMPLOYEES
				WHERE DEPARTMENT_ID = 100)
				
--3. De Haan 사원의 관리자 사원번호, 이름(last_name), 
--입사일 및 급여를 표시하는 SQL문을 작성하십시오.alias를 포함하여 실행결과와 동일하게 출력되어야 합니다.
--[출처] 단일행서브쿼리(hr계정)|작성자 heaves1
SELECT 
e.EMPLOYEE_ID  , e.LAST_NAME , e.HIRE_DATE , e.SALARY 
FROM EMPLOYEES e 
WHERE e.EMPLOYEE_ID IN (SELECT e2.MANAGER_ID 
						FROM EMPLOYEES e2 
						WHERE e2.LAST_NAME = 'De Haan')

