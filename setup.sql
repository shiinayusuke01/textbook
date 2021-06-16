DROP TABLE textbooks;
DROP TABLE members;

CREATE TABLE members (
id SERIAL Not Null Primary Key,
last_name Varchar(30) Not Null,
first_name Varchar(30) Not null,
postal Char(7) Not null,
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
 user_id Integer not null REFERENCES members
 );


INSERT INTO members(id, last_name, first_name, postal,address,tel, email,birthday, password)
VALUES(1, 'yusuke', 'shiina', '1921111','tokyo', '080000000', 'shiina@gmail.com', '19970524', 'password');

INSERT INTO textbooks(id, title, author, category, status, price, info, user_id)
VALUES(1, 'AAAtitleAA', 'akutagawa', 1, '�ǂ�', 2300, 'very good', 1);
