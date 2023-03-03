
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' IDENTIFIED BY '%greg333!%' WITH GRANT OPTION;


mysql -u root -pgreg333!
CREATE DATABASE IF NOT EXISTS datastore;


** Logout **


mysql -u root -pgreg333! datastore

SELECT DATABASE() FROM DUAL;
+------------+
| DATABASE() |
+------------+
| datastore  |
+------------+
1 row in set (0.01 sec)

show tables;
Empty set (0.00 sec)



^^^
SCHEMA
First Name:   required, max length, 100
Last Name:    required, max length, 200
DOB:          required
Title:        required, values restricted to: DEVELOPER, PM, CEO, CTO



^^^
DDL
CREATE TABLE IF NOT EXISTS Employee (
    task_id INT AUTO_INCREMENT PRIMARY KEY,
    FName VARCHAR(100) NOT NULL,
    LName VARCHAR(200) NOT NULL,
    DOB DATE NOT NULL,
    Title VARCHAR(255) NOT NULL
)  ENGINE=INNODB;


^^^
VERIFY
SHOW TABLES;
+---------------------+
| Tables_in_datastore |
+---------------------+
| Employee            |
+---------------------+
1 row in set (0.00 sec)



^^^
DESCRIBE Employee;
+---------+--------------+------+-----+---------+----------------+
| Field   | Type         | Null | Key | Default | Extra          |
+---------+--------------+------+-----+---------+----------------+
| task_id | int          | NO   | PRI | NULL    | auto_increment |
| FName   | varchar(100) | NO   |     | NULL    |                |
| LName   | varchar(200) | NO   |     | NULL    |                |
| DOB     | date         | NO   |     | NULL    |                |
| Title   | varchar(255) | NO   |     | NULL    |                |
+---------+--------------+------+-----+---------+----------------+
5 rows in set (0.00 sec)



^^^
DML
INSERT INTO Employee(FName,LName,DOB,Title)
VALUES('FNAME01','LNAME01','2021-01-11','FOO01');

INSERT INTO Employee(FName,LName,DOB,Title)
VALUES('FNAME02','LNAME02','2021-02-12','FOO02');

INSERT INTO Employee(FName,LName,DOB,Title)
VALUES('FNAME03','LNAME03','2023-03-13','FOO03');

SELECT * FROM Employee;



^^^
OPTIONAL (DDL)
DROP TABLE IF EXISTS Employee;



^^^
POST to this endpoint when an employee is added/removed
https://testnotify.free.beeceptor.com





^^^
PAYLOAD

{
  "id": 12,
  "operation": "EMPLOYEE_DELETED"
}

"id": identifier from SQL database
"operation": enum restricted by  "EMPLOYEE_DELETED" , "EMPLOYEE_ADDED"



^^^
http://www.javaguides.net/2018/09/spring-boot-2-jpa-mysql-crud-example.html



^^^
ISSUE:  MySQL 8 - Public Key Retrieval is not allowed (startup)

Add to application.properties:

spring.datasource.url = jdbc:mysql://localhost:3306/Employee?useSSL=false&allowPublicKeyRetrieval=true

ref https://www.hannonhill.com/cascadecms/latest/faqs/common-errors/public-key-retrieval-is-not-allowed.html



^^^
ISSUE:

a. Stop MySQL

b. sudo -s

c. CLI - mysqld_safe --skip-grant-tables &

c. CLI - mysql -u root

d. ABANDON SHELL


ref https://stackoverflow.com/questions/11922323/java-sql-sqlexception-access-denied-for-user-rootlocalhost-using-password

ref https://stackoverflow.com/questions/2995054/access-denied-for-user-rootlocalhost-using-passwordno
