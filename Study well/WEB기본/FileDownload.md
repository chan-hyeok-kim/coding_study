### Download

```

1. File Down 기능으로 사용할  Class 선언
2. View의 기능을 사용하기위해 AbstractView 상속
3. renderMergedOutputModel 오버라이딩

```

* 다운로드 시에는 우리가 직접 바이너리코드로 바꿔서 클라이언트에게 보내줌
* jsp(InternalResourceview)나 리다이렉트가 목적이 아니기 때문에 View를 따로 만들어줘야 함

### 준비

- servlet-context.xml에 선언
```

<beans:bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
		<beans:property name="order" value="0"></beans:property>
	</beans:bean>

// 인터널리소스뷰리졸버는 순서0으로 만들기
```




### View

```

@Component("fileDownView")
public class FileDownView extends AbstractView {
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FileDownView");
		BoardFileDTO boardFileDTO = (BoardFileDTO)model.get("boardFile");
		
//		Iterator<String> it = model.keySet().iterator();
//		
//		while(it.hasNext()) {
//			String key = it.next();
//			System.out.println("Key : "+key);
//		}
		// Key : boardName, boardFile
		
		//경로 준비
		String path = (String)model.get("boardName");
		path = "resources/upload/"+path+"/";
		
		path = request.getSession().getServletContext().getRealPath(path);
		
		File file = new File(path, boardFileDTO.getFileName());
		
		//응답시 한글 Encoding 처리
        //web.xml에 인코딩 설정되어 있으면 안해도됨
		response.setCharacterEncoding("UTF-8");
		
		//파일의 크기
		response.setContentLength((int)file.length());
		
		//다운시 파일이름을 지정하고 인코딩 설정
		String downName = boardFileDTO.getOriName();
		downName = URLEncoder.encode(downName, "UTF-8");
		
		//Header 정보 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//전송
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		
		//자원 해제
		os.close();
		fi.close();
	}

}

```