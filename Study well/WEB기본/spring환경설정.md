### Spring-legacy 환경설정

- Project Facets
- dynamic web module 4.0
- java 11
- javascript 1.0

1. pom.xml세팅 
  - mybatis 
  - Spring
  - mybatis-spring
  - spring-jdbc
  - spring-test
  - 버전 수정 등등
```

<version>${org.springframework-version}</version>


  <!-- 버전 수정 -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc10 -->
		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc10</artifactId>
			<version>19.14.0.0</version>
		</dependency>

```


2. database-context.xml 세팅
3. src/main/resources/database/config/
  - 이 위치에 properties(로그인 정보)와 mybatisConfig.xml(alias)이 있어야 함
  
4. 한글 인코딩
  - web.xml에 아래 코드를 추가
  - contextConfigLocation의 param-value를 /WEB-INF/spring/*-context.xml로 수정
  - 아마 *이 root로 되어있을거임
```

<filter>
        <filter-name>encode</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>
    
    <filter-mapping>
        <filter-name>encode</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

```


### 옵션

1. 파일 세팅

  - root-context.xml에 아래 코드 추가
```

<bean class="org.springframework.web.multipart.commons.CommonsMultipartResolver" id="multipartResolver">
			<property name="defaultEncoding" value="UTF-8"></property>
			<!-- 전체 upload하는 파일의 총 크기 제한 단위 byte -->
			<property name="maxUploadSize" value="104857600"></property>
			<!-- upload하는 파일당 크기 제한 단위 byte -->
			<property name="maxUploadSizePerFile" value="10485760"></property>
		</bean>

```
  - pox.xml에 - commons-fileupload 추가
  - 