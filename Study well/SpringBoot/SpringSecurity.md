### Spring Security


#### 1. 용어

```

1. Authentication 
	 - 인증
	 - 로그인
	 - 유저 식별

2. Authorize
	 - 인가
	 - 접근 권한
	 - 인증된 유저의 권한

3. Principal
	 - 접근주체(객체)
	 - Spring Security에서 사용하는 인증, 인가 정보가 있는 객체

4. Credentials
	 - 리소스에 접근하는 대상의 비밀번호



  --- 원리 ---

1. HTTP Session에 Seurity Session을 생성 함 ( Seurity Session = Security Context Holder)
2. Security Context Holder -> Security Context 가 있음

--------------------------------------------------------------------------------------------
	 Java에서 Security Context 정보 출력
--------------------------------------------------------------------------------------------
	a. Session 이용
	 HTTPSession에 'SPRING_SECURITY_CONTEXT' 속성명으로 사용 가능
		Enumeration<String> en = session.getAttributeNames();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());  //SPRING_SECURITY_CONTEXT
		}
		
		Object obj=(session.getAttribute("SPRING_SECURITY_CONTEXT"));
		
		SecurityContextImpl sc = (SecurityContextImpl)obj;
		System.out.println(sc);

	b. SecurityContextHolder 이용

		SecurityContext context = SecurityContextHolder.getContext();
		System.out.println(context);

--------------------------------------------------------------------------------------------
	출력 결과 sc, context 같은 내용
--------------------------------------------------------------------------------------------
SecurityContextImpl 
[Authentication=UsernamePasswordAuthenticationToken 
	[Principal=org.springframework.security.core.userdetails.User 
		[Username=user, Password=[PROTECTED], Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, 
			AccountNonLocked=true, Granted Authorities=[]], Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails 
			[RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=60C9C3D3B9E7A5F3C1737FB3010D8983], Granted Authorities=[]]]


2. Security Context Holder -> Security Context -> Authentication 이 있음
3. 필요한 정보는 Authentication


참고
https://cookiee.tistory.com/520




```




#### 2. 설정

```

1. Spring Security API POM.XML 추가
	1) 프로젝트 생성시 Security API 선택
	2) 기존 프로젝트에 추가

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>


2. Security 추가 후 비 활성화
 - main 메서드가 있는 클래스의 선언부에  exclude = SecurityAutoConfiguration.class 추가
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

 - 또는 properties에 추가
#spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration


```

#### 3. DB 구성

```

Member
ROLE
- role의 이름 구성 전부 대문자
- ROLE_***

MEMBER_ROLE


```

#### 4. config

```

Spring Security 5.7.0-M2 부터 WebSecurityConfigureAdapter는 Deprecated 됨
대신 SecurityFilterChain 을 Bean으로 등록하는 방식을 권장

1. WebSecurity 설정 클래스 생성

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	
	@Bean
	//public 을 선언하면 default로 바꾸라는 메세지 출력
	WebSecurityCustomizer webSecurityConfig() {
		//Security에서 무시해야하는 URL 패턴 등록
		return web -> web
			   .ignoring()
			   .antMatchers("/images/**")
			   .antMatchers("/css/**")
			   .antMatchers("/js/**")
			   .antMatchers("/favicon/**")
			   .antMatchers("/resources/**");
	}

@Bean
	SecurityFilterChain fiterChain(HttpSecurity httpSecurity)throws Exception{
		httpSecurity
					.cors()
					.and()
					.csrf()
					.disable()
				.authorizeRequests()
					.antMatchers("/").permitAll()
					.antMatchers("/admin").hasRole("ADMIN")
					.antMatchers("/manager").hasAnyRole("ADMIN","MANAGER")
					.anyRequest().authenticated()
					.and()
				.formLogin()
					.permitAll()
					.and()
				.logout()
					.permitAll();

		
		return httpSecurity.build();
					
	}

}


```


#### 5. authorizeRequests()

```

요청 URL과 그에 관한 권한 설정 하는 곳

요청 URL 정보
antMatchers("요청 URL")
antMatchers("요청 URL", "요청 URL", ...)

해당URL의 권한 설정
- DB에는 Role명이 ROLE_NAME

- hasRole(ROLE_를제외한 나머지이름)
hasRole("권한이름")
hasAnyRole("권한이름1", "권한이름2",...) : 여러개의 권한 중 하나만 있어도 통과

permitAll() : 누구나 허용
denyAll()   : 누구나 차단
anonymous() : 익명사용자 허용

hasAuthority("권한이름") 
hasAnyAuthority("권한이름", "권한이름2",...) 

authenticated() : 인증된 사용자 허용


```


### formLogin()

#### 1.UserDetails

```
Spring Security에서 제공하는 VO개념, Interface

1. 새로운 VO를 만들고 UserDetail 구현
	 public class MemberVO Implements UserDetails

2. 새로운 VO를 만들고 UserDetail 구현
	 MemberVO를 새로운 VO에 멤버변수로 활용
	 public class User implements UserDetails{
		 private MemberVO memberVo
	}


```

#### 2. UserDetailsService 구현

```

새로 서비스를 만들거나
memberService에 loadUserByUsername 재정의

```


#### 3. Flow

```

1. ID, PW 입력
2. /member/login , POST, ID(username), PW(password)
3. Security Filter에서 로그인 처리
	 - UserDetailsService를 찾아서 loadUserByUsername메서드 호출
	 - DB에서 ID(username)으로 조회
	 - UserDetails 리턴
4. Security Filter에서 리턴 받은 UserDetails에서 PASSWORD를 꺼내서 검증

```


#### 4. jsp확인

1. API추가

```

<dependency>
		    <groupId>org.springframework.security</groupId>
		    <artifactId>spring-security-taglibs</artifactId>
	</dependency>

```


2. JSP에 태그립

```

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

```

3. 로그인 유무 판단과 권한

```

1. 로그인 유무
<sec:authorize access="isAuthenticated()"></sec:authorize>  : 로그인 되었을 때
<sec:authorize access="!isAuthenticated()"></sec:authorize> : 로그인 되어 있지 않을 때

2. 권한
<sec:authorize access="hasRole('권한이름')"></sec:authorize> : 해당 권한만 사용 가능
<sec:authorize access="hasAnyRole('권한이름1', '권한이름2')"></sec:authorize> : 해당 권한만 사용 가능

3. ALL
<sec:authorize access="permitAll"></sec:authorize> : 누구나 사용 가능
<sec:authorize access="denyAll"></sec:authorize>   : 누구도 사용 불가능

4. URL
- URL 경로가 Security Config 설정에서 특정권한을 가진 URL로 등록 되어 있는 경우
<sec:authorize url="/admin/"></sec:authorize>      : admin 권한 있는 경우 가능

```


#### 기타

* 요청 시 servlet 기본 필터 ->security 필터를 거친다
* uri나 url변경 가능

* 휴면계정 전환 - 로그인 핸들러 사용
* 로그아웃 필터에 내장된	   
	    - 로그아웃 핸들러도 사용 가능
		- Logout 기능을 활성화하면 LogoutFilter 가 생김 
		해당 필터 내부에는 이미 로그아웃 핸들러 존재.

* getPrincipal()시 Object타입은 memberVO의 부모를 상속받지 않는다
* 그러나 userDetails는 구현된다