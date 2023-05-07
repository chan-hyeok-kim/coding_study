# Wrapper(포장) 클래스

### 1. 포장 객체
* 기본 타입의 값을 내부에 두고 포장
* 포장하고 있는 기본 타입 값은 외부에서 변경할 수 없음
* byte, char, short, int, long, float, double, boolean 기본 타입 값 갖는 객체

### 2. Boxing과 Unboxing
* 박싱: 기본 타입의 값을 포장 객체로 만드는 과정
* 언박싱: 포장 객체에서 기본 타입의 값을 얻어내는 과정
  
|기본 타입의 값을 줄 경우|문자열을 줄 경우|
|:---:|:---:|
| Byte obj = new Byte(10);| Byte = new Byte("10");|

* 생성자 이용하지 않고 각 포장 클래스마다 가진 정적 valueOf() 메소드 활용
```
Integer obj = Integer.valueOf(1000);
Integer obj = integer. valueOf("1000");
```
* '기본 타입 이름 + Value()'메소드 호출하여 언박싱

|기본 타입의 값을 이용|
|:---:|
|byte num = obj.byteValue();|

### 3. 자동 박싱과 언박싱
* 포장 클래스 타입에 기본값이 대입될 경우 자동 박싱 발생
```
Integer obj = 100; //자동 박싱
```
* 기본 타입에 포장 객체가 대입되는 경우 및 연산에서 자동 언박싱 발생
```
Integer obj = new Integer(200);
int value1 = obj;                    //자동 언박싱
int value2 = obj + 100;              //자동 언박싱
```

### 4. 문자열을 기본 타입 값으로 변환
* 포장 클래스로 문자열을 기본 타입 값으로 변환
* 'parse+기본 타입 이름'정적 메소드

|기본 타입의 값을 이용|
|:---:|
|byte num = Byte.parseByte("10");|
|boolean bool = Boolean.parseBoolean("true");|

### 5. 포장 값 비교
* 포장 객체는 내부 값 비교하기 위해 == 및 !=연산자 사용하지 않는 것이 좋음
아래 연산 결과 false
```
Integer obj1 = 300;
Integer obj2 = 300;
System.out.println(obj1 == obj2);
```
* 박싱된 값이 아래 표에 나와 있는 범위의 값이 아닌 경우 언박싱한 값 얻어 비교해야 함

|타입|값의 범위|
|:---:|:---:|
|boolean|true,false|
|char| \u0000~\u007f|
|byte, short, int|-128~127|

*이 범위 안의 있는 값들은 객체를 1개만 만들기 때문에 true가 나온다.
*obj1.equals(obj2)도  true