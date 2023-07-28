### Stream : 실, 개천

ex) 클라이언트에서 이미지 파일을 서버로 보내려고 한다
파일을 이진수로 바꿨다가 다시 파일로 조립해야 함.
이 과정에서
출력을 OutputStream
입력을 InputStream이라 함


### 파일 업로드

```


- Client 컴퓨터에 저장되어 있는 파일(이미지, 동영상, 문서등)을 Server컴퓨터로 전송

1. 준비사항
	1) Libarary 다운(pom.xml)
		- commons-fileupload
		<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
		<dependency>
		    <groupId>commons-fileupload</groupId>
		    <artifactId>commons-fileupload</artifactId>
		    <version>1.4</version>
		</dependency>

	2) form 태그의 method형식은 post, enctype="multipart/form-data"로 변경
			- 첨부파일이 없는 폼은 enctype은 기본으로 설정
            - 첨부파일은 반드시 multipart넣어준단
	3) Server에서 여러개의 파일조각들을 하나로 합쳐주는 역할을 하는 객체(multipartResolver객체)를 생성

		- ***-context.xml
		<bean class="org.springframework.web.multipart.commons.CommonsMultipartResolver" id="multipartResolver">
			<property name="defaultEncoding" value="UTF-8"></property>
			<!-- 전체 upload하는 파일의 총 크기 제한 단위 byte -->
			<property name="maxUploadSize" value="10485760"></property>
			<!-- upload하는 파일당 크기 제한 단위 byte -->
			<property name="maxUploadSizePerFile" value="5242880"></property>
		</bean>
		
		

	4) form 태그에 파일 태그 추가
			<input type="file" name="photo" id="photo">

	5) Controller의 메서드
		- 매개변수로 MultipartFile 선언
		- 변수명은 파라미터 이름과 동일
		- 같은 변수명(파라미터로) 여러개의 파일을 업로드 할 때는 Multipart [] 선언


    6)MultipartFile로 받아주고
     1. HDD 파일에 저장
        a. 어디에 저장할 것인가(/resources/**)
	    b. 어떤 이름으로 저장할 것인가(파일명 중복 X)
            - 시간 이용(Calendar)
			- API 이용 => UUID.randomUUID().toString()
 
     2. 파일을 저장하는 법 2개
		A. Spring에서 제공하는 API. FileCopyUtils메서드
		FileCopyUtils.copy(multipartFile.getBytes(), file);
	
		B. MultipartFile의 transferTo메서드
		multipartFile.transferTo(file);
 



```

여기서 문제가 또 발생
 * 파일 저장하려면 DB가 필요
 * 누가 보냈는지 식별해야 하기 때문
  
```

- 따라서 테이블을 만든 후 임의의 키(인공키)를 만들어줘야 한다

외래키의 조건 unique나 primary key
- 데이터 지울 땐 자식을 지우고 부모를 지워야함
 
RDBMS
(relational database management system)

jdbc - java언어를 db사이에서 통역해줌


NOSQL(대용량) : MongoDB,Cassandra,HBase



```



* 자바의 byte타입(이진데이터) 
  - 파일을 이용할 때 사용


### API 파일 클래스

```


1. java.io.File
- HDD의 파일 또는 폴더의 정보를 다루는 클래스

File file = new File("파일이나 폴더의 경로명");
File file = new File("부모 폴더의 경로명", "자식 폴더 명이나, 파일명");
File file = new File(폴더의정보를 알고있는 File객체, "자식 폴더 명이나, 파일명");

- exists()       : 파일이나 폴더가 존재하면 true, 없으면 false
- isDirectory()  : 디렉토리라면 true, 아니면 false
- isFile()       : 파일이면 true, 아니면 false    

- mkdir()        : 폴더 생성, 부모 폴더가 없다면 실패
- mkdirs()       : 폴더 생성, 부모 폴더가 없으면 부모폴더 포함해서 자식 폴더 까지 생성

- delete()       : 파일 또는 폴더 삭제, 폴더는 내부가 비어 있어야만 삭제 가능

- list()         : 폴더 내에 모든 파일과 폴더들의 이름을 String []로 리턴
- listFiles()    : 폴더 내에 모든 파일과 폴더들을 File []로 리턴

- length()       : 파일이나 폴더의 크기

2. java.io.FileWriter
- HDD의 파일에 내용을 작성
- FileWriter(파일의 경로명, boolean)
		true - 동일한 파일명이 있을 경우 기존 내용 뒤에 이어 쓰기
		false - 동일한 파일명이 있을 경우 기존 내용 제거 하고 새로 작성

- write("작성할 메세지")
- flush()      : buffer를 강제로 내보내기

3. java.io.FileReader
- HDD의 파일 내용을 읽어 오기
- FileReader(파일의 경로명)
- BufferedReader(FileReader)
  readLine()


```


```

  File file = new File("C:\\study\\study.txt");
  file = new File("C:\\study", "study.txt");

```  


### 로그인 후 My Page에서 출력하기



1. mapper에서 resultmap선언
2.  resultMap의 id와 result 선언 후 


```
  <id column="" property="">
```

3. 1:1이면 association 선언

```
<association property="" javatype="">
<id>
<result>
</association>
```

4. 1:N이면 collection 선언
```
<collection property="" javatype="" oftype="">
<id>
<result>
</collection>
```





