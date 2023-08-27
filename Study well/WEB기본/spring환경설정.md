### Spring-legacy 환경설정



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
  
4. web.xml 파일 설정
  - contextConfigLocation의 param-value를 /WEB-INF/spring/*-context.xml로 수정
  - 아마 *이 root로 되어있을거임
  - web.xml에 아래 코드를 추가(한글 인코딩)
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

2. lombok
 - pom.xml에 추가
```
	<!-- lombok -->
		<dependency>
  		<groupId>org.projectlombok</groupId>
  		<artifactId>lombok</artifactId>
  		<version>1.18.28</version>
  		<scope>provided</scope>
  	</dependency>

```
2-1.
 - getter,setter안될 경우 외부에서 다운 추가
 - 경로 : https://projectlombok.org/download
 - *주의* 버전은 pom.xml에 설치한 거랑 같은 거로
2-2. 추천
 - 또 다른 방법
 - STS를 끈 상태에서 lombok.jar 다운받은 후 실행(반드시 꺼야 함)
 - 자바 11이라 lombok은 1.18.4로 해줬다
@Data로 사용

### 버전 확인

1. java
  path
  java -version
  javac

2. sts확인
  - sts실행 후 초기 화면에서
  - workspace폴더 변경
  - STS설정 변경
      - encoding
      - 결과를 확인하는 웹브라우저 변경
      - Tomcat 연동 확인

3. DBeaver확인
    - 연결정보들 삭제
    - 새로운 연결 정보 등록

4. GIT
   - cmd에서 설치 확인: git --version

5. git-fork
   - File - Accounts에서 계정 삭제 
   - File - Preferences -> Git -> Global User Information
   - Local Repository 삭제

6. Git-hub 유저 변경 방법
  1) windows
  - Windows 검색 -> 자격증명 관리자
  - windows 자격증명 -> 일반자격증명 -> git 확인 후 변경 또는 삭제
  1) CMD
  git config --global user.name 유저명
  git config --global user.email 유저이메일

7. GitHub에서 사용하던 Repository를 Clone
   1) GitHub에서 Clone할 Repository 주소 복사
   2) Git-fork -> file -> Clone
   3) Parent Folder 확인 
   4) Test Connection 실행
   5) STS
       - File -> import
       - Projects from Git(with smart import)
       - Existing local repository
       - Add로 추가(Clone한 폴더의 최상위 폴더 선택)
       - Import할 이름을 선택 후 -> next -> finish

8. import 실행 안될 시 체크사항 

```

- Project Facets
- dynamic web module 4.0
- java 11
- javascript 1.0

```

