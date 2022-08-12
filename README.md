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
- 소스경로 : https://github.com/ricky9397/springboot_security1/blob/master/src/main/java/com/ricky/security1/config/WebMvcConfig.java


## SecurityConfig extends WebSecurityConfigurerAdapter 
- 최신 버전은 WebSecurityConfigurerAdapter 가 먹히질 않기 때문에 버전을 낮추던가 버전에 맞는 extends를 해야한다. 구글참조. (스프링부트 버전 2.4.3)
- Spring Security의 의존성을 추가한 경우 위와 같이 WebSecurityConfigurerAdapter클래스가 실행되게 된다.
- WebSecurityConfigurerAdapter클래스는 스프링 시큐리티의 웹 보안 기능의 초기화 및 설정들을 담당하는 내용이 담겨있으며 내부 적으로 getHttp()메서드가 실행될 때 HTTPSecurity 클래스를 생성하게 된다.
- 이때의 HTTPSecurity는 인증/인가 API들의 설정을 제공한다.



