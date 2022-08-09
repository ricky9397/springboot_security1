# SpringBoot_Security-01
## 202208..
## 환경설정
DB 스키마 생성
- create user 'cos'@'%' identified by 'cos1234';
- GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
- create database security;
- use security;


## 스프링부트 gradle프로젝트 생성
- Spring Boot DevTools
- Lombok
- Spring Data JPA
- MySQL Driver
- Spring Security
- Mustache
- Spring Web

## application.yml 설정
```sh
server:
  port: 8080
  servlet:
    context-path: /
    encoding:
      charset: UTF-8
      enabled: true
      force: true

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/security?serverTimezone=Asia/Seoul
    username: cos
    password: cos1234

  mvc:
    view:
      prefix: /templates/
      suffix: .mustache

  jpa:
    hibernate:
      ddl-auto: update #create update none
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    show-sql: true
```
mustache view -> prefix, suffix 는 생략가능!

## MustacheViewResolver
![image](https://user-images.githubusercontent.com/84554175/183687342-5084401b-4e0f-456a-b078-9eb76d51a9d0.png)
| GitHub | [[plugins/github/README.md](https://github.com/ricky9397/springboot_security1/blob/master/src/main/java/com/ricky/security1/config/WebMvcConfig.java)][PlGh] |


