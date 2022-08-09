# SpringBoot_Security-01
## 202208..
## 환경설정
DB 스키마 생성
- create user 'cos'@'%' identified by 'cos1234';
- GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
- create database security;
- use security;

스프링부트 gradle프로젝트 생성
- Spring Boot DevTools
- Lombok
- Spring Data JPA
- MySQL Driver
- Spring Security
- Mustache
- Spring Web
