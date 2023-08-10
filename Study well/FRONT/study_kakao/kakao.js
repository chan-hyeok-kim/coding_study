
let container = document.getElementById('map');
let xl = 33.450701
let yl = 126.570667
// let x = 35.9766482774579
// let y = 126.99597495347
getMap(xl, yl);
getRoadView(xl, yl);
getMarker(xl, yl);

function getMap(xl, yl) {
    let options = {
        center: new kakao.maps.LatLng(xl, yl),
        level: 3
    };
    let map = new kakao.maps.Map(container, options);
}

function getRoadView(xl, yl){
    let roadviewContainer = document.getElementById('roadview'); //로드뷰를 표시할 div
    let roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
    let roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체
    
    let roadViewPosition = new kakao.maps.LatLng(xl, yl);
    
    // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
    roadviewClient.getNearestPanoId(roadViewPosition, 50, function(panoId) {
        roadview.setPanoId(panoId, roadViewPosition); //panoId와 중심좌표를 통해 로드뷰 실행
    });

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapCenter = new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심 좌표
    mapOption = {
        center: mapCenter, // 지도의 중심 좌표
        level: 4 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 지도에 올릴 마커를 생성합니다.
var mMarker = new kakao.maps.Marker({
    position: mapCenter, // 지도의 중심좌표에 올립니다.
    map: map // 생성하면서 지도에 올립니다.
});

// 지도에 올릴 장소명 인포윈도우 입니다.
var mLabel = new kakao.maps.InfoWindow({
    position: mapCenter, // 지도의 중심좌표에 올립니다.
    content: 'search' // 인포윈도우 내부에 들어갈 컨텐츠 입니다.
});
mLabel.open(map, mMarker); // 지도에 올리면서, 두번째 인자로 들어간 마커 위에 올라가도록 설정합니다.



var rvContainer = document.getElementById('roadview'); // 로드뷰를 표시할 div
var rv = new kakao.maps.Roadview(rvContainer); // 로드뷰 객체 생성
var rc = new kakao.maps.RoadviewClient(); // 좌표를 통한 로드뷰의 panoid를 추출하기 위한 로드뷰 help객체 생성
var rvResetValue = {} //로드뷰의 초기화 값을 저장할 변수
rc.getNearestPanoId(mapCenter, 50, function(panoId) {
    rv.setPanoId(panoId, mapCenter);//좌표에 근접한 panoId를 통해 로드뷰를 실행합니다.
    rvResetValue.panoId = panoId;
});



    kakao.maps.event.addListener(rv, 'init', function() {

        // 로드뷰에 올릴 마커를 생성합니다.
        var rMarker = new kakao.maps.Marker({
            position: mapCenter,
            map: rv //map 대신 rv(로드뷰 객체)로 설정하면 로드뷰에 올라갑니다.
        });
    
        // 로드뷰에 올릴 장소명 인포윈도우를 생성합니다.
        var rLabel = new kakao.maps.InfoWindow({
            position: mapCenter,
            content: '스페이스 닷원'
        });
        rLabel.open(rv, rMarker);
    
        // 로드뷰 마커가 중앙에 오도록 로드뷰의 viewpoint 조정 합니다.
        var projection = rv.getProjection(); // viewpoint(화면좌표)값을 추출할 수 있는 projection 객체를 가져옵니다.
        
        // 마커의 position과 altitude값을 통해 viewpoint값(화면좌표)를 추출합니다.
        var viewpoint = projection.viewpointFromCoords(rMarker.getPosition(), rMarker.getAltitude());
        rv.setViewpoint(viewpoint); //로드뷰에 뷰포인트를 설정합니다.
    
        //각 뷰포인트 값을 초기화를 위해 저장해 놓습니다.
        rvResetValue.pan = viewpoint.pan;
        rvResetValue.tilt = viewpoint.tilt;
        rvResetValue.zoom = viewpoint.zoom;
    });
    
    //지도 이동 이벤트 핸들러
    function moveKakaoMap(self){
        
        var center = map.getCenter(), 
            lat = center.getLat(),
            lng = center.getLng();
    
        self.href = 'https://map.kakao.com/link/map/' + encodeURIComponent('스페이스 닷원') + ',' + lat + ',' + lng; //Kakao 지도로 보내는 링크
    }
    
    //지도 초기화 이벤트 핸들러
    function resetKakaoMap(){
        map.setCenter(mapCenter); //지도를 초기화 했던 값으로 다시 셋팅합니다.
        map.setLevel(mapOption.level);
    }
    
    //로드뷰 이동 이벤트 핸들러
    function moveKakaoRoadview(self){
        var panoId = rv.getPanoId(); //현 로드뷰의 panoId값을 가져옵니다.
        var viewpoint = rv.getViewpoint(); //현 로드뷰의 viewpoint(pan,tilt,zoom)값을 가져옵니다.
        self.href = 'https://map.kakao.com/?panoid='+panoId+'&pan='+viewpoint.pan+'&tilt='+viewpoint.tilt+'&zoom='+viewpoint.zoom; //Kakao 지도 로드뷰로 보내는 링크
    }
    
    //로드뷰 초기화 이벤트 핸들러
    function resetRoadview(){
        //초기화를 위해 저장해둔 변수를 통해 로드뷰를 초기상태로 돌립니다.
        rv.setViewpoint({
            pan: rvResetValue.pan, tilt: rvResetValue.tilt, zoom: rvResetValue.zoom
        });
        rv.setPanoId(rvResetValue.panoId);
    }



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
        getRoadView(y, x);
        getMarker(y, x);
     
    }
})



function getMarker(xl,yl){


let mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(xl, yl), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

let map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
let markerPosition  = new kakao.maps.LatLng(xl, yl); 

// 마커를 생성합니다
let marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);





 mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(xl, yl), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

 map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커를 표시할 위치입니다 
let position =  new kakao.maps.LatLng(xl, yl);

// 마커를 생성합니다
 marker = new kakao.maps.Marker({
  position: position
});

// 마커를 지도에 표시합니다.
marker.setMap(map);

// 마커에 커서가 오버됐을 때 마커 위에 표시할 인포윈도우를 생성합니다
iwContent = '<div style="padding:5px;">Hello World!</div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다

// 인포윈도우를 생성합니다
infowindow = new kakao.maps.InfoWindow({
    content : iwContent
});

// 마커에 마우스오버 이벤트를 등록합니다
kakao.maps.event.addListener(marker, 'mouseover', function() {
  // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
    infowindow.open(map, marker);
});

// 마커에 마우스아웃 이벤트를 등록합니다
kakao.maps.event.addListener(marker, 'mouseout', function() {
    // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
    infowindow.close();
}
);

kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    let latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    let message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
 
    let resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
});


}



