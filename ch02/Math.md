# Math 클래스
* 수학 계산에 사용
  
| 메소드 | 설명 | 예제 코드| 리턴값|
|:---:|:---:|:---:|:---:|
|int abs(int a)|절대값|int v1 = Math.abs(-5);|v1=5|
|double ceil(double a)|올림값|double v4 = Math.ceil(-5.3)|v4=-5.0|
|double floor(double a)|버림값|double v6 = Math.ceil(-5.3);|v6=-6.0| 
|int max(int a, int b)|최대값|int v7 = Math.max(5,9);|v7=9|
|int min(int a, int b)|최소값|int v9 = Math.min(5,9);|v9=9|
|double random()|랜덤값|double v11 = Math.random();|0.0<=v11<1.0|
|double rint(double a)|가까운 정수의 실수값| double v12 = Math.rint(5.3);|v12=5.0|
|long round(double a)|반올림값|longv14 = Math.round(5.3);|v14=5
* Math.random() 메소드는 0.0 이상 1.0미만 범위에 속하는 하나의 double 타입 값 리턴
>활용: 1부터 10까지 임의의 정수 난수 얻기
```
0.0 * 10 <= Math.random() * 10 < 1.0 * 10
(int) (0.0 * 10) <= (int)(Math.random() * 10) < (int)(1.0 * 10)
(int) (0.0 * 10)+1 <= (int)(Math.random() * 10)+1 < (int)(1.0 * 10)+1
int num = (int)(Math.random() * 10) + 1;
```
>주사위 던지기
```
int num = (int)(Math.random() * 6) + 1;
```
