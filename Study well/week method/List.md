# 자료 구조
* 자료 구조란 데이터를 표현하고 저장하는 방법
* 크게 단순 구조(정수, 실수, 문자열, 문자), 선형 구조(리스트, 스택, 큐, 덱), 비선형 구조(트리, 그래프), 파일 구조(순차파일, 색인파일, 직접파일)로 나뉨

* 그중 이번 시간에는 리스트(List)에 관해서 배울 것임
  
### List란
* 자료를 순서대로 저장하는 자료구조
* 선언 방법
```
 List<자료형> 리스트명 = new ArrayList(or LinkedList)<자료형(생략가능)>();

 import java.util.ArrayList;  // ArrayList 선언 시

import java.util.LinkedList; // LinkedList 선언 시
import java.util.List;
```
* 예시
```
List<String> listA = new ArrayList<String>();
```
* '<>'은 제네릭이라고 함

## List의 주요 기능
1. 삽입: List.add(값);
2. 중간 삽입: List.add(index, value); 
   index: 중간에 넣을 인덱스(배열 인덱스), value: 중간에 넣을 값. (중간에 값을 넣을 경우 중간에 넣은 값 이후에 값들은 한 칸씩 밀리게 됩니다.)
3. 치환: List.set(index, value); : 중간 삽입과 비슷하게 index는 치환할 값 자리에 인덱스이고 value는 치환할 자리에 값이다.
4. 삭제: List.remove(index); : 인덱스 위치에 있는 값을 삭제한다.
5. 전체 삭제: List.clear(); 모든 요소를 삭제
6. 출력: List.get(index) : 인덱스 위치에 있는 값을 출력
7. 사이즈: List.size() : 리스트에 크기를 알 수 있다.

## ArrayList
* ArrayList는 요소를 순차적으로 추가하는 게 특징
* 배열과 매우 유사하며 배열은 배열 선언 시 크기도 같이 지정해 줘야 하는 반면, ArrayList는 크기를 지정하지 않아도 되며 추가될 때마다 크기가 정해진다

## Collections.sort()메서드
* ArrayList는 Collections 클래스의 sort()메서드를 사용하여 정렬할 수 있다
* import java.util.Collections;

```
Collections.sort(list)   //오름차순
Collections.sort(list, Collections.reverseOrder());        //내림차순
Collections.sort(list, String.CASE_INSENSITIVE_ORDER);     //대소문자 구분없이 오름차순
Collections.sort(list, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));               //대소문자 구분없이 내림차순

```

# Arrays.sort()
* import java.util.Arrays;
```
Arrays.sort(list);    //오름차순
Arrays.sort(list,2,5);   //특정 인덱스 범위
```
# List.sort()
