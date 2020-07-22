
DROP TABLE IF EXISTS DEPARTMENT;

CREATE TABLE DEPARTMENT
(
  id NUMBER(4,0) NOT NULL,
  deptname varchar(50),
  CONSTRAINT dept_primery_key PRIMARY KEY (id)
);

DROP TABLE IF EXISTS EMPLOYEE;

CREATE TABLE EMPLOYEE
(
  id NUMBER(5,0) NOT NULL,
  firstName varchar(30) NOT NULL,
  lastName varchar(30),
  emailId varchar(30),
  dept_id NUMBER(4,0) NOT NULL,
  CONSTRAINT employee_primery_key PRIMARY KEY (id),
  CONSTRAINT Dept_Forign FOREIGN KEY (id) REFERENCES DEPARTMENT (id)
);