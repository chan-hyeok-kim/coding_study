### RestTemplate의 특징
 · Spring 3.0 부터 지원하는 Spring의 HTTP 통신 템플릿
 · HTTP 요청 후 JSON, XML, String 과 같은 응답을 받을 수 있는 템플릿
 · Blocking I/O 기반의 동기방식을 사용하는 템플릿
 · RESTful 형식에 맞추어진 템플릿
 · Header, Content-Tpye등을 설정하여 외부 API 호출
 · Server to Server 통신에 사용


### RestTemplate 동작 원리
1. 애플리케이션 내부에서 REST API에 요청하기 위해 RestTemplate의 메서드를 호출한다.
2. RestTemplate은 MessageConverter를 이용해 java object를 request body에 담을 message(JSON etc.)로 변환한다. 메시지 형태는 상황에 따라 다름
3. ClientHttpRequestFactory에서 ClientHttpRequest을 받아와 요청을 전달한다.
4. 실질적으로 ClientHttpRequest가 HTTP 통신으로 요청을 수행한다.
5. RestTemplate이 에러핸들링을 한다.
6. ClientHttpResponse에서 응답 데이터를 가져와 오류가 있으면 처리한다.
7. MessageConverter를 이용해 response body의 message를 java object로 변환한다.
8. 결과를 애플리케이션에 돌려준다.
※ RestTemplate은 통신 과정을 ClientHttpRequestFactory(ClientHttpRequest, ClientHttpResponse)에 위임합니다. ClientHttpRequestFactory의 실체는 HttpURLConnection, Apache HttpComponents, HttpClient와 같은 HTTP Client
