

const ch1 = document.getElementById("ch1");
const p1 = document.getElementsByClassName("p1");
const btn = document.getElementById("btn");

btn.addEventListener("click",function(){
    if(ch1.checked){
        alert("약관동의")
    }else(
        alert("필수약관에 동의해")
    )
})

ch1.addEventListener("click", function(){
    for(p of p1){
        p.checked= ch1.checked
    }

})
const p2 = document.getElementsByClassName("p2");


 
for(let i=0; i<p2.length; i++){
    p2[i].addEventListener("click",function(){ 
        let result = true;
        for(p of p2){
           if(!p.checked){
           result = p.checked;
           break;
        }
     }
     ch1.checked = result;
     })
    }


  



// 1. 전체동의를 누르면 필수동의가  
// 2. 4개를 다누르면 전체동의가 되는거
// 3. 반대로 해제도되야함
// 4. 필수동의가 다되면 회원가입 얼럿창
