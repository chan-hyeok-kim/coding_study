### 1. 주요 기초 문법 3가지

1. css import해서 스타일 설정 가능

ex) 
```
import './App.css';
```

 - 대신 html에서 쓰던 class는 className이라 쓰기


2. let등으로 선언한 변수의 데이터는 {}로 사용 가능.

```
let post = '블로그 제목란'
return {
<h4>{ post }</h4>
}

 - 데이터바인딩이라 한다
 - 원래 html에선
 - 'document.querySelector('h4').innerHTML=post;'을 의미
  
```


3. style={}

```

<h4 style={{color: 'red', fontSize: '16px'}}>블로그임</h4>

- style 직접 선언 시 {}사용.
- 안의 내용은 {}로 오브젝트 데이터임을 표시한 후, ','로 구분해서 적는다.
- 이때, 주의할 점은 font-size처럼 케밥 케이스 방식이 아니라 카멜 케이스 방식(fontSize)을 써야한다는 것이다

```

4. return()

 - return()안에는 병렬로 태그 2개 이상 기입 금지
 - 태그 하나로 시작해서 하나로 끝나야 한다

### 2. state

1. 사용법
```

let [a, b] = useState('남자 코트 추천');

a = 값 호출하는 변수명
b = state변경 도와주는 함수
{ a }

- state를 쓰는 이유
- 변수값 변경 시, html을 재렌더링
- 일반 변수는 html에 자동으로 반영 X
- 내용을 잘 바꾸지 않는 건 state를 사용할 필요 없음

*** 참고 ***
 - Destructuring 문법
 
 let num = [1,2];
 let [a, c] = [1,2];
 a=1, c=2가 됨

여기선 ['남자 코트 추천' , 함수]가 a,b에 대입됨
```

2. 변경

```
let [좋아요, 좋아요변경]=useState(0);

<span onClick={()=>{ 좋아요변경(좋아요+1) }}
>좋아요</span>
{좋아요}
 //좋아요를 누를 때마다 값이 1상승



 글제목[0] = '여자 코트 추천';
 //이렇게 쓸 수도 있지만 값이 영구적으로 수정되어서 되돌리기 힘들다

 let copy = 글제목;
 copy[0] = '여자 코트 추천';
 글제목변경(copy)
//이렇게 저장하는 게 옳다
// 단, 이렇게 해도 실행은 안된다
// array/object특징 때문에
// 화살표(주소)만 저장되었고, 
//copy랑 글제목의 주소는 똑같기 때문이다.

let copy = [...글제목];
 copy[0] = '여자 코트 추천';
 글제목변경(copy)
//따라서 이렇게 해줘야 함
// [...] 의미
// ... 괄호 벗겨주세요(기존 화살표 없앰)
//  [] 괄호 다시 씌움(새로운 화살표 부여)


```

 - 특징
 - 1. 기존 state= 신규state 의 경우 변경 안 해줌
 - 2. array/object특징
 - : 화살표(주소)만 저장됨

### error, warning

error  - 중요
warning - 무시 가능

eslint-disable
- warning 메세지 없애기

### component
1. 만드는 방법 : function바깥에 만들고, 영어 대문자
2. 이번 예시는 모달로 함.
ex)
```


function App(){
    return(
        <Modal></Modal>
    //이렇게 태그처럼 사용
    )
}

function Modal(){
  return(
   
    <>
    <div className='modal'>
      <h4>제목</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
    </>
    //참고1. 프래그먼트 문법
    //의미없는 <div> 대신에<>사용 가능
   )
}


const Modal=()=>{}
const Modal=function 함수명(){

}
    //참고2. 이렇게도 선언 가능
    //const사용 시 실수로 수정하면 에러 메시지 출력
```

3. 언제 컴포넌트 사용?
 - 반복적인 html 축약할 때
 - 큰 페이지들
 - 자주 변경되는 요소,UI들
 - 다른 컴포넌트에 선언된 state 사용 불가 

