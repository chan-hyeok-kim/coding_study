### Servlet

1. 새로운 servlet 생성
2. Web.xml파일 수정
  (tomcat에게 servlet 객체 생성)

```
<servlet-name>fc</servlet-name>
//servlet 참조 변수 이름 선언
<servlet-class>com.iu.main.FrontController</servlet-class>
//servlet 참조 변수 선언하는 클래스명

```  

3. web.xml전체내용

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
 
    <!-- Tomcat(Was)에게 Servlet 객체 생성 -->
    <servlet>
        <servlet-name>fc</servlet-name>
        <servlet-class>com.iu.main.FrontController</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>fc</servlet-name>
        <url-pattern>/</url-pattern>
        <!-- /들어가는 애들은 fc를 실행해라 -->
    </servlet-mapping>

</web-app>

```


```

<servlet><!--객체를 만들어주세요 -->
        <servlet-name>bbc</servlet-name>
        <servlet-class>com.iu.main.bankBook.BankBookController</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>bbc</servlet-name>
        <url-pattern>/bankbook/*</url-pattern>
    </servlet-mapping>

```




4. Servlet 파일 수정
* JSP가 없을 땐 아래처럼 쓰기도 함
* JSP가 등장하면서 순수한 컨트롤러(제어)의 역할이 되었고, 출력 기능은 JSP가 담당하게 됨

```

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BankBookDAO bankBookDAO = new BankBookDAO();
	try {	
		ArrayList<BankBookDTO> ar = bankBookDAO.BankBookList();
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<h1>Home Page<h1>");
		for(int i=0; i<ar.size(); i++) {
			out.println("<h3>"+ar.get(i).getBookName()+"<h3>");
			out.println("<h3>"+ar.get(i).getBookRate()+"<h3>");
		}
	}catch(Exception e){
		e.printStackTrace();
	}

	}

```

5. 루트 경로

```

http://192.168.9.13:82/GDJ68_Servlet/

프로젝트명까지 써줘야 한다


```
