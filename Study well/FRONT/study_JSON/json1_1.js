
// const btn = document.getElementById("btn");
const btn = document.querySelector("#btn");
// const num = document.getElementByClassName("num");
// const num = document.querySelectorAll(".num");
const num = document.querySelectorAll("#num")[0];
const t = document.querySelectorAll(".t");
let images1 = document.getElementsByClassName("images1");

btn.addEventListener("click", ()=>{
    let url = "https://dummyjson.com/products/"+num.value;
    fetch(url, {
        method:"get",
        // mode:"no-cors",
        // headers:{
        //     'Access-Control-Allow-Origin':'*'
        // }
    })
    .then((response)=>{return response.json()})
    .then((r)=>{
        //  let j = JSON.parse(r);
        console.log(r.title);
        const images = document.getElementById("images");
        images.innerHTML="";
        for(i of r.images){
            let img = document.createElement("img");
            let a = document.createAttribute("src");
            a.value = i;
            img.setAttributeNode(a);
            images.append(img);
        }   
        
        t[0].innerHTML=r.title;
        t[1].innerHTML=r.price;
        t[2].innerHTML=r.discountPercentage;
        t[3].innerHTML=r.rating;

        
        
    })


})

