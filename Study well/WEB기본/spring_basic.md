###

```

1. Framework
	 - 디자인패턴 + 라이브러리
	 - 개발자가 해야할 것들을 대신 해주는 것들
	 - POJO(Plain Old Java Object) 기반 - 순수한 자바 객체 
	 - Java 개발에만 신경 써라

2. Project 구성
	1) src/main/java      : java의 class 파일들이 있는곳
	2) src/main/resources : Back-end에서 java이외의 자원들
	3) src/test/java      : java Test 파일
	4) src/test/resources : java Test시에 필요한 java 이외의 자원들 

	5) src/main/webapp/resources      : css, js, image 등 저장
	6) src/main/webapp/WEB-INF/spring : Spring Framework 설정 파일들
	7) src/main/webapp/WEB-INF/views  : jsp 파일들

	8) pom.xml             : maven 설정파일, 버전관리, 라이브러리, 배포관리

	9) target              : 개발이 끝나고 배포파일을 생성하면 target 폴더에 저장

3. 요청(Request)과 응답(Response) 진행 순서

	1. 서버 실행(Tomcat 실행)
	2. web.xml을 Tomcat이 읽고 그대로 실행
		1) 배포서술자(DD, Deployment Descriptor)
		2) Servlet 객체를 생성해라(Tomcat이)
		3) / 이하의 모든 요청이 들어오면 Serlvet을 실행(Tomcat)
		4) service method 실행(tomcat)
		5) service method에서 URL에 해당하는 컨트롤러의 메서드를 실행

	2_1. Spring 설정 파일을 읽고 그대로 실행
		servlet-context.xml, root-context.xml 등등...


	3. Request 구성 요소 와 Response
		
		1) URL : 필수
		2) 요청 메서드 형식 : 필수
			- WEB Browser가 지원하는것은 a, b
			- Rest API 에서 나머지 c, d 까지 사용
			a. GET    : 클라이언트에서 서버로 보내는 Data(Parameter)가 주소창에 노출 (Header에 담김)
									보안이 요구 되지 않는 데이터
									작은 용량의 Text를 보낼 때 적합
			b. POST   : 클라이언트에서 서버로 보내는 Data(Parameter)가 주소창에 노출되지 않음 (Body)에 담김)
									보안이 요구 될 때 사용
									용량이 큰 데이터 를 보낼 때 적합
			c. PUT    : 수정(Update)
			d. DELETE : 삭제(Delete)

		3) Parameter : Option
			- Client에서 Server로 보내는 Data
			- 이름과 값 (Name과 Value) 형식
			- 이름은 String 값 String
		4) Cookie(필수)
			- Client 컴퓨터에 저장되는 작은 크기의 파일(text가 저장)
			- Server에서 발행한 Data를 Client에 보냄
			- 이름 과 value 
			- 이름은 String 값 String

		- URL(Uniform Resources Locator)
			ip:port/폴더/...
		- URI(Uniform Resource Identifier)
			-- Server 내에서 사용하는 URL
			-- URL에서 IP:PORT 번호를 제외한 나머지 주소

		5) Request 
			- 요청의 모든 정보를 담고 있음
		6) Response
			- Client의 요청의 결과물을 Server가 Client로 보냄
			- 응답데이터 (HTML,..)
			- 상태코드(200, 404, 500)
			- Server가 발행한 Cookie

4. Get & Post
	1) Get Method
		a. a 태그
		b. JavaScript의 location.href
		c. Ajax에서 Get 선택
		d. form 태그에서 Get 선택
		e. Client가 주소창에 URL 주소를 직접 입력 한 경우

	IP:PORT/폴더명/...?파라미터이름1=값1&파라미터이름2=값2&...
	- ? 왼쪽   : URL
	- ? 오른쪽 : 파라미터들

	2) Post Method
		a. Ajax에서 Post를 선택
		b. form 태그에서 Post 선택

	IP:PORT/폴더명/...

	3) Server로 요청 보내는 방식
		a. a 태그
		b. JavaScript의 Location
		c. Ajax
		d. form 태그
		e. Cilent가 주소창에 URL 주소를 직접 입력



	


```


##

```

전자정부 프레임워크
spring legacy


* 요즘에는 spring boot를 씀.(서블릿 안쓰고 자바만 쓰는 스프링을 씀)

MVC
model  ex)DAO,DTO
view
controller


서블렛 컨트롤러
jsp는 view
로만 쓰는 방식이 MVC2패턴


베이스 패키지명(도메인의 역순 ex - com.iu.main)	
- 최소 3레벨 이상으로 만들 것
```

### 프레임워크

```

코딩에 집중하도록 간편하게 만들어진 틀. 양식

* 폴더
resources - 자바 이외의 요소들은 여기에
test - 테스트 용도

pom.xml - 메이븐(빌드 버전 관리, 자동화 도구)
라이브러리 관리해줌

- 필요한 라이브러리는 mvnrepository에서 코드만 가져오면됨(maven코드로)
- 버전이 바뀌었을 때, 숫자만 코드에서 바꿔주면 알아서 다운로드

- C:\Users\GDJ68\.m2\repository 하위에 다운로드됨
- 따라서 라이브러리 문제 발생 시, 이 하위 폴더를 모두 삭제한 후에 재다운로드받으면 됨

- 기본 루트는 패키지명의 마지막으로 됨.(ex com.iu.main이면 main)

- OJDBC추가 19.14.0.0


```

### pom.xml
버전 유의할 것
자바 1.11
프레임워크 4.3.2.RELEASE

```
<properties>
		<java-version>1.11</java-version>
		<org.springframework-version>4.3.2.RELEASE</org.springframework-version>
		<org.aspectj-version>1.6.10</org.aspectj-version>
		<org.slf4j-version>1.6.6</org.slf4j-version>
	</properties>

```


###

```

서비스는 컨트롤러와 dao사이. ->이건 서비스메서드랑은 다른거임
DAO에 보내는 요청 전처리 작업.
response 후처리 작업


@Repository : 해당 클래스의 객체를 생성하세요
@Service
@Controller


@Autowired : 이 타입으로 만든 객체를 찾아서 넣어주세요
(dependency injection)의존성 주입


```


### DI

```

- 객체의 생명주기를 관리 : Container
- Tomcat Container      : 내장 객체 관리
- Spring Container      : Java 객체 관리
- Spring에서는 개발자가 객체를 직접생성하지 않고 Spring Container에게 위임
- 위임을 하면 Spring Container가 객체를 생성하고 bean(객체) pool에 저장
- 객체는 SingleTon으로 생성 : 어플리케이션 전체에 객체 하나만 생성

멤버 변수에 값을 대입하는 방법(DI, 의존성 주입)
	a. 생성자
	b. 초기화블럭
	c. 직접 대입
	d. Setter
	e. 객체를 생성하고 참조변수명.멤버변수명=값

IOC (Inversion Of Control, 제어의 역전)
- java개발자가 직접 객체 생성하고 직접 DI 작업을 진행을 하는것이 아니고
- Spring에게 객체 생성과 주입을 위임(조립 설계도 제공)


위임 방법
1. Annotation
	- 실행 + 설명
	- servlet-context.xml에 선언된 scan package 범위 안에 있어야 인식 함

	1) 객체 생성(new 생성자())
			- 클래스 선언부 위에 작성
			a. @Controller("이름")     : 객체 생성, Controller 역할
			b. @Service("이름")        : 객체 생성, Service 역할
			c. @Repository("이름")     : 객체 생성, DAO 역할
			d. @Component("이름")      : 객체 생성, Controller, Service, DAO가 아니 그외 나머지

		- 객체(Bean)의 이름을 지정 할 수 있음(참조변수와 비슷)			
		- 이름을 지정하지 않으면 클래스명의 첫글자를 소문자로 만든것이 이름으로 지정

	2) 객체 주입
		- Setter(메서드) 선언부 위에
		- 생성자(매개변수가 있는 생성자) 선언부 위에
		- 멤버변수 선언부 위에

			a. @Autowired (제일 중요)
					1. pool에서 Data Type이 일치하는 객체를 검색
					2. 같은 Type이 여러개 있으면 bean name으로 검색
					@AutoWired
					@Qualifier("대입할 bean의 이름")


					public class A {}

					@Component
					public class B extends A {}   : bean name - b
					
					@Component("hi")
					public class C extends A {}   : bean name - hi
					
					
					...
					@AutoWired
					@Qualifier("hi")
					private A test; //C가 대입
					
					@AutoWired
					private A hi;  //C 가 대입	

			b. @Inject
					- AutoWired와 같음
					- 최신버전에서는 삭제 

			c. @Resource 
					1. Bean name으로 검색
					2. Name이 없으면 Data type으로 검색

2. XML
	/WEB-INF/spring/**/***-context.xml 에 작성
    **->하위 폴더 포함이란 뜻
	***-> "-context.xml"로 끝나는 애들 전부

	1. 객체 생성(Default 생성자 호출)
	<!-- 클래스명 참조변수 = new 생성자() -->
	<bean class="풀패키지명.클래스명" id="참조변수명"></bean>

	<!--ex)-->
	<bean class="com.iu.s1.util.DBConnector" id="dbConnector"></bean>

	2. 객체 생성시 Setter 호출
	<bean class="풀패키지명.클래스명" id="참조변수명">
		<!--setter 호출 값이 refernce 타입일 경우-->
		<property name="setter의 이름" ref="참조변수명">
		<!--setter 호출 값이 primitive와 String 일 경우-->
		<property name="setter의 이름" value="값">
	
	</bean>

	3. 매개변수가 있는 생성자 호출하면서 객체 생성
	<bean class="풀패키지명.클래스명" id="참조변수명">
		1) Index 번호로 구분
		<constructor-arg index="번호" ref or value = "값">

		2) 매개변수명으로 구분
		<constructor-arg name="매개변수명" ref or value = "값">

		3) 데이터타입으로 구분
		<constructor-arg type="데이터타입" ref or value = "값">
		
	</bean>

	pulbic Test(int num, String name, int age){}


- Annotation VS XML
개발자가 선언한 클래스의 객체 생성과 주입은 Annotation 주로 사용
라이러브리 클래스의 객체생성은 XML 사용

- DTO 클래스는 위임 하지 마세요(Annotation으로 객체 생성 X)

```


###

```

- 모든 요청을 DispatcherServlet이 받음
- 
- @Requestmapping에 있는 메서드 호출

DS-controller-service-DAO-DB

c에서 DS로 리턴하는 것은?
ModelAndView라는 객체를 리턴
DS에서 ModelAndView객체 생성

ex)
bankbook/list라는 String이 ModelAndView에 담겨서 DS로 감
리턴 후 IRV(InternalResourceViewResolver) - servlet.context.xml에 있음
그 경로대로 jsp(html을 만듦)를 찾음

```

### @과 XML 차이

```

@은 소스코드수정 가능.
xml은 소스코드수정이 불가능한 경우에도 객체를 만들 수 있다

>> DTO 클래스는 위임하지 마세요(Annotation으로 객체 생성 X) <<

```


### 

```

400번대 클라이언트오류
404 ClassNotFound 이름 못찾음
405 오류 
```


### 윈도우 포트 죽이기
netstat -a -o
taskkill/f/pid 0000
