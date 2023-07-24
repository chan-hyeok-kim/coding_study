### 

java:field
:property
html:attribute


### JDBC SPRING 발생 오류들
1. ParameterMapping{property='st_name, ..... jdbcType=null, numericScale=null}

st_name=#{st_name}값에 null이 들어갔단 뜻
왜 null이 되었는지 확인해야함

네트워크 페이로드 확인(파라미터값 넘어가는거)

2. Mapped Statements collection does not contain value for com.iu.main
: namespace나 id명이 잘못적힌 경우

3. 클래스명 중복 가능
- 그래서 패키지명을 씀

### member/myPage 수정
세션이 남아있어서 바로수정안됨
mypage가서 정보가 새로뽑아지게 해야함.


clob - 2GB

CLOB


### java내에서 라이브러리 적용안될때
스프링 우클릭 - Maven- update project

web.xml은 언제 실행되는가?
톰캣 실행시

DB연결해주는 녀석은?
datasource