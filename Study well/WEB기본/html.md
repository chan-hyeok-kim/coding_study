### HTML

```

1. HTML (Hyper Text Markup Language)
	- 태그의 순서를 지정
	- 뼈대를 만들기
	- 정적인 언어

2. CSS(Cascading Style Sheets)
	- 스타일에 관련된 언어
	- 칼라, 크기, 위치, 등등을 조정
	- 정적인 언어

3. JavaScript
	- 동적인 언어
	- 이벤트

```


### 입력태그

```

- 주로 form 태그 내에서 사용
- form 태그 없이 사용도 가능 (JavaScript와 같이 사용)
- 사용자로 부터 데이터를 입력 받는 태그
- type이라는 속성값에 따라서 입력 양식이 달라짐

1. input
	<input type="값">

	1) type의 종류
		a. text     : 짧은 Text에 주로 사용
		b. password : 입력 되는 데이터를 * 로 표시
		c. file     : 파일 업로드시 파일을 선택 
		d. date     : 날짜 입력 또는 선택
		e. number   : text와 비슷 , 숫자만 입력
		f. email    : 이메일 양식으로 입력
		g. tel      : 전화번호 양식으로 입력
		h. hidden   : 사용자에게는 보이지 않고 서버로 전송
		i. radio    : 여러개 중에서 하나를 선택 할 때
								: 그룹 별로 name 속성의 값을 일치시켜야 함
								: Server로 전송시 입력 할수 없으니 개발자가 미리 value에 속성에 값을 대입
		j. checkbox : 여러개중에서 다중 선택 
								: 나머지는 Radio와 거의 같음


2. textarea
	- 비교적 긴글을 입력할 때 사용
	<textarea rows="" cols=""></textarea>

3. select
	- 여러개 중에서 하나를 선택
	<select name="">
		<option value="">값1</option>
		<option value="">값2</option>
		<option value="">값2</option>
	</select>

4. 공통속성
	1) value      : 입력 태그에 입력된 값이 저장되는 속성
								  파라미터의 값으로 서버로 전송	
	2) name       : 파라미터의 이름이 됨

	3) readonly    : 입력(선택)불가, 읽기만 가능, 서버로 전송 가능

	4) disabled    : 입력(선택)불가, 읽기만 가능, 서버로 전송 불가

5. 입력 태그별 속성
	1) 사용자 타이핑하는 태그
			a. placeholder  : 입력양식에 hint 제공

```


### button

```

- Button을 생성하는 방법 크게 4(6) 가지

1. input 태그의 type속성으로 button
	- 아무런 기능이 없는 순수한 button
	- JavaScript와 같이 사용
	- value 속성의 값이 버튼의 이름

2. input 태그의 type속성으로 reset
	- 입력폼에 입력 된 내용을 초기화
	- value 속성의 값이 버튼의 이름

3. input 태그의 type속성으로 submit
	- 입력폼에 입력 된 내용을 form 태그의 action의 URL로 요청을 발생
	- submit event가 내장
	- value 속성의 값이 버튼의 이름

4. button 태그
	<button>버튼이름</button> 
	type 속성의 값을 변경해서 1,2,3 기능을 전부 가질 수 있음
	type : button, reset, submit

5. a 또는 일반 태그
	- a 또는 일반 태그 css를 이용해서 버튼 처럼 보이게 함
	- 효과를 주기 위해 JavaScript를 같이 사용

6. input 태그의 type 속성으로 image
	<input type="image" src="이미지경로" value="버튼의이름">


-----------------------------------------------------------
form 태그 안에 button 들이 있으면 각각 고유의 기능(Event)이 실행

form 태그 바깥에 button들이 있으면 아무런 기능이 없는 button이 됨
JavaScript를 사용


```



### Semantic 태그

```

- HTML 5 에서 추가
- 의미가 있는 태그(검색엔진)
- Layout 구조 용


<header></header>
<nav></nav>
<section></section>
<article></article>
<footer></footer>
<aside></aside>



```