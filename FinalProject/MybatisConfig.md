## Mybatis 환경설정

DB에서는 스네이크.
자바에서는 카멜을 쓰기로 했기 때문에
따로 환경 설정을 할 필요가 있었다.

### 1. MybatisConfig 추가

```
package com.ham.len.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = {"com.ham.len"}
                         ,sqlSessionFactoryRef="sqlSessionFactory"
                         ,sqlSessionTemplateRef="sqlSessionTemplate")

public class MybatisConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
        
		 // mapper.xml 의 resultType 패키지 주소 생략
		sqlSessionFactoryBean.setTypeAliasesPackage("com.ham.len");
        
		// mybatis 설정 파일 세팅
		sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        
		// mapper.xml 위치 패키지 주소
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/database/mappers/*Mapper.xml"));
        
		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name="sqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}




```


### 2. resources아래에 mybatis-config.xml 추가

```

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
	<settings>
	    <!-- 카멜 케이스 VO 매핑 -->       
		<setting name="mapUnderscoreToCamelCase" value="true"/>
		
		 <!-- 쿼리 결과 필드가 null인 경우, 누락이 되서 나오지 않게 설정-->
		<setting name="callSettersOnNulls" value="true"/>
		
		 <!-- 쿼리에 보내는 파라미터가 null인 경우, 오류가 발생하는 것 방지 -->
		<setting name="jdbcTypeForNull" value="NULL"/>
	</settings>
</configuration>

```