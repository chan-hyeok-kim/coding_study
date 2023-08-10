### 웹 기본

* CDN (contents delivery network)
:다른 서버에 요청
(자원 분산)

(<=>) link, script src 
:우리 서버에 요청



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



7. 확장자
war 웹 실행 파일
jar 자바 실행 파일

```


###


```


1. web.xml(배포서술자, 설명서)등 설정 파일을 읽고 준비
	 <servlet> : 해당 객체를 생성
2. 초기화 작업

3. Client 로부터 요청이 발생하면 요청의 모든 정보(Client정보, 파라미터등) 를 담는 request 객체(URL과 메서드 형식-get/post) 와 response 객체 생성

4. URL요청에 맵핑 되는 Servlet 객체의 Service 메서드(get/post->doget/dopost)를 호출하고 파라미터로 request와 response 객체를 인자값으로 전달

5. service메서드에서 메서드 형식을 파악한 후 doGet 또는 doPost메서드를 호출하고 request와 response 객체를 인자값으로 전달

6. server 작업 후 Client로 보낼 데이터를 response에 담아 Client로 내보내고 request와 response 객체를 소멸 시킴



```


### url - 서버에 요청할때 필요한 것
uniform  resource locater

* 요청할 때 보내는 것
url - ip: port/경로
+ 파라미터(클라이언트가 요청한 것)
+ 쿠키

1. tomcat은 어플리케이션 객체 생성 후 web.xml을 읽음.
2. servlet 객체 생성(request, response)
3. 톰캣 서버에서 쿠키의 sid값을 체크. null인 경우 session객체 생성 및 sid전달
4. 
5. controller로 가서 
6. service메서드


7. 페이지는 jsp에 가서 만들어짐

응답으로 html을 내보내는 forward
응답으로 url을 내보내는 redirect

### jsp

* 일종의 서블렛

* 일단은 서버상태였다가 서블렛으로 바뀜.

### tomcat에서 request와 response의 이동
```
xml파일을 읽고
tomcat이
request, response객체 생성(servlet-XXcontroller) -> service메서드 호출 -> doget이나 dopost구별-> request,response를 서비스가 매개변수로 받고 던짐-> DAO -> DB -> DAO -> JSP(servlet)

이후 객체 소멸

```



### 내장 객체

```

- Tomcat(WAS)이 생성하는 객체만
- Life Cycle 이 중요(생명주기)
- 내장 객체에서 다른 내장 객체를 반환
- 단, 라이프사이클이 짧은 것에서 부터 큰것들을 반환
- 역으로 반환 X

1. Page
	- jsp 가 실행하면 생성되고, jsp를 벗어나면 소멸
	- jsp내의 정보를 담고 있는 객체

2. Request & Response : HttpServletRequest & Response : HttpServletResponse
	- 요청이 발생하면 생성되고, 응답이 나가면 소멸
	- RequestScope (Request영역)
	- 주요 메서드
	1) String value = getParameter("파라미터이름")           : Parameter 값 한개 반환
	2) String [] values = getParameterValues("파라미터이름") : 한개의 파라미터이름으로 여러개의 값이 올때
	3) Enumeration <String> en = getParameterNames()         : Parameter의 이름을 가지고 오고 싶을 때
	4) setAttribute("속성명", 값)                            : jsp로 보낼 데이터

3. Session
	- Server에 Client가 처음 요청이 발생하면 Session 객체 생성
	- Session 객체를 식별하는 sessionId를 생성해서 Cookie로 Client에 저장
	- Session 객체는 Server에 저장관리
	- server에서 session 객체를 소멸시키거나 Client 의  JSessionID가 삭제 되었을 때
	- 또는 session 객체가 생성되고 일정 시간동안 해당 Client이 요청이 없을 때 삭제

	- 주요 메서드
		1) long getCreationTime()                  : session 객체가 만들어진 시간을 반환, Milliseconds
		2) long getLastAccessTime()                : Client에서 마지막에 접근한 시간(요청)을 반환
		3) void setMaxinActiveInterval(int second) : Session 유효 시간 초 단위
		4) int getMaxinActiveInterval()            : Session 유효 시간 반환 
		5) void setAttribute("key", Object)        : Session 속성에 Data저장
		6) Object getAttribute("key")              : Session 속성의 Data 반환
		7) void removeAttribute("key")             : Session 속성의 key에 해당하는 Data 삭제
		8) void invalidate()                       : Session 삭제 (유효시간을 0으로 만듬)

	- Session 유효기간 설정
	1) setMaxinActiveInterval 사용
	2) web.xml 등록
		 <session-config>
				<session-timeout>20<session-timeout>   --분단위
		 </session-config>

	3) Tomcat web.xml
		 <session-config>
				<session-timeout>20<session-timeout>   --분단위
		 </session-config>

	-- 설정 우선 순위
		1) > 2) > 3)


4. Application(ServletContext)
		- Web application과 외부(OS)간의 연결정보를 담고 있는 객체


```

### 쿠키 (SID. 세션 아이디가 담기는 곳)


```

- Server에서 생성하고 Client(Web Browser)에 저장되는 작은 크기의 Text 파일
- Server에서 생성된 Cookie를 Response에 담아서 Client로 전송
- Client는 Server에 요청을 할 때 해당 Server에서 발행한 Cookie가 있으면 요청시 같이 보냄
- 같은 Domain에서만 사용가능 (Naver에서 생성한 Cookie는 naver 접속시만 사용 가능, 쿠팡에서는 사용 불가능)
- Key(이름:String) 과 Value(값: String) 형식
- 웹 브라우저마다 다른 SID값을 준다

1. 메서드

	a. String:  getName()    : Cookie의 이름 반환(key)
	b. String:  getValue()   : Cookie의 값 반환(Value)
	c. String:  getPath()    : Cookie의 유효 경로정보를 반환(발행한 URI, 같은 URI 폴더 내에서 사용 가능)
	d. String:  getDomain()  : Cookie의 Domain 정보 반환
	e. String:  getMaxAge()  : Cookie의 유효시간을 반환

	f. void  : setValue("값")    : Cookie를 생성하고 Cookie의 값을 변경
	g. void  : setPath("경로")   : Path(URI) 경로 변경
	h. void  : setMaxAge(int )   : 유효 시간을 지정, 단위는 초 단위 , 0이면 삭제, -1이면 영구적


- 같은 이름으로 Cookie를 발행하면 수정의 의미

2. Java Cookie 사용

	a. 쿠키생성
			//cookie 생성
			Cookie cookie = new Cookie("remember", "value");
			cookie.setPath("/");
			cookie.setMaxAge(-1);
			//응답에 추가
			response.addCookie(cookie);

	b. 쿠키 사용
		1) Request 
			Cookie [] cookies = request.getCookies();

		2) @CookieValue
			@CookieValue(value="Cookie의 이름", required = false, defaultValue="값") String value
			- value          : Cookie의 이름
			- required      : true면 Cookie가 없으면 에러
									      false면 Cookie가 없으면 null 반환
			- defaultValue  : Cookie가 없으면 기본값 적용

3. Cookie 삭제
		- setMaxAge(0) 으로 삭제






```





### Parameter와 Attribute

```

ex)
https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%95%84%EC%9D%B4%EC%9C%A0

url은 ?좌측까지고, 우측부터는 파라미터다

1. Parameter  
	- Client에서 Server로 보내는 데이타
	- 이름과 값으로 구성
	- 이름 : String, 값 : String

2. Attribute(method)
	- Server 내에서 서로 데이터를 주고 받을 때 사용
	- 내장객체에 존재
	- 이름과 값으로 구성
	- 이름 : String, 값 : Object


```