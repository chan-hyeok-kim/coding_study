### bean

- 어노테이션 옆에 bean이름 지정 가능, 따로 지정하지 않으면 클래스명의 첫글자를 소문자로  
- 클래스의 객체 생성
  1. XML에서 BEAN 선언
  2. NEW 생성자
  3. 어노테이션



```

- 객체의 생명주기를 관리 : Container
- Tomcat Container      : 내장 객체 관리
- Spring Container      : Java 객체 관리
- Spring에서는 개발자가 객체를 직접생성하지 않고 Spring Container에게 위임
- 위임을 하면 Spring Container가 객체를 생성하고 bean pool에 저장
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

			a. @Autowired 
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
라이브러리 클래스의 객체생성은 XML 사용

- DTO 클래스는 위임 하지 마세요(Annotation으로 객체 생성 X)


```


### Filter

```

Servlet에서 사용

- 요청발생시 Servlet 진입 전에 필터사용
- 응답발생시 필터를 거쳐서 응답 발생
- URL 패턴으로 필터를 구분

- 여러개의 필터 사용 가능
- web.xml에 등록 된 순서대로 필터 사용


1. 생성
	 File -> new -> other -> Filter 검색 

2. 주요 메서드
		1) destroy : Filter 객체가 소멸될 때 호출되는 메서드
		2) init... : Filter 객체가 생성된 후 호출되는 메서드
		3) doFilter : check 할 코드를 생성
				- chain.doFilter : 다음 필터의 doFilter를 호출하거나 없으면 servlet의 service 메서드 호출
				- chain.doFilter 위에 요청시 해야 할 코드 작성
				- chain.doFilter 아래에 응답시 해야 할 코드 작성

3. 등록
	 - web.xml에 필터 사용 등록 
	1) Filter 객체 생성
	 <filter-class>
			<filter-name>			</filter-name>
			<filter-class>		</filter-class>
			<init-param>
					<param-name></param-name>
					<param-value></param-value>
			</init-param>
	 </filter-class>

	 <filter-mapping>
			<filter-name></filter-name>
			<url-pattern></url-pattern>
	 </filter-mapping>
	




```


### Interceptor

```


- Spring
- 진행 순서를 가로 채서 작업
- Tomcat(Servlet) 에서 제공하는 Filter가 있음
- 요청 URL을 이용해서 걸러 주는 역할

1. Interceptor 생성
	1) Interceptor 역할을 하는 클래스 선언, HandlerInterceptorAdator 클래스를 상속

	2) 필요한 시점의 메서드를 오버라이딩 함, 모든 메서드를 오버라이딩 할 필요 없음

2. Interceptor 메서드
	1) preHandle
		- Controller 진입 전

	2) postHandle
		- Controller에서 Dispathcer Servlet으로 나갈 때

	3) afterCompletion
		- View(jsp)를 렌더링 후

3. Interceptor 설정
	- servlet-context.xml에 작성


```