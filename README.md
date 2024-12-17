# article-comment
- 공부한 것들 정리 : <a href="https://velog.io/@hajju/series/Spring-Boot-articlecomment">article-comment</a>
- MVC + JPA + REST API
---
# 문제 해결.
  - 외래키로 연결되어 있어서 참조 무결성에 의해 댓글이 작성되어 있는 글은 즉시 삭제가 불가한 문제.
  - 해결 과정 : <a href="https://velog.io/@hajju/%EB%8C%93%EA%B8%80%EC%9D%B4-%EC%9E%88%EB%8A%94-%EA%B8%80-%EC%82%AD%EC%A0%9C%ED%95%98%EA%B8%B0">JPA 연관관계 - mappedBy</a>
# project
![](https://github.com/user-attachments/assets/ff308e72-7528-44d3-8e1b-a120feb77fae)
![](https://github.com/user-attachments/assets/70f47cc1-8ff0-44d5-adf8-1ef453257465)
- Spring
  - Gradle.
  - java(jdk17).
  - Spring boot 3.1.0
  - JPA
  - JUnit5
- view
  - Mustache
  - bootstrap
- DB
  - H2 -> PostgreSQL
- IDE
  - Intellij
- ERD
![](https://github.com/user-attachments/assets/47b5efda-1ab4-4e4f-af81-cc0fef084a59)
