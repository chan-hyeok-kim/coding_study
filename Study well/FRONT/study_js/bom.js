//참조변수명.메서드명

window.alert('쉬는 시간 입니다...');

//window 생략가능
alert('hello');
// location.href="https://www.naver.com";

let d1 = window.document.getElementById("d1");
let d2 = document.getElementById("d2");
let c2 = document.getElementsByClassName("c2");

let contents = d1.innerHTML;


console.log(contents);

d1.innerHTML = "Hello";

contents = d2.innerHTML;

// TEXT는 내용만 인식, HTML은 태그로 인식
console.log(contents);
// d2.innerHTML= '<input type="file">';

console.log(c2);
alert(c2);

for(let i=0; i<c2.length; i++){
    console.log(c2[i].innerText);
}
// 클래스선택자는 항상 유사배열. 한개일지라도

console.log('===================')


