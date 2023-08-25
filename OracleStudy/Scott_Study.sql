SELECT * FROM SALGRADE s 

SELECT e.EMPNO , e.ENAME , e.SAL , s.GRADE 
FROM EMP e , SALGRADE s 
WHERE e.SAL >= s.LOSAL AND e.SAL <= s.HISAL 

INSERT INTO emp(empno, ename, HIREDATE) VALUES (7777, 'jin', sysdate);

INSERT INTO emp(empno, ename, HIREDATE) VALUES (8888, 'jbj', sysdate);

COMMIT;

SELECT * FROM EMP e 

SELECT d.DNAME , e.ENAME , e.HIREDATE 
FROM EMP e , DEPT d 
WHERE e.DEPTNO(+) = d.DEPTNO  

SELECT d.DNAME , e.ENAME , e.HIREDATE 
FROM EMP e , DEPT d 
WHERE e.DEPTNO = d.DEPTNO (+)

SELECT FROM 

SELECT NVL(d.DNAME , '신입사원') 부서  , COUNT(e.EMPNO)  FROM EMP e , DEPT d
WHERE d.DEPTNO (+) = e.DEPTNO
GROUP BY d.DNAME 

SELECT e.ENAME , e.SAL , e.HIREDATE , m.ENAME 관리자명 , m.EMPNO , m.MGR 
FROM EMP e ,EMP m
WHERE e.MGR = m.EMPNO 

SELECT d.DNAME , e.ENAME 
FROM EMP e 
	INNER JOIN DEPT d 
	ON e.DEPTNO =d.DEPTNO

SELECT d.DNAME , e.ENAME 
FROM DEPT d 
	INNER JOIN EMP e  
	ON e.DEPTNO = d.DEPTNO
	
SELECT d.DNAME , e.ENAME , l.CITY 
FROM EMP e 
	INNER JOIN DEPT d 
	ON e.DEPTNO = d.DEPTNO 
	INNER JOIN LOCATIONS l 
	ON d.LOC_CODE  = l.LOC_CODE 

select e.empno,e.ename,e.sal,d.dname,d.loc_code
from emp e
	INNER JOIN DEPT d 
	ON e.DEPTNO = d.DEPTNO 

select e.ename,d.dname,e.sal,l.city
from emp e
	INNER JOIN DEPT d 
	ON d.DEPTNO = e.DEPTNO 
	INNER JOIN LOCATIONS l 
	ON l.LOC_CODE = d.LOC_CODE 
	
select e.ename,e.sal,e.job,e.hiredate,e.comm
from emp e
	INNER JOIN DEPT d 
	ON d.DEPTNO = e.DEPTNO 
	INNER JOIN LOCATIONS l 
	ON l.LOC_CODE = d.LOC_CODE 
where l.city = 'DALLAS' and e.sal>=1500;

select e.empno,e.ename,e.job,e.deptno,d.deptno,d.dname
from emp e
	INNER JOIN DEPT d 
	ON d.DEPTNO = e.DEPTNO 
	
select d.deptno,d.dname,l.city
from dept d
	INNER JOIN LOCATIONS l 
	ON d.LOC_CODE = l.LOC_CODE 
	
SELECT d.DNAME , e.ENAME 
FROM EMP e 	
	LEFT OUTER JOIN DEPT d 
	ON e.DEPTNO = d.DEPTNO 
	
SELECT d.DNAME , e.ENAME 
FROM DEPT d  	
	LEFT OUTER JOIN EMP e  
	ON e.DEPTNO = d.DEPTNO 

SELECT d.DNAME , e.ENAME 
FROM EMP e 	
	RIGHT OUTER JOIN DEPT d 
	ON e.DEPTNO = d.DEPTNO 
	
SELECT NVL(d.DNAME , '신입사원') 부서  , COUNT(e.EMPNO)  FROM EMP e , DEPT d
WHERE d.DEPTNO (+) = e.DEPTNO
GROUP BY d.DNAME 

SELECT NVL(d.DNAME , '신입사원') 부서  , COUNT(e.EMPNO)
FROM EMP e
	LEFT OUTER JOIN DEPT d 
	ON d.DEPTNO = e.DEPTNO 
GROUP BY d.DNAME 
ORDER BY COUNT(e.EMPNO) 

SELECT *
FROM EMP e 
WHERE SAL > (SELECT AVG(SAL)
			 FROM EMP) 

SELECT *
FROM EMP e 
WHERE DEPTNO = (SELECT DEPTNO
				FROM EMP
				WHERE ename = 'SCOTT')

--1. 20번 부서의 최고 급여보다 급여가 많은 사원들의 목록
SELECT *
FROM EMP e , DEPT d 
WHERE e.DEPTNO = d.DEPTNO 
AND e.SAL > (SELECT  MAX(SAL) 
			   FROM EMP 
			   WHERE DEPTNO = 20)
				
--2. 7566번 사원보다 급여를 많이 받는 사원의 목록
SELECT *
FROM EMP e
WHERE e.SAL > (SELECT SAL
			   FROM EMP e 
			   WHERE e.EMPNO = 7566)
			   
--3. sal이 2900 이상인 사원과 같은 부서에 근무하는 사원의 목록
SELECT *
FROM EMP e 
WHERE DEPTNO IN (SELECT DEPTNO
			  	 FROM EMP
			  	 WHERE sal >= 2900)
			  	 
-- 각 부서에서 최소 급여를 받는 사용자의 사원번호, 부서번호, 급여를 출력

UPDATE EMP 
SET SAL = 1300
WHERE EMPNO = 7876;

commit

SELECT *
FROM EMP e 
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO , MIN(SAL)  
			  			FROM EMP
			  			GROUP BY DEPTNO)  
			  			




