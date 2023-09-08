DELETE FROM "MEMBER" m 

SELECT * FROM "MEMBER" m 

COMMIT 

DROP TABLE MYDEPT 

DROP TABLE "MEMBER"  

SELECT CONSTRAINT_name,CONSTRAINT_TYPE,Table_NAMe FROM USER_CONSTRAINTS 

ALTER TABLE "MEMBER" 
DROP CONSTRAINT deptcode_fk;

DROP TABLE MYDEPT 

ALTER TABLE "MEMBER" 
DROP (deptcode)

SELECT * FROM "MEMBER" m 
--WHERE ID = 'hon' PASS = '1234' 

create table memer(
    id varchar2(20) primary key,
    pass varchar2(20) ,
    name varchar2(20) not null ,
    addr varchar2(20) ,
    regdate date,
    point number,
    info varchar2(50) )
    
DELETE FROM "MEMBER" m WHERE id = 'hon'

