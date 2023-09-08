DELETE FROM "MEMBER" m 

SELECT * FROM "MEMBER" m 

COMMIT 

DROP TABLE MYDEPT 

DROP TABLE "MEMBER"  

commit

SELECT CONSTRAINT_name,CONSTRAINT_TYPE,Table_NAMe FROM USER_CONSTRAINTS 

ALTER TABLE "MEMBER" 
DROP CONSTRAINT deptcode_fk;

DROP TABLE MYDEPT 

ALTER TABLE "MEMBER" 
DROP (deptcode)

SELECT * FROM "MEMBER" m 

create table member(
    id varchar2(20) primary key,
    pass varchar2(20) ,
    name varchar2(20) not null ,
    addr varchar2(20) ,
    regdate date,
    point number,
    info varchar2(50) )

UPDATE MEMBER
SET pass = '2323'

SELECT * FROM MEMBER

UPDATE MEMBER SET id = 'jang' WHERE id ='test'

commit