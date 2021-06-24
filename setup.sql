DROP TABLE textbooks CASCADE;
DROP TABLE members CASCADE;
DROP TABLE categories CASCADE;
DROP TABLE inquiries CASCADE;



CREATE TABLE members (
id SERIAL Not Null Primary Key,
last_name Varchar(30) Not Null,
first_name Varchar(30) Not null,
postal Varchar(10) Not null,
address Varchar(100) Not null,
tel Varchar(20) Not null,
email Varchar(100) Unique Not null,
birthday Varchar(10) Not null,
password Varchar(12) Not Null
 );

 CREATE TABLE textbooks (
 id SERIAL Not Null Primary key,
 title Varchar(100) not null,
 author Varchar(50) not null,
 category Integer not null,
 status Varchar(20) not null,
 price Integer not null,
 info Varchar(2000),
 user_id Integer not null,
 stock Integer not null,
 buyer Integer
 );

 CREATE TABLE categories(
 id Integer,
 categoryname VARCHAR(15)
);

CREATE TABLE inquiries(
id SERIAL Not Null Primary key,
content VARCHAR(2000),
user_id Integer not null
);

INSERT INTO members(id, last_name, first_name, postal,address,tel, email,birthday, password)
VALUES(0, 'yusuke', 'shiina', '1921111','tokyo', '080000000', 'shiina@gmail.com', '19970524', 'password');

INSERT INTO categories(id, categoryname)
VALUES(0, '���w���n');
INSERT INTO categories(id, categoryname)
VALUES(1, '����w���n');
INSERT INTO categories(id, categoryname)
VALUES(2, '�@�w���n');
INSERT INTO categories(id, categoryname)
VALUES(3, '�Љ�w���n');
INSERT INTO categories(id, categoryname)
VALUES(4, '�o�ϊw���n');
INSERT INTO categories(id, categoryname)
VALUES(5, '���w���n');
INSERT INTO categories(id, categoryname)
VALUES(6, '��w���n');
INSERT INTO categories(id, categoryname)
VALUES(7, '���w���n');
INSERT INTO categories(id, categoryname)
VALUES(8, '��w���n');
INSERT INTO categories(id, categoryname)
VALUES(9, '�H�w���n');
INSERT INTO categories(id, categoryname)
VALUES(10, '�_�w���n');
