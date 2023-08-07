{/* <div class="input-group">
<input type="file" name="files" class="form-control" id="bankfile" aria-label="Upload">
</div> */}

const btn1 = document.getElementById("btn1");
let count = 0;
let idx = 0;

const fileList = document.getElementById("fileList");
        
fileList.addEventListener("click",function(event){
    let cl = event.target.classList;
    if(event.target.classList.contains("df")){
        let deleteId = event.target.getAttribute("data-id");
        document.getElementById(deleteId).remove();
        count--;
        
       }
    
})

btn1.addEventListener("click", function(){
    count++;
if(count>5){
    alert("최대 업로드 수는 5개입니다");
}
   
    let d2 = document.createElement("div");
    let a = document.createAttribute("class");
    a.value= "input-group";
    d2.setAttributeNode(a);

    a = document.createAttribute("id");
    a.value = "file"+idx;
    d2.setAttributeNode(a);

    let f2 = document.createElement("input");
    let f1 = document.createAttribute("type");
    f1.value = "file";
    f2.setAttributeNode(f1);
    
    f1 = document.createAttribute("name");
    f1.value = "files";
    f2.setAttributeNode(f1);

    f1 = document.createAttribute("class");
    f1.value = "form-control";
    f2.setAttributeNode(f1);

    f1 = document.createAttribute("aria-lable");
    f1.value = "upload";
    f2.setAttributeNode(f1);
    
    d2.appendChild(f2);
    btn1.after(d2);

    
  
    let s = document.createElement("span");
    let t = document.createTextNode("x");
    f1 = document.createAttribute("class");
    f1.value = "df";
    s.setAttributeNode(f1);

    f1 = document.createAttribute("data-id");
    f1.value="file"+idx;
    s.setAttributeNode(f1);
    
    s.appendChild(t);
    d2.appendChild(s);
    
    idx++;

})

