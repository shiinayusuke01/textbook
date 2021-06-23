DROP TABLE textbooks CASCADE;
DROP TABLE members CASCADE;

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
 category VARCHAR(15)
 )


INSERT INTO members(id, last_name, first_name, postal,address,tel, email,birthday, password)
VALUES(0, 'yusuke', 'shiina', '1921111','tokyo', '080000000', 'shiina@gmail.com', '19970524', 'password');

INSERT INTO textbooks(id, category)
VALUES(0, "文学部系");
INSERT INTO textbooks(id, category)
VALUES(1, "教育学部系");
INSERT INTO textbooks(id, category)
VALUES(2, "法学部系");
INSERT INTO textbooks(id, category)
VALUES(3, "社会学部系");
INSERT INTO textbooks(id, category)
VALUES(4, "経済学部系");
INSERT INTO textbooks(id, category)
VALUES(5, "理学部系");
INSERT INTO textbooks(id, category)
VALUES(6, "医学部系");
INSERT INTO textbooks(id, category)
VALUES(7, "歯学部系");
INSERT INTO textbooks(id, category)
VALUES(8, "薬学部系");
INSERT INTO textbooks(id, category)
VALUES(9, "工学部系");
INSERT INTO textbooks(id, category)
VALUES(10, "農学部系");
