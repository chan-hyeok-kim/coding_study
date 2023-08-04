const input1 = document.getElementById("input1");
const input2 = document.getElementById("input2");
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");

btn.addEventListener("click", function(){
    // 이벤트 강제 실행
    // 선택자.이벤트명();
    input1.focus();
});

input1.addEventListener("change", function(){
    console.log("change");
});

input2.addEventListener("focus",function(){
    console.log("focus");
})

input2.addEventListener("blur",function(){
    console.log("blur");
})