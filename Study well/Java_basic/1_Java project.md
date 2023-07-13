### JDK
Java
Developer
Kit

* JRE
* API
* JVM
* Compiler

Java


* HW : CPU, RAM, G/C, MB, POWER, 등등: 기계어 : 1,0(low level 언어)
* 사람에게 가까우면 high level 언어


### 테스트

```
public class Test{
    public static void main(String[] args){
            System.out.println("Hello World");
    }
}
```
컴파일러-> 위같은 코드를 기계어로 바꿔주는 역할
자바(.java)라는 파일을 읽어서 .class로 변환함


### 

이름 : varchar2(최대 4000byte) : 가변길이
         char(최대 2000byte) : 고정길이

나이 : number(전체자릿수, 소수점) (3,2) 

SELECT * FROM MEMBERS WHERE NAME=''


### 

CPU(중앙처리장치)

RAM(주기억장치) : 휘발성

SSD(보조기억장치) : 비휘발성

1024MB   -> 1G
1024KB   -> 1MB
1024Byte -> 1KB
8Bit     -> 1Byte
Bit -> 0, 1

###  

* Primitive
        1. 숫자형
                A. 정수형
                        1) byte  : 1byte
                        2) short : 2byte 
                        3) int   : 4byte
                        4) long  : 8byte
                        *int와 구별하기 위해 L작성
                        long i = 10L;
                B. 실수형
                        1) float : 4byte
                        2) double: 8byte
        2. 문자형
                        1) char  : 2byte
        3. 논리형
                        1) boolean : 1byte
                        * 1bit여도 되지만, 프로그램 최소단위 1byte라서 1byte다

* Reference(참조타입) - 선언된 변수는 4byte(stack영역에서)
* 실제 내용이 들어가는 heap영역에서는 데이터타입에 따라 바뀜
  (참조하는 주소값 있음)
        1. String(문자열)
           - String을 비롯한 참조타입들은 '=='으로 비교하면 맞지 않는 경우 있음(반드시 .equals()사용)

### java의 명명규칙
```
개발자는 클래스명, 변수명, 메서드명을 작명

1. 모든 이름은 이름만 보고 어떤 역할인지 추측가능
2. 클래스명의 첫글자는 대문자로 시작
3. 변수명의 첫글자는 소문자로 시작, 명사형식
4. 메서드명의 첫글자는 소문자로 시작, 동사형식
	- 끝에 () 가있으면 메서드, 없으면 변수

5. 두 단어 이상 합쳐서 이름을 만들 때
	ex) max + value

	1) Camel 표기법 Camel 표기법 Camel
		- 두번째 단어, 또는 뒤에 연결되는 단어에 첫글자를 대문자로 작성
		- ex) maxValueAge

	2) Snake 표기법. Snake. 표기법
		- 단어와 단어 사이에 _(언더바)로 연결
		- ex) max_value

6. 모든 이름은 숫자로 시작 할 수 없음

7. 특수문자는 '_', '$' 만 허용

8. 띄어쓰기 불가

9. 한글 가능하지만 쓰지 말것을 권장합니다.
```


