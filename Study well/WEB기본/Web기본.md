### 웹 기본

```


0. 참고 사이트
https://developer.mozilla.org/

1. protocol     : 통신 규약

2. HTTP
	- HyperText Transfer Protocol
	- HTTPS : 보안 기능 강화
	- TCP   : 신뢰성 있는 연결
	- UDP   : 비연결성 (연결 유지 하지 않음)

3. Request
	- 서버에게 자원을 요청

4. Response
	- 서버가 보낸 응답

5. URL
	- Uniform Resource Locator
	- 자원의 위치를 작성
	- 도메인을 URL이라 함
	- IP주소:port번호/폴더명/폴더명.../파일명

6. Web Browser
	- HTML, CSS, JavaScript 실행(해석)하는 프로그램

7. Front-end 와 Back-end
	- 코드의 실행이 Cilent 컴퓨터에서 실행 하면 Front-end
	- 코드의 실행이 Server 컴퓨터에서 실행 하면 Back-end

8. Full-Stack
	- Front-end 전문가
	- Back-end 전문가
	- Front-end 할 줄 알고, Back-end도 할 줄 아는 개발자

9. 접근성
	- 누구나 사용이 가능 

10. 표준화
	- 하나의 Source로 모든 웹브라우저에서 동일하게 표현
	- HTML5, CSS3 아직은 진행 중

    	

```

### WAS (web application server)

* 동적인 서버

tomcat: 자바와 http사이에서 통역해주는 친구
자바 쓸 때 servlet 필요

```
1. 웹 서버 (Web Server)
	- 정적 서비스 
	- 클라이언트가 서버에 페이지 요청을 하면 요청을 받아 정적 컨텐츠(.html, .png, .css등)를 제공하는 서버

2. WAS (Web Application Server)
	- 동적 컨텐츠를 제공하기 위해 만들어진 애플리케이션 서버 
	- JSP,Servlet 구동 환경 
	- 웹컨테이너, 서블릿 컨테이너

```

### 경로

```

Web project의 최상위 폴더를 root 라하고 그 이름을 root-context 라 함

1. 절대 경로
		root 가 기준

	root-context명을 표기하는 경우 :		/root-context명/하위폴더명/하위폴더명/...
	root-context명이 생략 된 경우  :   /하위폴더명/하위폴더명/...


2. 상대 경로
		현재 폴더 위치 기준

a. 		 ../   : 한 단계 위로 이동(폴더)
		 ex) ../../
b.     ./ 또는 생략 : 현재위치에서

```


### HTTP

```


1. GET
	- 단순 요청
	- 파라미터가 주소창에 노출(파라미터가 Header에 담김)
	- 작은 용량을 보낼 때

	A. Web Browser의 주소창에 직접 URL을 입력하는 경우
	B. A(link)태그 를 이용하는 경우
	C. Javascript의 location.href를 사용하는 경우
	D. Ajax 메서드에서 Get을 선택한 경우
	E. Form 태그 메서드에서 Get을 선택한 경우


2. POST
	- 보안에 민감한 요청
	- 파라미터가 주소창에 노출 X (파라미터가 Body에 담김)
	- 큰용량도 보낼 수 있음

	A. Form 태그 메서드에서 Post를 선택한 경우
	B. Ajax 메서드에서 Post를 선택한 경우

3. PUT

4. DELETE

5. HEAD

6. OPTIONS

```