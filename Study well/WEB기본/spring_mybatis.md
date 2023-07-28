
### 기본 연결 설정



- Database Framework 중 하나
- Mybatis   : 배우기 쉬움  , SQL문 기반, 복잡한 쿼리를 사용할 때 많이 사용
- Hibernate : 배우기 어려움, method 기반, 단순한 쿼리를 사용 할 때 많이 사용

- 공식주소   : https://mybatis.org
- 참조문서   : https://mybatis.org/mybatis-3/

1. 개념
	- SQL문을 Java에서 분리하여 XML에 등록하고 연결해서 사용

2. Mybatis Library 다운
	- Spring은 pom.xml에서 라이브러리 관리를 함
	1) mvnrepository.com 에서 필요한 라이브러리 검색
	2) 원하는 버전을 클릭하고 maven의 내용을 복사
	3) pom.xml에 <dependencies>내에 붙여 넣기 후 저장 
	4) 라이브러리 다운이 끝나면 프로젝트 우클릭-> maven -> update project 실행
	5) 서버를 restart

	a. mybatis 
		- 최신버전
		<dependency>
		    <groupId>org.mybatis</groupId>
		    <artifactId>mybatis</artifactId>
		    <version>3.5.9</version>
		</dependency>

	b. mybatis-spring
		- 최신버전
		<dependency>
		    <groupId>org.mybatis</groupId>
		    <artifactId>mybatis-spring</artifactId>
		    <version>2.0.7</version>
		</dependency>

	c. spring-jdbc
		- 현재 사용중인 Spring Framework 버전과 동일
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-jdbc</artifactId>
		    <version>${org.springframework-version}</version>
		</dependency>

	d. jdbc
		- DB에 맞는 jdbc
		<dependency>
		    <groupId>com.oracle.ojdbc</groupId>
		    <artifactId>ojdbc8</artifactId>
		    <version>19.3.0.0</version>
		</dependency>

3. Sample XML 생성
	1) 폴더 생성 
		- src/main/reosources/ 작성
		- database 폴더 생성(폴더명은 개발자 마음)
		- mappers, config 폴더 생성 (폴더명은 개발자 마음)
	
		-- src/main/resources/database/config/
		-- src/main/resources/database/mappers/

	2) SampleMapper.xml 파일 생성
		- mappers/sampleMapper.xml 파일 생성
		- 기본설정 완료 후 테스트 시 Mapper파일이 없으면 예외 발생

		<?xml version="1.0" encoding="UTF-8"?>
		<!DOCTYPE mapper
		    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
		    
		 <mapper namespace="sample"></mapper>  //namespace가 비어 있으면 예외발생

	3) mybatis 설정 파일 생성
		src/main/webapp/WEB-INF/spring/database-context.xml 생성(root-context.xml 사용가능)
		- spring 폴더에 우클릭 -> new -> spring bean confi...

	4) Web.xml에 3)에서 만든 설정 파일을 등록
		<context-param>
				<param-name>contextConfigLocation</param-name>
				<param-value>/WEB-INF/spring/*-context.xml</param-value>
		</context-param>

	5) src/main/resources/database/config/database.properties 파일 생성
			- Git ignore에 등록 되어 있어야 안전
			- DB 연결정보를 작성
			- 한글 Encoding
				window -> preferences -> general -> contentType 클릭
				Text 확장 -> java Properties 파일 클릭
				Default Encoding을 UTF-8수정하고 꼭!!!! Update 클릭, 적용후 종료

-----------------------------------------------------------------------------------
- database.properties 순서
0. git ignore에 
```
#dbInfo.properties
database.properties 
```
1. 먼저 작성
2. - 한글 Encoding
				window -> preferences -> general -> contentType 클릭
				Text 확장 -> java Properties 파일 클릭
				Default Encoding을 UTF-8수정하고 꼭!!!! Update 클릭, 적용후 종료
3. database.properties 일반 파일 생성

4. 세부 내용

```

oracle.user=user01
oracle.password=user01
oracle.url=jdbc:oracle:thin:@15.165.158.213:1521:xe
oracle.driver=oracle.jdbc.driver.OracleDriver

```
* 주의 : 절대 공백을 띄우지 말것.
* 공백도 인식함

5. 하단 namespaces 슬롯에서 context추가
-- DB 연결정보가 있는 properties파일의 위치 알려줌
	<context:property-placeholder location="classpath:database/config/database.properties"/>

6. 키를 이용해서 database-context.xml수정
-- EL방식 사용
-- ex)  value="${oracle.user}"



---------------------------------------------------------------------------------

	1) mybatis 환경 설정 파일 등록(xml)
		- src/main/resources/database/config/mybatisConfig.xml : 파일명은 개발자 마음

			<!DOCTYPE configuration
				  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
				  "http://mybatis.org/dtd/mybatis-3-config.dtd"> 

	2) 3), 6) 에서 만든 database-context.xml에 다음 등록

	-- DB 연결정보가 있는 properties파일의 위치 알려줌
	<context:property-placeholder location="classpath:database/config/database.properties"/>

	-- Database에 로그인 후 연결객체를 관리하는 클래스의 객체 생성
	<bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" id="dataSource"> 
    데이터선언-패키지 id=참조변수명
		<property name="username" value="${oracle.username}"></property>
		<property name="password" value="${oracle.password}"></property>
		<property name="url" value="${oracle.url}"></property>
		<property name="driverClassName" value="${oracle.driver}"></property>
	</bean>
	
	-- Connection, sql문이 있는 xml파일의 위치, config 파일의 위치를 알려줌 
	<bean class="org.mybatis.spring.SqlSessionFactoryBean" id="sqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"></property>
		<property name="configLocation" value="classpath:database/config/mybatisConfig.xml"></property>
		<property name="mapperLocations" value="classpath:database/mappers/*Mapper.xml"></property>
	</bean>

	<bean class="org.mybatis.spring.SqlSessionTemplate" id="sqlSession">
		<constructor-arg name="sqlSessionFactory" ref="sqlSessionFactoryBean"></constructor-arg>
	</bean>


* Config.xml 써서 alias(별칭) 지정할거면 database-context.xml에도 찾을 수 있게 location을 속성으로 추가해줘야 함


### mapper

constructor-arg
1. 이름 (매개변수명)
2. 타입 
3. 인덱스

mybatis쓰는 이유
sql

db연결 데이터소스에서

DB연결- XML로 하고, 어노테이션으로 


```

- SQL(Query)문을 작성하는 곳
- 각각의 DB의 Table 마다 mapper 하나씩 생성
- Table - Mapper - DAO

1. Mapper 작성방법
	1) xml 태그의 스키마가 있어야 함

		<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

    org.mybatis -getting started-  Exploring Mapped SQL Statements
    에서 복붙가능

	2)  mapper 태그 작성과 namespace 속성
		- Mapper 파일이 여러개 생성, Mapper의 구분은 namespace의 값으로 구분 중복(x)
		- 값은 개발자 마음대로 작성
		 
		<mapper namespace="연결할 DAO의 FQDN(풀패키지명.클래스명)"></mapper>

	3) 쿼리 태그와 속성들
		- mapper 태그 내에 작성
		- 쿼리 태그 내에 쿼리문 작성(java 작성법과 동일)

			<select></select>
			<insert></insert>
			<update></updeate>
			<delete></delete>

		- 속성
		a. id     
			- mapper 내에서 다른 쿼리태그와 구분하는 용도, 중복(X), 개발자 마음대로 작성
			- 연결한 DAO의 메서드명과 동일하게 작성

		b. parameterType
			- ? 값을 넣어줄때 사용하는 Data의 DataType을 작성
			- FQDN(풀패키지명.클래스명) 

		c. resultType
			- SELECT 태그에만 있는 속성
			- SELECT의 결과물을 담을 데이터타입
			- SELECT의 결과물의 컬럼명과 DTO의 setter의 이름이 동일해야 함
			- SELECT의 결과물이 0개든, 1개든 , N개든 resultType은 DTO
	
		1) parameter 처리
			 - #{}
			 - DTO type이면 #{getter의 이름} 
			 - Wrapper type(Primitive Type) 또는 String Type 하나라면 #{DAO에서 넘겨주는 변수명}
			 - Getter Method가 없다
			 - #{}는 Data만 가능, 테이블명이나, 컬럼명 같은 것들은 사용 X 

			 - parameter는 한개든 여러개든 DTO에 담아서 전송

			 - Map , List
					-- Map  : #{key} 
					-- List : #{index번호}

		

2. DAO 작성법

	1) 멤버변수로 SqlSession을 선언하고 주입 : database-context.xml에 생성한 객체
	2) 멤버변수로 String namespace 선언 대입 : 연결하려는 mapper의 namespace속성의 값과 동일한 값, 끝에 . 추가
	3) 멤버메서드 생성
		 sqlSession.쿼리메서드명(namespace+"id명")             : Mapper 보내야하는 parameter가 없을 때
	   sqlSession.쿼리메서드명(namespace+"id명", 파라미터값)  : Mapper 보내야하는 parameter가 있을 때
		 - 파라미터값은 딱 1 개만 가능, 2개 이상 보낼 수 없음
		
		 a. select
		 sqlSession.selectOne()     : select의 결과물이 1개 일때 사용
		 sqlSession.selectList()    : select의 결과물이 N개 일때 사용 - List<> 타입으로 반환

			b. insert
			sqlSession.insert()       : int 가 반환

			c. update
			sqlSession.update()       : int 가 반환  

			d. delete
			sqlSession.delete()       : int 가 반환  


3. 동적 SQL
	- 제어문 제공

	1) 단일 if
		<if test="조건식"> </if>

	2) 여러개중 하나 선택
		<choose>
				<when test="조건식"></when>
				<when test="조건식"></when>
				<when test="조건식"></when>
				<otherwise></otherwise>
		</choose>

4. ResultMap
	- SELECT의 결과를 ResultType이 아니라 ResultMap에서 처리
	- SELECT의 결과의 컬럼명과 DTO의 변수명이 다를 때 사용
	- Join의 결과를 처리할 때 사용

	<select id="" parameterType="" resultMap="결과를 처리할 resultmap의 ID">
		join query문
	</select>

	<resultMap type="최종 return할 DTO" id="id명">
			<id column="select결과물의 컬럼명" property="retun할 DTO의 멤버변수명(setter 이름)"></id>   <!-- PK로 사용하는 column -->
			<result column="select결과물의 컬럼명" property="retun할 DTO의 멤버변수명(setter 이름)"></result>   <!-- PK를 제외한 나머지 -->
			
			<!-- 1:1 관계 association-->
			<association property="return할 DTO의 멤버변수명(setter 이름)" javaType="멤버변수의 Data type">
				<id column="select결과물의 컬럼명" property="retun할 DTO의 멤버변수명(setter 이름)"></id>   <!-- PK로 사용하는 column -->
				<result column="select결과물의 컬럼명" property="retun할 DTO의 멤버변수명(setter 이름)"></result>   <!-- PK를 제외한 나머지 -->
	 		</association>

			<!-- 1:N 관계 collection -->
			<collection property="return할 DTO의 멤버변수명(setter 이름)" javaType="멤버변수의 Data type" ofType="Generic Data type">
				<id column="select결과물의 컬럼명" property="retun할 DTO의 멤버변수명(setter 이름)"></id>   <!-- PK로 사용하는 column -->
				<result column="select결과물의 컬럼명" property="retun할 DTO의 멤버변수명(setter 이름)"></result>   <!-- PK를 제외한 나머지 -->
	 		</association>

	</resultMap>


```

### 데이터베이스 프레임워크

프레임워크 - 라이브러리+디자인 패턴
1. mybatis
2. hibernate
   
데이터베이스 서버에 연결하려면
프레임워크가 필요하다.
그게 mybatis나 hibernate.
- SQL문을 Java에서 분리하여 XML에 등록하고 연결해서 사용하기 위함

라이브러리 설치 후 
WEB-INF하위 spring폴더에서 spring bean configuration파일 생성 
->이름 database-context.xml파일

 만든 설정 파일 등록(web-xml에서)


DTO세터이름 컬럼명이 일치하는 애를 찾아서 DTO작성



rest pool방식?


### 요청의 필수

1. URL
2. method(요청 메서드 형식)
3. 쿠키

-------------
파라미터: 옵션
get: url뒤에 붙어서나감
구분하기위해?추가


### POST

* FORM 태그 하위의 disabled로 하면 파라미터로 못넘어감
* ID값 숨기고 파라미터 넘기는 법

1. hidden으로 가능
2. session 사용
-- 단 session값을 먼저 파라미터로 넘어온 DTO에 넣어야 함


### Configuration설정
위치 :
resources/database/config/database.properties

```

<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd"> 

	<configuration>
  	<typeAliases>
			-- 없는 클래스는 선언 하면 에러
  		<typeAlias type="풀패키지명.클래스명" alias="별칭(클래스명)"/>
  		<typeAlias type="com.iu.s1.bankbook.BankBookDTO" alias="BankBookDTO"/>
  		
  		<typeAlias type="java.lang.Long" alias="Long"/>
  	</typeAliases>
  
  </configuration>

``` 