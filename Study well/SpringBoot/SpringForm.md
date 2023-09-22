### 스프링 폼 

* 프론트에서는 JS검증이 일어나지만,
* 백엔드에서는 스프링 검증 필요하기 때문에 사용


```
API 설정

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

```


### spring form 사용 방법
```

1. 입력 폼이 있는 JSP로 이동 전 Controller에서 Data가 없는 빈 VO객체를 Model 담아서 전송
	@GetMapping("add")
	public void setAdd(@ModelAttribute MemberVO memberVO)throws Exception{
		//MemberVO memberVO = new MemberVO();
		//model.addAttribute(memberVO);
	}

2. JSP에 form 태그를 HTML form 이 아니라 Spring form 태그 사용
	1) JSP 선언부에 Spring form 태그를 사용할 수 있도록 taglib 추가
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	2) Spring Form Tag
		<form:form action="./add" modelAttribute="memberVO" method="post" enctypye="">
		- action은 생략 가능, 현재 URL이 action으로 지정
		- modelAttribute 는 Controller에서 Model에 추가한 Bean의 속성명
		- 속성명을 지정하지 않으면 클래스명의 첫글자를 소문자로 바꾼 것이 속성명으로 지정
	
		<form:input path="">
		- path     : Bean의 getter의 이름, HTML input 태그의 name과 비슷한 역할
		- cssClass : css 사용을 위한 HTML의 class 속성

		<form:errors path="id"></form:errors>
		- Back-end에서 검증에 위반 되었을 경우 에러메세지 출력


```


### Form 검증


```

1. Controller 메서드의 검증할 VO 앞에 @Valid 선언하면 검증을 실행
2. 검증 결과를 BindingResult에 저장
3. !!!!!!!!!!! 중요 !!!!!!!!!!!!!
	 선언순서를 지켜 줘야 함
	 @Valid vo, BindingResult 

@PostMapping("add")
	public ModelAndView setAdd(@Valid MemberVO memberVO, BindingResult bindingResult, ModelAndView mv)throws Exception{
		
		if(bindingResult.hasErrors()) {
			//검증에 실패하면 회원가입하는 jsp로 foward
			mv.setViewName("member/add");
			return mv;
		}
		
		int result = memberService.setAdd(memberVO); 
		
		mv.setViewName("redirect:../");
		return mv;
	}

```


### 검증 Annotation


```

검증할 VO의 멤버변수 선언부에 작성

참조 : https://beanvalidation.org/

1. @NotEmpty          : Null 허용하지 않음, 공백문자 허용
2. @NotBlank          : Null 허용하지 않음, 문자 1개이상 포함
3. @NotNull           : Null 허용하지 않음
4. @Null              : Null 허용 함
5. @Max(value=지정값) : 최대지정값 보다 작거나 같은값들만 허용
6. @Min(value=지정값) : 최소지정값 보다 크거나 같은값들만 허용
7. @Size(max=값, min=값) : 문자열이나 배열 의 길이 가 min이상 max이하 허용
8. @Pattern(regexp="정규표현식", flag="") : 정규표현식으로 검증
9. @AssertFalse       : false 여부 
10. @AssertTrue       : true 여부
11. @Future           : 미래 날짜 여부
12. @Past             : 과거 날짜 여부
13. @Email            : 이메일 형식
14. @Length(min="값", max="값") : 문자열 길이 검증
15. @Range(min="값", max="값")  : 숫자 범위 검증
16. @URL              : URL 형식 검증


@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*\\\\W)(?=\\\\S+$).{6,12}")
private String pw;

```


### 검증 message

```

1. 검증 Annotation의 속성 message의 값을 변경

@NotBlank(message = "ID는 꼭 필요해!!!")
private String id;

2. 검증 메세지를 message.properties에 등록 후 사용

a. 검증Annotation=메세지
b. 검증Annotation.멤버변수명=메세지
c. 검증Annotation.vo명(BeanName).멤버변수명=메세지

우선순위 c>b>a>1

3. message에 변수를 사용해서 출력 하는 경우
	- 검증 Annotation의 속성의 인덱스 번호 이용
	- 정해진 순서가 있음
	- 코드 작성시 임의로 순서를 바꿀 수 없음

	@Size(min=4, max=10)
	private String pw;
	{0}  : 멤버변수명
	{1}  : max
	{2}  : min

	message.properties
	Size.memberVO.pw={0}는 {2} 글자 이상 {1} 글자 이하여야 함


```

### 사용자 정의 검증

```
Annotation으로 검증하지 못하는 것들을 사용자 정의 코드로 작성

1. 사용자 정의 검증을 할 메서드나 클래스를 생성
	 a. 기존 service에 검증할 메서드를 선언
	 b. 새로운 검증 클래스를 생성하고 메서드 선언

-- 기존 service 메서드 선언
	//사용자 정의 검증 메서드
	public boolean getMemberError(MemberVO memberVO, BindingResult bindingResult)throws Exception{
		boolean check=false;
		//check=false : 검증성공(error 없음)
		//check=true  : 검증실패(error 있음)
		
		//1. annotation 검증
		check = bindingResult.hasErrors();
		
		//2. password가 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPwCheck())) {
			check=true;
			//에러메세지
			//bindingResult.rejectValue("멤버변수명(path)", "properties의key(코드)");
			bindingResult.rejectValue("pwCheck", "member.password.notEqual");
			
		}
		
		//3. id가 중복 인지 검증
		int result = memberMapper.getIdCheck(memberVO);
		if(result>0) {
			check=true;
			bindingResult.rejectValue("id", "member.id.equal");
		}
		
		return check;
		
	}

2. message.properties에 사용자 정의 메세지 코드 등록
	 ### Custom message
	 member.password.notEqual=Password가 일치하지 않습니다
	 member.id.equal=이미사용중인 ID입니다

3. Controller에서 사용자 정의 검증 메서드 호출
	@PostMapping("add")
	public ModelAndView setAdd(@Valid MemberVO memberVO, BindingResult bindingResult, ModelAndView mv)throws Exception{
		
		boolean check = memberService.getMemberError(memberVO, bindingResult);
		if(check) {
			log.info("===== 검증 에러 발생 =====");
			mv.setViewName("member/add");
			return mv;
		}
		...


```