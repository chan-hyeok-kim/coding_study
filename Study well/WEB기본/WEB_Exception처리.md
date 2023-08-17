# 웹 관련해서 예외 처리 

### 일반적인 처리

1. 컨트롤러를 따로 만들어서 처리(spring에서 제공하는 어노테이션 활용)
2. WEB.XML에 가야할 경로 지정

ex)
```

  <error-page>
    <error-code>404</error-code>
    <location>/WEB-INF/views/errors/front_error.jsp</location>
  </error-page>
  //컨트롤러 없이
  
   <error-page>
    <error-code>400</error-code>
    <location>/error/front</location>
  </error-page>
  //컨트롤러로 보내는 경로

```

3. 컨트롤러 만들 시 @ControllerAdvice사용 가능
 - app 내에서 발생한 모든 Exception을 처리하는 Controller

ex)
```

@ControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(NullPointerException.class)
	public void error1() throws Exception{
		
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public void error2() throws Exception{
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public void error3() throws Exception{
		
	}

```

 - 위에서부터 순서대로 처리하기 때문에
 - 위에서 처리한 예외는 아래까지 코드가 도달하지 않음


### 500번대 한정해서 어노테이션 사용

1) 각각 컨트롤러 내부에 예외 처리하는 메서드 선언
2) 단점: 컨트롤러마다 메서드를 선언해줘야 함

ex)
```

@ExceptionHandler(Exception.class)
	public String serverError2(Exception ex,Model model) throws Exception{
		ex.getMessage();
		return "";
	}

```

