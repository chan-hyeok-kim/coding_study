### java.lang.package


```

1. java.lang.Object
	- 모든 클래스의 부모(super)
	- 모든 클래스는 Object 클래스를 상속(확장) 함
	- extends 코드가 없는 클래스는 extends Object가 자동으로 입력
	- 모든 클래스는 Object 타입이다

	주요 메서드
	1) equals   : 자기자신의 참조변수의 값과 매개변수로 받은 참조변수의 값이 같은지 판별
	2) toString : 객체의 주소를 문자열로 반환(클래스명@주소)
							: 참조변수를 출력시도하면 자동으로 toString 호출

  - 주요 메서드들을 필요하다면 오버라이딩 해서 사용

2. java.lang.String
	- 문자열, 문자배열
	- 문자열을 변형, 문자열 중 일부분의 데이터 추출 등

	주요 메서드 
	1) charAt(int index)     : 문자열에서 해당 인덱스 번호의 문자(char)를 반환
	2) indexOf(int ch)       : 제공하는 문자 또는 문자열의 인덱스 번호를 반환
														 없으면 -1 반환
														 찾는 순서는 앞에서부터 뒤로 
     indexOf(int ch, int fromIndex) : fromIndex 번호 부터 찾기

	3) lastIndexOf()           : indexOf와 같지만 찾는 순서가 뒤에서 부터 앞으로

	4) length()               : 문자열의 길이를 반환

	5) isEmpty()               : 문자열의 길이가 0이면 true, 아니면 false 리턴

	6) equals()                : 문자열이 서로 같은지 비교(Overring)

	7) replace()               : 문자 또는 문자열을 변환 하고 리턴

	8) subString()             : 문자열에서 원하는 부분만 잘라 낼 때
			- beginIndex           : 시작인덱스번호 이상 끝까지
			- beginIndex, fromIndex : 시작 인덱스 번호 이상 fromIndex 미만 까지 
	9) split()                  : 특정 기준으로 문자열을 분리 할 때

	10) toCharArray()           : 문자열을 문자배열로 반환

	11) toLowerCase()           : 문자열을 모두 소문자로 바꿔서 반환

	12) toUpperCase()           : 문자열을 모두 대문자로 바꿔서 반환

	13) trim()                  : 문자열의 앞뒤 공백(space)를 모두 제거하고 반환

	14) valueOf()               : 다른 데이터타입들을 String으로 변경하고 반환
	    - primitive 타입을 문자열로 변경
				a. valueOf() 메서드 사용
				b. 연결연산자 사용 : String + primitive ex) "abc"+10



3. java.lang.StringBuffer
	- 여러개의 문자열을 연결해서 하나의 문자열로 만들 때
	- "abc" "def" -> "abc"+"def"
	- String은 불변
	- StringBuffer는 String이 아님
	- StringBuffer의 결과물을 String에 대입할 때 toString 메서드 이용

4. Wrapper class
	- 대명사
	- 감싼다라는 의미
	- primitive type을 reference type으로 변경
	- 형변환 X, 다형성

	char       ->        Character
  byte       ->        Byte
  short      ->        Short
  int        ->        Integer
  long       ->        Long
  float      ->        Float
  double     ->        Double
  boolean    ->        Boolean

* 클래스명.parse클래스명("문자열") : 문자열을 primitive type으로 변경

primitive -> reference        : Auto Boxing
int n1=10;
Integer n2 = n1;

reference -> primitive        : Auto UnBoxing
n1 = n2;

* auto는 같은 계열만 가능 : int <-> Integer, long <-> Long...

5. java.lang.Math
	- 수학에 관련된 메서드
	- 클래스 변수와 클래스 메서드로 구성



```


### java.util package

```

1. java.util.StringTokenizer
	- 하나의 문자열을 여러개로 분리 (파싱, parsing, String의 split 메서드)
	- 분리된 문자열을 토큰(Token)이라 함
	- 생성자 매개변수
			1) 분리 할  문자열
			2) 분리 기준(delim)

	- new StringTokenizer("자를문자열", "자를 기준"
	- hasMoreTokens
	- nextToken

2. Collection Framework

- 주요 인터페이스
1) java.util.List
	- 순서가 유지
	- 값의 중복을 허용
	- 배열 기반(index 사용)

	- add(Object e)            : 새로운 데이터를 마지막 부분에 추가
	- add(int index, Object e) : index번호에 데이터를 삽입
	- get(int index)           : index번호의 element(요소)를 리턴
	- size()                   : 요소의 갯수를 리턴(배열의 length)
	- remove(int index)        : index 번호의 요소를 삭제
	- clear()                  : 모든 요소를 삭제
	- set(int index, Object e) : index 번호의 요소를 e로 수정
	
	- ArrayList, LinkedList,... 

2) java.util.Set
	- 순서가 유지 X
	- 값의 중복을 허용 X
	- get X

	- List 와 비슷한 메서드(add. remove, clear...)
	//Set의 Data들을 Iterator 형식으로 변경
	- iterator()

	- HashSet


*위의 List,Set과 아래의 Map은 결이 다르다.

3) java.util.Map
	- Key와 Value로 구성
	- 순서가 유지 X
	- Key 중복 X, Value 중복 허용

	- put(K, V)        : Key로 Value를 추가, Key가 중복이면 수정의 의미
	- get(K)           : Key로 Value를 반환
	- clear()          : 전체 요소 삭제
	- remove(K)        : 일치하는 Key 삭제, 해당 키의 Value도 삭제
	- remove(K, V)     : Key와 Value 둘다 일치해야 삭제
	- containsKey(K)   : Key가 Map에 있으면 true, 없으면 false
	- containsValue(V) : Value가 Map에 있으면 true, 없으면 false 
	- keySet()         : Key를 Set 인터페이스 타입으로 변경 

	- HashMap


4) Iterator(Enumeration)
	- 반복형, 열거형
		Iterator<Integer> it = hashSet.iterator();
		
		while(it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}


3. Generic
	- 데이터타입의 안정성을 보장
	- 타입의 변경이나 검사등에 노력을 줄임
	- 클래스나 메서드 등 에서 사용할 내부 데이터타입을 컴파일시 미리 지정하는 방법


4. java.util.Random
	- 랜덤한 수를 반환

	- netxtDouble, nextFloat : 0.0 ~ 1.0 미만의 실수를 반환
	- nextInt, nextLong      : 표현 할 수 있는 범위 내의 정수를 반환
	- nextInt(int b)         : 0 이상 b미만의 정수를 반환


5. java.util.Calendar
	- 날짜, 시간을 다룰 때 사용
	- Calendar ca = Calendar.getInstance();

	- get(int field)            : 각 변수에 맞는 시간이나 날짜를 반환
												   	  : 0 -> 1월, 1->2월, ... 11 -> 12월 	
	- getTimeInMillis()         : 현재 시간을 밀리세컨즈로 반환

	- set(int field, int v)     : 각 변수에 해당하는 값으로 설정
	- setTimeInMillis(long mil) : 밀리세컨즈를 시간으로 변경

	- getTime()                 : 현재 시간을 을 Date 객체로 반환

	- roll(int field, int amount) : 해당 필드에 amount 만큼 흐르게함, 다른 필드에 영향 X
	- add(int field, int amount)  : 해당 필드에 amount 만큼 흐르게함, 다른 필드에 영향 O
	
6. java.util.UUID
	- 중복 되지 않는 문자열 생성
	- Universal Unique ID
	
	UUID.randomUUID().toString()




```


