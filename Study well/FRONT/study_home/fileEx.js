

const div1 = document.getElementById("div1");
const btn = document.getElementById("btn");

let count=0;

div1.addEventListener("click", function(event){

   if(event.target.classList.contains("sc")){
      let deleteId = event.target.getAttribute("data-id");
      document.getElementById(deleteId).remove(); 
      count--;
   } 
   
})


btn.addEventListener("click",function(){
    
    count++;
    if(count>5){
       alert("파일 등록은 5개까지입니다");
    }else{
    let div2 = document.createElement("div");
    let div2a = document.createAttribute("id"); 
    let idx = 0;
    
    div2a.value = "file"+idx;
    div2.setAttributeNode(div2a);
    
    let input1 = document.createElement("input");
    
    let t = document.createAttribute("type");
    t.value = "file";
    input1.setAttributeNode(t);

    div2.appendChild(input1);
    btn.after(div2);
    
    let s = document.createElement("span");
    let t1 = document.createTextNode("삭제");
    s.appendChild(t1);

    let sc  = document.createAttribute("class");
    sc.value = "sc";
    s.setAttributeNode(sc); 

    let spanf = document.createAttribute("data-id");
    spanf.value= "file"+idx;
    s.setAttributeNode(spanf);

    div2.append(s);
    

    
    idx++;
    }
})