## FNC엔터테인먼트

### 1. **Notice 개요**

```

> 참고 사이트 : https://www.fncent.com/b/notice
> 
> 목적 : DB 설계 및 Spring 작업 메커니즘에 익숙해지기 위함

스키마 설계에 앞서
> 테이블명 : BOARD
> home은 "board/list"로 한다
> 보조 : ER다이어그램

ERD 주소 : https://www.erdcloud.com/d/GzFoRLovxHPkRAaWA

``` 


<br>

### 2. DB 설정


TABLE | BOARD ||||||
--|--|--|--|--|--|--
대치항목 | 번호 | 작성자 | 제목 | 날짜 | 조회수 | 내용
COLUMN | BOARDNUM | BOARDWRITER | BOARDNAME | BOARDDATE | BOARDHIT  | BOARDCONTENTS
TYPE | NUMBER(4) | VARCHAR2(10) | VARCHAR2(100) |DATE | NUMBER(5) | CLOB
CONSTRAINT | PRIMARY KEY ||||
SEQUENCE | BOARD_SEQ  ||||



<br>

### 3. CRUD 작업

 목록  |  URL  | redirectURL| 메서드 형식  | 파라미터로 필요한 값 | JSP 
--|--|--|--|--|--
List   | "board/list" | | get |   | list.jsp  
Detail | "board/detail" | | get | boardnum | detail.jsp
Insert | "board/add" | "board/list" | get,post | boardnum, boardwriter, boardname, boarddate, boardhit, boardcontents | add.jsp
Update | "board/update" | "board/detail" | get,post | boardnum, boardwriter, boardname, boarddate, boardhit, boardcontents| update.jsp
Delete | "board/delete" |"board/list" | get | boardnum | list.jsp

* Update - redirect시 detail로 가려면 boardnum필요  

