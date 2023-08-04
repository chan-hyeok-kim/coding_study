//event 등록 1

function f1(){
    alert('click');
}

let btn1 = document.getElementById("btn1");
let btn2 = document.getElementById("btn2");

//event 등록 2
btn1.onclick = function(){
    f1();
};
// 이걸 콜백 함수라 함

// event 등록 3 -> 보통 이걸 가장 많이 씀
btn2.addEventListener("click",function(){
    let check = window.confirm("확인해주세요");
    console.log(check);
});

// confirm - 얼럿창에서 확인, 취소 버튼
// return으로 boolean을 줌



function f2(){
    console.log("keyup");
}

let input1 = document.getElementById("input1");

input1.addEventListener("keyup",function(){
    f2();
})




