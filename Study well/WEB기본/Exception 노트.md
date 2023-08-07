### 오류들

```

Error  : 컴파일 에러(문법적으로 오류)
Exception : 실행시 발생하는 에러

서버 실행시 확인 : console 메세지 확인
1. xml 문제 발생
2. annotation

위 두 문제가 아닌 경우
1. 서버 탭에서 서버 우클릭 clean
2. 프로젝트명 우클릭 -> maven -> update project
3_1. 프로젝트명 우클릭 -> run as -> maven clean //라이브러리가 사라질 수 있음. 최후의 수단
3_2. 프로젝트명 우클릭 -> maven -> update project
4_1. STS종료
4_2. 사용자폴더->.m2 ->repository 내의 모든 폴더 삭제
4_3. STS실행
4_4. 프로젝트명 우클릭 -> maven -> update project


java파일 컴파일되면->.class가 됨

```

### Front Error

```
-- 응답은 상태번호와 같이 온다

-- 정상적 실행: 200
-- 400
-- 404 -> Not Found라는 뜻
          1. URL이 안맞았을 때
          2.  





```
### JDBC하면서 겪은 예외 유형

jsp
ajax

redirect는 서버가 클라이언트로주는 주소


### NullpointerException

```

  -- 참조변수의 객체가 NULL인 경우, 메서드 호출 시 예외 발생
  -- 참조변수의 주소가 null인지 확인해야됨
 
```

### getTotal Exception
list parameter가 문제였음 (DTO로 해놨었음)

### PropertyNotFoundException
items = "${list}"안하면 오류

### java.sql.SQLException: 부적합한 열 유형: 1111

SEVERE: 경로 []의 컨텍스트 내의 서블릿 [appServlet]을(를) 위한 Servlet.service() 호출이, 근본 원인(root cause)과 함께, 예외 [Request processing failed; nested exception is org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.type.TypeException: Could not set parameters for mapping: ParameterMapping{property='boardHit', mode=IN, javaType=class java.lang.Long, jdbcType=null, numericScale=null, resultMapId='null', jdbcTypeName='null', expression='null'}. Cause: org.apache.ibatis.type.TypeException: Error setting null for parameter #1 with JdbcType OTHER . Try setting a different JdbcType for this parameter or a different jdbcTypeForNull configuration property. Cause: java.sql.SQLException: 부적합한 열 유형: 1111]을(를) 발생시켰습니다.


먼저넣은 boardHit값이 null이라서 계산못한거임

null값이 들어갈만한.
매개변수가 있는 해당 컬럼쪽의 모든 메서드를 찾아봐야함.


###

405 : 
1. 요청메서드가 일치하지 않는 경우

400 :
1. 파라미터의 타입과 bean의 멤버의 타입이 일치 X


