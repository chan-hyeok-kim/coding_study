const d1 = document.getElementById("d1");
const btn =  document.getElementById("btn");
const h1 = document.getElementsByTagName("h1");

btn.addEventListener("click", function(){
    // d1.innerHTML='<input type="button" value="BUTTON" id="b1">';
    let b = document.createElement("input");
    let t = document.createAttribute("type");
    t.value = "button";
    b.setAttributeNode(t);
    t = document.createAttribute("value");
    t.value= "BUTTON";
    b.setAttributeNode(t);
    t = document.createAttribute("id");
    t.value= "b1";
    b.setAttributeNode(t);
    d1.appendChild(b);
})

d1.addEventListener("click", function(event){
    alert("d1");
    
    console.log(event.target);
    // event.target = > getElementById();와 같음
    if(event.target.id=="b1"){
    alert("button");
    }
});

// b1.addEventListener("click",function(){
//     alert("b1");
// })


// for(h of h1){
//     h.addEventListener("click", function(event) {
//         alert("h1");
//         console.log("event : ", event);
        
//     })
// }

// 버블링        <-> 캡쳐링
// 실행순서: 자식-> 부모
// defalut는 버블링



// console 쉼표만 해도 +효과


// event를 눌러서 나온 내용에 event를 걸고 싶을 때 사용

const ul1 = document.getElementById("ul1");
const btn1 = document.getElementById("btn1");

btn1.addEventListener("click", function(){
    
    let b11 = document.createElement("btn1");
    let b12 = document.createAttribute("type");
    
    b12.value="button";
    b11.setAttributeNode(b12);
    
    b12 = document.createAttribute("value");
    b12.value="CLICK";
    b11.setAttributeNode(b12);

    b12 = document.createAttribute("id");
    b12.value="id";
    b11.setAttributeNode(b12);
    ul1.appendChild(b11);
})


const del = document.getElementById("del");

del.addEventListener("click", function(){
    d1.remove();
})