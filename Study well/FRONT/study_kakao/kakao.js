
let container = document.getElementById('map');
let xl = 33.450701
let yl = 126.570667
// let x = 35.9766482774579
// let y = 126.99597495347
getMap(xl, yl);

function getMap(xl, yl) {
    let options = {
        center: new kakao.maps.LatLng(xl, yl),
        level: 3
    };
    let map = new kakao.maps.Map(container, options);
}




const address = document.getElementById("address");
const btn = document.getElementById("btn");
let search = document.getElementById("search");

btn.addEventListener("click", () => {
    address.innerHTML="";
    let query = search.value;
    let url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + query;
    searchRequest(url);
})


function searchRequest(url) {

    fetch(url, {
        method: "get",
        headers: {
            "Authorization": "KakaoAK ad31c6a5aaaa8e58d6a71df13e7a8cbd"
        }
    })
        .then((response) => { return response.json() })
        .then((r) => {
            console.log(r);

            for (d of r.documents) {
                let div1 = document.createElement("div");
                let t = document.createTextNode(d.address.address_name);
                div1.appendChild(t);

                let x = document.createAttribute("data-x");
                x.value = d.x;
                div1.setAttributeNode(x);

                x = document.createAttribute("class");
                x.value = "c1";
                div1.setAttributeNode(x);

                x = document.createAttribute("data-y");
                x.value = d.y;
                div1.setAttributeNode(x);

                address.appendChild(div1);

            }
        })
}


address.addEventListener("click", (e) => {
    if (e.target.classList.contains("c1")) {
        let x = e.target.getAttribute("data-x");
        let y = e.target.getAttribute("data-y");
        getMap(y, x);

    }
})