### 1. tiles 환경설정

1. pom.xml에 해당 라이브러리 설치(maven)

```

 <!-- tiles-jsp -->
	<dependency>
	    <groupId>org.apache.tiles</groupId>
	    <artifactId>tiles-jsp</artifactId>
	    <version>3.0.8</version>
	</dependency>
	
	<!-- tiles/tiles-el -->
	<dependency>
	    <groupId>org.apache.tiles</groupId>
	    <artifactId>tiles-el</artifactId>
	    <version>3.0.8</version>
	</dependency>

	<!-- tiles-api -->
	<dependency>
	    <groupId>org.apache.tiles</groupId>
	    <artifactId>tiles-api</artifactId>
	    <version>3.0.8</version>
	</dependency>

```

### 2. tiles configuration 환경 설정 클래스

```

package com.ham.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.SimpleSpringPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TileConfig implements WebMvcConfigurer {
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer configurer = new TilesConfigurer();
		
		configurer.setDefinitions(new String[]{"/WEB-INF/tiles.xml"});
		configurer.setCheckRefresh(true);
		configurer.setPreparerFactoryClass(SimpleSpringPreparerFactory.class);
		return configurer;
	}

	@Bean
	public TilesViewResolver tilesViewResolver() {
		final TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		tilesViewResolver.setOrder(1);
		
		return tilesViewResolver;
	}
	
	@Bean
	public UrlBasedViewResolver viewResolver() {
	    final UrlBasedViewResolver resolver = new UrlBasedViewResolver();
	    resolver.setViewClass(TilesView.class);
	    resolver.setOrder(1);	      
	      
	    return resolver;
	 }
	 
}


```

### 3. tiles.xml

1. 사용 시 가장 중요한 부분.

```

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE tiles-definitions PUBLIC  
        "-//Apache Software Foundation//DTD Tiles Configuration 3.0//EN"  
        "http://tiles.apache.org/dtds/tiles-config_3_0.dtd">
<tiles-definitions>
<!-- #layout -->
	<definition name="layout" template="/WEB-INF/views/layout/layout.jsp">
		<put-attribute name="headCSS" value="/WEB-INF/views/layout/headCSS.jsp"/>
		<put-attribute name="sidebar" value="/WEB-INF/views/layout/sidebar.jsp"/>
		<put-attribute name="topbar" value="/WEB-INF/views/layout/topbar.jsp"/>
		<put-attribute name="footer" value="/WEB-INF/views/layout/footer.jsp"/>
		<put-attribute name="footjs" value="/WEB-INF/views/layout/footjs.jsp"/>
	    <put-attribute name="body" value="" />
	</definition>

	<!-- controller view 받은 후 -->
	<definition name="index" extends="layout">
	  <put-attribute name="body" value="/WEB-INF/views/index.jsp"/>
	</definition>

    <definition name="notice/list" extends="layout">
	  <put-attribute name="body" value="/WEB-INF/views/noticejsp"/>
	</definition>
	
</tiles-definitions>

```

2. 이해를 돕기 위해 하나씩 설명

```
<definition name="layout" template="/WEB-INF/views/layout/layout.jsp">
		
        <put-attribute name="header" value="/WEB-INF/views/layout/header.jsp"/>
       // 헤더일 경우 고정이므로
       // name은 jsp에서 쓸 변수명을 임의로 설정, 
       // value는 "/WEB-INF"부터 시작하는 경로를 적어주면 된다

        <put-attribute name="body" value="" />
       // 바디는 계속 바뀌어야 하므로
        
        </definition>
```

3. 바디는 아래처럼 추가해준다.

```
<definition name="index" extends="layout">
    //name속성은 컨트롤러에서 리턴한 경로
    //(/WEB-INF/views/이후부터 써주면 됨)
    //extends속성은 참고하고자 하는 레이아웃의 name명

	  <put-attribute name="body" value="/WEB-INF/views/index.jsp"/>
	</definition>


```

4. JSP에서 사용하는 법
   - 태그 라이브러리 선언(필수) 
   - <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
   - <tiles:insertAttribute name="header"/>를 써서 불러온다.
   - 이때, name은 XML설정 파일에 등록된 name명과 같아야 한다

   - 예시)layout.jsp
```

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<tiles:insertAttribute name="header" />
<body>
				<tiles:insertAttribute name="body" />
</body>
</html>

```


1. xml 설정 고친 후엔 반드시 리스타트!