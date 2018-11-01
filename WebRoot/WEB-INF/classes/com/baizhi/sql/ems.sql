create table admin(
	id int primary key,
	adminname varchar2(20),
	password varchar2(10) 
);
create sequence admin_seq;
select * from admin;

create table t_employee(
	id integer primary key,
	name varchar2(20),
	salary number(7,2),
	age integer,
	birthday date,
	sex char(2),
	score number(4,1)
);
create sequence emp_seq
select * from t_employee;