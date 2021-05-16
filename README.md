# 블로그 프로젝트
이 프로젝트는 사용자가 글을 포스팅할 수 있는 블로그 프로젝트입니다.

<br/>
<br/>

## 사용 기술

- Java 11 [(openjdk)](https://jdk.java.net/archive/)
- Spring Boot '2.4.5.RELEASE'
- Spring Security
- Spring Data JPA
- JSP
- Ajax
- 부트스트랩
- summernote editor

<br/>
<br/>

## 기능

- REST API 통신
- 메인 페이지: http://localhost:8000/
- 회원가입: http://localhost:8000/auth/joinForm
- 회원수정: http://localhost:8000/user/updateForm
- 로그인: http://localhost:8000/auth/loginForm
- 카카오 로그인시: http://localhost:8000/auth/kakao/callback
    - "/auth" 경로는 모든 권한 허용
- 글 등록: http://localhost:8000/board/saveForm
- 글 상세보기: http://localhost:8000/board/{id}
- 글 수정: http://localhost:8000/board/{id}/updateForm
- 댓글 등록, 삭제
- 소셜로그인 (카카오)
    - 블로그 서버 로그인과 구별하기 위해 User 엔티티에 oauth 필드를 추가
    - 카카오로 로그인시 kakao라는 값이 들어감.
- 페이징

<br/>
<br/>

## 화면

#### 회원가입, 회원수정

![캡처](https://user-images.githubusercontent.com/55525868/118399971-adadcf00-b69a-11eb-8383-ee510f20c00f.PNG)

<br/>

#### 로그인, 카카오 로그인

![캡처](https://user-images.githubusercontent.com/55525868/118400024-e188f480-b69a-11eb-9924-8ef7e327bd58.PNG)

<br/>

#### 글 상세보기, 수정, 삭제, 댓글

![캡처](https://user-images.githubusercontent.com/55525868/118400108-3af12380-b69b-11eb-8ebd-b2c845122a06.PNG)

<br/>
<br/>

## DB

- MySQL version: 8.0.22

#### DB Table Relationship

![캡처](https://user-images.githubusercontent.com/55525868/118400403-7dffc680-b69c-11eb-8c27-791bbeef5c7b.PNG)

- 게시글 : 사용자 -> N : 1 관계
- 댓글 : 게시글 -> N : 1 관계
- 댓글 : 사용자 -> N : 1 관계
- 어떤 사용자가 어떤 게시글에 댓글을 쓰는지 알기 위해 boardId, userId를 조인

<br/>
<br/>
<br/>
<br/>

### References

- [유튜브 데어 프로그래밍](https://www.youtube.com/watch?v=6bhF5o4gAOs&list=PL93mKxaRDidECgjOBjPgI3Dyo8ka6Ilqm)
