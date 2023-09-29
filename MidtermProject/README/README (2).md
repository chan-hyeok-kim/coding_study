# GDJ68_Sample
# 공유주방
## ilike kitchen
-----------------------------------------------------------------------------------------------
# 목차
*팀원
*기술 및 도구
*기능구현

## 팀원소개
-------------------------------------------------------------------------------------------------

>팀원:김찬혁
>예약,결제,환불,문자서비스(예약완료,공유)

>팀원:송윤호
>회원(로그인,회원가입,회원등급),사업자등록

>팀원:김민준
>마이페이지,게시판(공지사항,자주찾는 QNA)

>팀원:장재혁
>상품,지도

>팀원:황윤제
>문의,후기

## 기술 및 도구

|Category | Detail |
| ------ | ------ |
| FrontEnd | HTML5,JS,CSS3,JQuery |
| BackEnd | Java(JDK11),Servlet,Spring,Mybatis |
| OS | Windows 10,MacOS |
| Library&API |Jitpack,javax.mail,Mailsend,lombok,apache.commons,github.iamport,json,httpclient5,scribejava,AspectJ
||fileupload,Servlet,commons-logging,kakaoMap,kakaologin,slf4j,inject|
| IDE | DBeaver |
| Server | Tomcat(v9.0) |
| Document|ERDCloud|
|CI|Github|
|Database|MySQL|

## 기능구현
1.로그인&회원가입
    -일반회원가입후 로그인 가능
    -구글 이메일API사용
    -아이디,비밀번호,이름,전화번호 체크기능 등
    -SNS로그인(카카오,네이버)구현
    -사업자등록후 공간등록 가능  
    -파트너페이지에서 예약승인가능
    
1-1.마이페이지 
    -회원의 상세정보를 확인하고 수정가능
    -예약현황등을 확인가능
    -admin이 예약승인후 tossAPI로 결제가능
    
1-2아이디,비밀번호찾기
    -구글 이메일 API사용
    -가입시 기입한 이메일로 인증번호발송 
    -인증번호 입력시 임시비밀번호 출력
   
2.예약페이지
    -예약일자이전 예약내역은 예약 불가능하도록 처리
    -오늘날짜(노란색)표시 대여시간,사용인원 선택 가능

3.공지사항
    -notion을사용해 자주찾는질문으로이동
    -admin로그인시 공지사항 작성가능
    
4.상품
    -kakaoMapAPI로 지도 구현
    -ajax로 후기,문의 출력
