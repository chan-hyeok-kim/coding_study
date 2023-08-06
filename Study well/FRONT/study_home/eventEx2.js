
const frm = document.getElementById("frm");
const id = document.getElementById("id");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const names = document.getElementById("name");
const email = document.getElementById("email");
const birth = document.getElementById("birth");
const btn = document.getElementById("btn");


const msg1 = document.getElementById("msg1");
const msg2 = document.getElementById("msg2");
const msg3 = document.getElementById("msg3");
const msg4 = document.getElementById("msg4");
const msg5 = document.getElementById("msg5");
const msg6 = document.getElementById("msg6");


let resultCheck = [false, false, false, false, false, false];

btn.addEventListener("click", function(){
    if(resultCheck.includes(false)){
        alert("필수 내용들은 입력해주세요");
    }else{
        btn.type="submit";
        frm.submit;
    }


    
})


id.addEventListener("blur", function(){
    if(id.value==''){
       msg1.innerHTML="아이디를 입력해주세요";
       msg1.className="f";
       resultCheck[0]= false;
    }else{
       msg1.innerHTML="양호"
       msg2.className="s";
       resultCheck[0]= true;
    }
})

pw.addEventListener("blur", function(){
    if(pw.value.length<6 || pw.value.length>11){
        msg2.innerHTML="비밀번호는 6자 이상 12자 미만입니다";
        msg2.className="f";
        resultCheck[1]= false;
    }else{
        msg2.innerHTML="양호";
        msg2.className="s";
        resultCheck[1]= true;
    }
})

pw2.addEventListener("blur", function(){
    if(pw2.value!=pw.value){
        msg3.innerHTML="비밀번호가 일치하지 않습니다";
        resultCheck[2]= false;
    }else{
        msg3.innerHTML="비밀번호 일치"
        resultCheck[2]= true;

    }
})

names.addEventListener("blur", function(){
     if(names.value==''){
        msg4.innerHTML="이름을 입력해주세요";
        resultCheck[3]= false;
     }else{
        msg4.innerHTML="양호"
        resultCheck[3]= true;
     }
})

email.addEventListener("blur", function(){
    if(email.value==''){
       msg5.innerHTML="이메일을 입력해주세요";
       resultCheck[4]= false;
    }else{
       msg5.innerHTML="양호"
       resultCheck[4]= true;
    }
})

birth.addEventListener("change", function(){
    if(birth.value==''){
        msg6.innerHTML="생일을 입력해주세요";
        resultCheck[5]= false;
    }else{
       resultCheck[5]= true;

    }
})
