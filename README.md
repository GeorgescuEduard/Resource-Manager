# Resource-Manager
 Resource Manager - Spring MVC Web Application
======================================

Application Description
-----------------------

Technologies
------------
* Spring 5
* Spring MVC
* JPA
* Bootstrap
* JSP
* JSTL
* JDK 15
* MySQL
* IntelliJ IDEA
* Maven
* Tomcat

Application Setup
-----------------
In order to run this application you must create a MySQL database called `accountbanking`:

```sql
CREATE DATABASE accountbanking;
USE accountbanking;
CREATE TABLE `user` (
  `userid` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `firstname` varchar(40) NOT NULL,
  `lastname` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(40) NOT NULL
);
CREATE TABLE `wallet` (
  `walletid` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(40) NOT NULL,
  `description` varchar(100) NOT NULL,
  `amount` decimal NOT NULL,
  `userid` bigint NOT NULL
);
CREATE TABLE `transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `description` varchar(100) NOT NULL,
  `amount` decimal NOT NULL,
  `date` datetime NOT NULL,
  `userid` bigint NOT NULL,
  `walletid` bigint NOT NULL
);
ALTER TABLE wallet
ADD FOREIGN KEY (userid) REFERENCES user(userid);
ALTER TABLE transaction
ADD FOREIGN KEY (userid) REFERENCES user(userid);
ALTER TABLE transaction
ADD FOREIGN KEY (walletid) REFERENCES wallet(walletid);
```
The database connection details can be changed from file src/main/resources/application.properties:
```properties
spring.datasource.username=Eduard
spring.datasource.password=
```
In order to run application using Maven you must create a tomcat server using Spring Tool Suit and launching the mail class BankApplication.java.
