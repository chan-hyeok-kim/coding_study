
const productList = document.getElementById("productList");

let url = "https://dummyjson.com/products?skip=10&limit=10"
fetch(url, {
    method: "get"
    // headers: {
    //     "Authorization:" KakaoAK ${REST_API_KEY}
    // }
})
    .then((result) => { return result.json() })
    .then((list) => {
        console.log(list)
        console.log(list.products[0].title);
       
        for(product of list.products){
            let div2= document.createElement("div"); 
            let cl2 = document.createAttribute("class");
            cl2.value="col mb-5 h-100";
            div2.setAttributeNode(cl2);
            
            let img = document.createElement("img");
            let s = document.createAttribute("src");
            s.value=product.thumbnail; 
            img.setAttributeNode(s);
            div2.appendChild(img);
            

            let h = document.createElement("h2");
            let t = document.createTextNode(product.title);
            h.appendChild(t);
            div2.appendChild(h);
            
            let p = document.createElement("p");
            let t1 = document.createTextNode(product.description);
            p.appendChild(t1);
            div2.appendChild(p);
            productList.append(div2);

// 변수 엘리먼트랑 속성명은 다시사용해도됨
        }



    })

//     <div class="col mb-5 h-100">
//     <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
//     <img src="" ></i></div>
// <h2 class="h5">TITLE</h2>
// <p class="mb-0">description</p>
// </div>