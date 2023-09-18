### STS4 다운

jar 파일 압축 해제

```
java -jar spring~~~

```

#### 1. 순수한 자바 객체(POJO)

```

* STS3와 다른 점
* 라이브러리 따로 추가할 필요 X
* XML도 없음
* jsp 없음 
* spring web에 json 라이브러리도 포함

```

#### version

```

jdk17이상 -> spring boot 3.대
그 이하 -> 2.대를 써야 한다

```

#### VO - Value Object
-- Legacy에서 쓰던 DTO(Data Transfer Object)대신 사용


#### @ResponseBody

-- jsp가 없기 때문에 json을 리턴시켜줘야 함.
-- 이 어노테이션을 사용하면 json객체로 생성해서 리턴한다.

#### 포트 충돌시

application.properties

```
server.port=82

```

#### JSP사용을 위한 이클립스 설치 후 라이브러리 추가

```

1. Tomcat을 사용 하는 것처럼 라이브러리 추가

		<!-- https://mvnrepository.com/artifact/org.apache.tomcat.embed/tomcat-embed-jasper -->
		<dependency>
		    <groupId>org.apache.tomcat.embed</groupId>
		    <artifactId>tomcat-embed-jasper</artifactId>
		    <!-- 버전 삭제 -->
		</dependency>

2. JSTL 추가
		<!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
		<dependency>
		    <groupId>javax.servlet</groupId>
		    <artifactId>jstl</artifactId>
		     <!-- 버전 삭제, 에러 발생시 버전 적용 -->
				<version>1.2</version>
		</dependency>


```


