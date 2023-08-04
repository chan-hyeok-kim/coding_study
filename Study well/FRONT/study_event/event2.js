

const n = document.getElementById("in");
const out = document.getElementById("out");

n.addEventListener("keyup", function(){
    console.log(n.value);
    out.innerText = n.value;
})

let btn = document.getElementById("btn");


btn.addEventListener("click",function(){
     if(n.type=="text"){
     n.type= "file";
     }else{
      n.type= "text";
     }    
})

let clear = document.getElementById("clear");

clear.addEventListener("click",function(){
    n.value=null;
    out.innerText="";
})



let b1 = document.getElementById("b1");
const p1 = document.getElementById("p1");
const p2 = document.getElementById("p2");
const result = document.getElementById("result");
const c1 = document.getElementsByClassName("c1");


b1.addEventListener("click", function(){
    for(c of c1){
       if(c.selected){
          if(c.innerText=='+'){
            result.value = p1.value*1+p2.value*1;
          }else if(c.innerText=='-'){
            result.value = p1.value-p2.value;
          }else if(c.innerText=='*'){
            result.value = p1.value*p2.value;
          }else if(c.innerText=='/'){
            result.value = p1.value/p2.value;
          }else{
            result.value = p1.value%p2.value;
          }
       
          break;
       }
    }
})


const c2 = document.getElementsByClassName("c2");

// addEventListener는 엘리먼트에만 걸 수 있음

for(c of c2){
    c.addEventListener("click",function(){
    console.log(this.getAttribute("data-num"));
    alert(this.getAttribute("data-num"));
})
}

const btn3 = document.getElementById("btn3");
const ch = document.getElementsByClassName("ch");

btn3.addEventListener("click",function(){
    ch[3].checked=true;
})



