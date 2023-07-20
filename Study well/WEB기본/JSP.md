# JSP

```

HTML내에 Java코드 작성
JSP는 실행시 다시 Servlet으로 변환 됨

Java 코드 방식
1. 스크립틀릿
	<%  Java 코드 작성 %>    : 스크립틀릿
	<%= java의 변수나 값 %>  : HTML에 출력 (표현식)
	<%! 변수나 메서드 선언 %> : 선언문

2. JSP 주석
	<%--    --%>

2. EL(Expression Language) & JSTL(JSP STANDARD Tag Library)
	1. EL
		- 출력 전용
		- if, for 없음
		- 문법
		${scope명.속성명}
		
		- scope명
			-- 내장객체의 LifeCycle
			-- pageScope(jsp실행과 종료) -> requestScope(객체생성과 종료) -> sessionScope -> applicationScope(tomcat의 실행과종료)

		- Attribute에 DTO 가 있을 때
			ex) request.setAttribute("dto", noticeDTO);
			${scope명.속성명.getter의 이름}
			-- getter의 이름 : getter 메서드에서 get을 지우고 첫글자를 소문자로 바꾼것
			${requestScope.dto.writer}

		- Scope명은 생략 가능
			-- pageScope -> appilcationScope
			ex) ${requestScope.ex} -> ${ex}  : scope명 생략
					1. pageScope에 ex 속성명이 있는지 확인 없으면 다음 영역
					2. requestScope에 ex 속성명이 있는지 확인 있으면 출력 하고 끝

		- Scope명을 생략 하면 안되는 경우
			-- 서로 다른 Scope에 동일한 속성명이 있는 경우 

	2) cookie
			-- cookie의 값을 출력 할 때 사용
			-- ${cookie.쿠키의이름.value}

	3) 연산자
		a. 산술연산자 : +, -, *, /, %         ex) ${a+b}    ${a}+${b}(X)
		b. 비교연산자 : >, >=, <, <=, ==, !=  ex) ${a > b}
		c. 논리연산자 : &&(and), ||(or), !(not)
		d. 연산자를 문자열 형식으로 표현
				1. 나누기 연산자     :  div        ex) ${3/5}  -> ${3 div 5}
				2. 나머지 연산자     :  mod        ex) ${3 mod 2}
				3. and 연산자        : and         ex) ${a and b}
				4. or 연산자         : or          ex) ${a or b}
				5. <  연산자         : lt          ex) ${a lt b} 
				6. <= 연산자         : le          ex) ${a le b}
				7. >  연산자         : gt          ex) ${a gt b}
				8. >= 연산자         : ge          ex) ${a ge b}
				9. == 연산자         : eq          ex) ${a eq b}
				10. != 연산자        : ne          ex) ${a ne b}
				11. empty (값이 null이거나, 없거나, size가 0) ex) ${empty a}
				12  not empty (empty의 반대)       ex) ${not empty a}




	2. JSTL
		- 스크립 틀릿을 사용하지 않음
		1) JSTL 태그 
			a. Core Tag       : 변수관리, 제어문등을 제공 접두사(prefix, 태그명) : c
			b. Function Tag   : 문자열 조작, 문자열 길이등 함수제공 접두사       : fn
			c. Formatting Tag : 숫자, 날짜, 통화단위 등을 지원                  : fmt
			d. XML Tag        : XML 관련                                       : x
			e. SQL Tag        : SQL 지원                                       : sql


		2) Core Tag
			a. 사용순서
				 - 사용하려는 JSP page 마다 선언부에 JSTL 라이브러리 선언
					<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			b.c:import  
				- 동일한 내용의 태그들을 부품으로 만들어서 사용
				<c:import url="">
				- URL에 서버 내부의 주소, 상대 경로로 작성

			c. c:forEach
				1) 숫자를 반복
					<c:forEach begin="시작번호" end="끝번호" step="증가값" var="숫자를담을변수명">
					- end 이하값
					- step 생략가능, 기본은 1, 0 이하값은 X
					<c:forEach begin="10" end="1" step="-1" var="숫자를담을변수명"> : 사용불가

				2) Collection 반복 
					<c:forEach items="Collection의 속성명" var="DTO를 담을 변수명" varStatus="상태를 담을 변수명">

					- varStatus
						-- 필수는 아님, 필요하면 사용
						a. 현재 아이템 : ${pageScope.상태를담을변수명.current}	
						b. 인덱스번호  : ${pageScope.상태를담을변수명.index}	
						c. 순서 번호   : ${pageScope.상태를담을변수명.count}	
						d. 처음 ??     : ${pageScope.상태를담을변수명.first}	
						e. 마지막 ??   : ${pageScope.상태를담을변수명.last}
						f. 시작값      : ${pageScope.상태를담을변수명.begin}
						g. 끝값        : ${pageScope.상태를담을변수명.end}
						h. 증가값      : ${pageScope.상태를담을변수명.step}

				d. c:if
					- 단일  if
					- <c:if test="조건식"></if>

				e. c:choose
					- 다중 선택 
					- java의 switch case 또는 if - else 대체

					- <c:choose>
								<c:when test="조건식"></c:when>
								<c:when test="조건식"></c:when>
								<c:when test="조건식"></c:when>
								<c:otherwise></c:otherwise>

						</c:choose>

					f. c:catch
						-예외처리
						- java의 try-catch 역할
						- <c:catch>
									예외가 발생할 코드
							 </c:catch>
	



```
