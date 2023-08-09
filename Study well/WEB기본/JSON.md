### 제이슨

* 속성 값의 쌍 형태 (key=value)
* 독립형 언어
* 비동기 통신

1. 주로 언제 사용하는가?
* 다른 서버와 통신할 때
* 우리 서버와 통신할 때는 잘 안 쓰임
    - 왜?
    - 

2. 추가 도구들
* pretty json 활용하면 눈이 편함
* fake json 

**참고**
파라미터가 URL처럼 들어가는 걸 WREST형식이라 함  

3. ajax로 json쓰기
header 작성 예시 

```
fetch(" url ", {
  method
  body
  headers:{ " : " 또는 "   " : "  " 형식}

})

```



```

JavaScript Object Notation


참조
https://developer.mozilla.org/ko/docs/Learn/JavaScript/Objects/JSON


JavaScript
	1) JSON 형식의 문자열을 JSON 객체로 변환
		 JSON.parse("문자열");

	2) JSON 객체를 JSON형식의 문자열로 변환
		 JSON.stringify(JSON객체)

형태 : key:value
{key:value, key:value}      ->자바에서 object
[{key:value, key:value}, {key:value, key:value}]  ->자바에서 object[]
[v1,v2,v3]  

숫자, boolean, string
1,   false, 'test'

[숫자, boolean, string]


```