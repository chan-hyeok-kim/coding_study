### Ajax(Asynchronous JavaScript And XML)

* default는 동기방식
* 비동기 방식 ex)네이버 스포츠 응원 오픈톡

김치볶음밥 예시
프라이팬 1개라서 볶음밥을 볶고 나서 프라이 -> 동기
프라이팬 2개 이상이라서 볶음밥을 만들면서 프라이 -> 비동기

* 응답을 받을때까지 4번 왔다갔다함
* 4wayhandshaking





```

1. XMLHttpRequest
let xhttp = new XMLHttpRequest();

            xhttp.open("POST", "../noticeReply/update");
        
            //요청 header 정보. post일때만 보내줌
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

						//POST 파라미터 전송
            xhttp.send("replyNum="+replyNum+"&contents="+contents);
    
    
            xhttp.onreadystatechange=function(){
                if(this.readyState==4 && this.status==200){
                    if(this.responseText.trim()=='1'){
                        alert('수정 성공');
                        document.querySelector("#up"+replyNum).innerHTML=contents;
                    }else {
                        alert('수정 실패');
                    }
                }

1. fetch
	 fetch(url, [options])
	 - url : 요청 URL
	 - options : method나, header등 지정

	a. options
		 method: 메서드 형식
		 headers : 헤더 값 전달( {content-type:'application/json'}
		 body:요청시 전달할 값 
     mode:CORS값 설정 (cors, no-cors, same-origin)
		 credencial : 자격 증명을 위한 옵션(include, same-origin, omit, default=same-origin)
		 cache: 캐시 사용 여부 (no-cache, reload, force-cache, only-if-cache)

	b. 요청 형식
		fetch(URL, {
				method:"",
				headers: {},
			  body: JSON.stringfy(data), //JSON data를 String type으로 변환
		})
		//응답객체에서 Data 추출
		.then((response)=> response.text()) // (response)=> {return response.text()}
		//추출한 Data 사용
		.then((res)=> console.log(res))
		//예외 발생시 처리
		.catch(()=>console.log('에러 발생'))


	c. 결과처리
		result.text()
		응답을 읽고 텍스트를 반환
		
		result.json()
		응답을 읽고 JSON으로 반환

		result.blob()
		응답을 읽고 BLOB(바이너리 데이터)형태로 반환

	d. Post 요청시 파라미터 
		1) 일반
		fetch(URL, {
				method : 'POST',
				headers:{
                "Content-type":"application/x-www-form-urlencoded"
            },
        body:"num=123&contents=test"
		
		}...

	2) Controller 메서드에 @RequestBody


```