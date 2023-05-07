### Date 클래스
* 날짜를 표현하는 클래스
* Date는 객체 간 날짜 정보 주고받을 때 매개 변수나 리턴 타입으로 주로 사용
* ctrl+shift+O로 java.util.date 임포트해야함
```
Date now = new Date();
```
* 원하는 날짜 형식의 문자열 얻기 위해 java.text 패키지의 SimpleDateFormat 클래스와 함께 사용
```
SimpleDateFormat sdf = SimpleDateFormat("yyyy년 mm월 dd일 hh시 mm분 ss초");
```
* format() 메소드 호출
```
String strNow = sdf.format(now);
```

### Calendar 클래스
* 달력을 표현한 클래스로 운영체제의 날짜 및 시간 기준으로 다양한 정보 얻을 수 있음
* 추상 클래스이므로 new연산자 사용하여 인스턴스 생성 불가
* getInstance()메소드 이용하여 Calendar 하위 객체 얻을 수 있음
```
Calendar now = Calendar.getInstance();
```
```
int year = now.get(Calendar.YEAR); //연도를 리턴
int month = now.get(Calendar.MONTH) + 1; 
//월을 리턴. 이 경우 get이 0~11값 리턴하기 때문
int amPm = now.get(Calendar.AM_PM); //오전/오후를 리턴
```
