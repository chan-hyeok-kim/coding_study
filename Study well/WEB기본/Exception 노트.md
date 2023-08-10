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

1. 에러
SEVERE: 경로 []의 컨텍스트 내의 서블릿 [appServlet]을(를) 위한 Servlet.service() 호출이, 근본 원인(root cause)과 함께, 예외 [Request processing failed; nested exception is org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.type.TypeException: Could not set parameters for mapping: ParameterMapping{property='boardHit', mode=IN, javaType=class java.lang.Long, jdbcType=null, numericScale=null, resultMapId='null', jdbcTypeName='null', expression='null'}. Cause: org.apache.ibatis.type.TypeException: Error setting null for parameter #1 with JdbcType OTHER . Try setting a different JdbcType for this parameter or a different jdbcTypeForNull configuration property. Cause: java.sql.SQLException: 부적합한 열 유형: 1111]을(를) 발생시켰습니다.

2. 해결 
```


먼저넣은 boardHit값이 null이라서 계산못한거임

null값이 들어갈만한.
매개변수가 있는 해당 컬럼쪽의 모든 메서드를 찾아봐야함.

```


###

405 : 
1. 요청메서드가 일치하지 않는 경우

400 :
1. 파라미터의 타입과 bean의 멤버의 타입이 일치 X


### Could not resolve type alias ''. 
1. 에러

```
SEVERE: Context initialized 이벤트를 [org.springframework.web.context.ContextLoaderListener] 클래스의 인스턴스인 리스너에 전송하는 동안 예외 발생
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sqlSessionFactoryBean' defined in ServletContext resource [/WEB-INF/spring/database-context.xml]: Invocation of init method failed; nested exception is org.springframework.core.NestedIOException: Failed to parse mapping resource: 'file [D:\GDJ68\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\GDJ68_Spring\WEB-INF\classes\database\mappers\NoticeMapper.xml]'; nested exception is org.apache.ibatis.builder.BuilderException: Error parsing Mapper XML. The XML location is 'file [D:\GDJ68\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\GDJ68_Spring\WEB-INF\classes\database\mappers\NoticeMapper.xml]'. Cause: org.apache.ibatis.builder.BuilderException: Error resolving class. Cause: org.apache.ibatis.type.TypeException: Could not resolve type alias ''.  Cause: java.lang.ClassNotFoundException: Cannot find class: 
	at

```

2. 해결
```
서버 리스타트 안했을 때 생긴 문제였음.
restart하니까 멀쩡함

```

### 예외는 아닌데 update가 안됨

1. 원인
파라미터랑 컨트롤러에서 받는 값 이름이 달랐음
js의 value에 써져있어서 깜빡함

2. 해결
photos->files로 바꿔줌
인줄알았는데

3. 문제 발생
문제 하나가 더 있었음
controller에서 0으로만 찍히는걸 보고
JSP를 계속 본 결과
테이블 태그가 문제였음


### jsp예외 
1. 에러 
 - fileNum이란 걸 찾을 수 없다

2. 해결
controller의 ajaxresult철자 문제였음
Result여야 함.
경로 자체가 잘못되었으니 멤버변수가 안오지


1. 에러
is not a function 
 - 모르겠다는 뜻


### json 예외

from origin : 127/..
해당 서버가 아닌 
다른 서버에서 요청했을 떄 생기는문제


